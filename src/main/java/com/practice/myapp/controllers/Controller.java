package com.practice.myapp.controllers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.practice.myapp.models.AirQuality;
import com.practice.myapp.models.Measurements;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.net.ssl.HttpsURLConnection;
import javax.validation.Valid;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.Collection;

@org.springframework.stereotype.Controller
@RequestMapping("/")
public class Controller {

    private String BaseURL;
    private String AqiURL;
    private String decodedString;
    private String json;
    private String aqiDecodedString;
    private String aqiJson;
    private String mapsKey = "AIzaSyDen0WZLZt-OQ68yU5D5uoNb7sr34mdycQ";
    private String aqiKey = "3RDkWgP8CSpxMTGFM";


    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("title", "Pick A Location");
        model.addAttribute("measurements", new Measurements());

        return "index";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String result(Model model,
                         @ModelAttribute @Valid Measurements newMeasurement,
                         Errors errors) throws IOException {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Pick A Location");
            return "index";
        }

        decodedString = "";
        json = "";
        aqiDecodedString = "";
        aqiJson = "";
        int aDistance = newMeasurement.getDistance();
        double aLatitude = newMeasurement.getRadLat();
        double aLongitude = newMeasurement.getRadLng();

        BaseURL = "https://api.safecast.org/measurements.json";
        AqiURL = "https://api.airvisual.com/v2/nearest_city";

        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        Gson aqiGson = new Gson();

        HttpsURLConnection apiCall = (HttpsURLConnection) (new URL(BaseURL + "?distance=" + aDistance
            + "&latitude=" + aLatitude + "&longitude=" + aLongitude).openConnection());
        apiCall.setRequestProperty("Content-Type", "application/json");
        apiCall.setRequestProperty("Accept", "application/json");
        apiCall.setRequestMethod("GET");
        apiCall.connect();

        try {
            BufferedReader inreader = new BufferedReader(new InputStreamReader(apiCall.getInputStream()));
            while ((decodedString=inreader.readLine()) != null) {
                json+=decodedString;
            }
            inreader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        apiCall.disconnect();

        HttpsURLConnection aqiCall = (HttpsURLConnection) (new URL(AqiURL + "?lat=" + aLatitude
            + "&lon=" + aLongitude + "&key=" + aqiKey)).openConnection();

        aqiCall.setRequestProperty("Content-Type", "application/json");
        aqiCall.setRequestProperty("Accept", "application/json");
        aqiCall.setRequestMethod("GET");
        aqiCall.connect();

        try {
            BufferedReader aqiReader = new BufferedReader(new InputStreamReader(aqiCall.getInputStream()));
            while ((aqiDecodedString=aqiReader.readLine()) != null) {
                aqiJson+=aqiDecodedString;
            }
            aqiReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        aqiCall.disconnect();

        Type collectionType = new TypeToken<Collection<Measurements>>(){}.getType();
        Collection<Measurements> safeCastReturns = gson.fromJson(json, collectionType);

        //Type aqiType = new TypeToken<Collection<AirQuality>>(){}.getLocationType();
        AirQuality airVisualReturn = aqiGson.fromJson(aqiJson, AirQuality.class);

        model.addAttribute("title", "Current readings at the given location");
        model.addAttribute("return", safeCastReturns);
        model.addAttribute("latitude", aLatitude);
        model.addAttribute("longitude", aLongitude);
        model.addAttribute("key", mapsKey);
        model.addAttribute("aqi", airVisualReturn);

        return "result";
    }
}

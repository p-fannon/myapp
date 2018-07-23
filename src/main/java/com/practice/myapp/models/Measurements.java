package com.practice.myapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Measurements {

    @Expose
    @SerializedName("id")
    private int radId;
    @Expose
    @SerializedName("user_id")
    private int radUserId;
    @Expose
    @SerializedName("value")
    private double radValue;
    @Expose
    @SerializedName("unit")
    private String radUnit;
    @Expose
    @SerializedName("location_name")
    private String radLocationName;
    @Expose
    @SerializedName("device_id")
    private int radDeviceId;
    @Expose
    @SerializedName("original_id")
    private int radOriginalId;
    @Expose
    @SerializedName("mesaurement_import_id")
    private int radMeasurementImportId;
    @Expose
    @SerializedName("captured_at")
    private String radTimestamp;
    @Expose
    @SerializedName("height")
    private double radHeight;
    @Expose
    @SerializedName("devicetype_id")
    private int radDevicetypeId;
    @Expose
    @SerializedName("sensor_id")
    private int radSensorId;
    @Expose
    @SerializedName("station_id")
    private int radStationId;
    @Expose
    @SerializedName("channel_id")
    private int radChannelId;
    @Expose
    @NotNull
    @SerializedName("latitude")
    private double radLat;
    @Expose
    @NotNull
    @SerializedName("longitude")
    private double radLng;
    @Min(10)
    @Max(1000)
    @NotNull
    private int distance;

    public Measurements() {
    }

    public Measurements(int radId, int radUserId, double radValue, String radUnit, String radLocationName, int radDeviceId, int radOriginalId, int radMeasurementImportId, String radTimestamp, double radHeight, int radDevicetypeId, int radSensorId, int radStationId, int radChannelId, double radLat, double radLng) {
        this.radId = radId;
        this.radUserId = radUserId;
        this.radValue = radValue;
        this.radUnit = radUnit;
        this.radLocationName = radLocationName;
        this.radDeviceId = radDeviceId;
        this.radOriginalId = radOriginalId;
        this.radMeasurementImportId = radMeasurementImportId;
        this.radTimestamp = radTimestamp;
        this.radHeight = radHeight;
        this.radDevicetypeId = radDevicetypeId;
        this.radSensorId = radSensorId;
        this.radStationId = radStationId;
        this.radChannelId = radChannelId;
        this.radLat = radLat;
        this.radLng = radLng;
        this.distance = 10;
    }

    public String getRadUnit() {
        return radUnit;
    }

    public void setRadUnit(String radUnit) {
        this.radUnit = radUnit;
    }

    public double getRadValue() {
        return radValue;
    }

    public void setRadValue(double radValue) {
        this.radValue = radValue;
    }

    public double getRadLat() {
        return radLat;
    }

    public void setRadLat(double radLat) {
        this.radLat = radLat;
    }

    public double getRadLng() {
        return radLng;
    }

    public void setRadLng(double radLng) {
        this.radLng = radLng;
    }

    public String getRadTimestamp() {
        return radTimestamp;
    }

    public void setRadTimestamp(String radTimestamp) {
        this.radTimestamp = radTimestamp;
    }

    public int getRadId() {
        return radId;
    }

    public void setRadId(int radId) {
        this.radId = radId;
    }

    public int getRadUserId() {
        return radUserId;
    }

    public void setRadUserId(int radUserId) {
        this.radUserId = radUserId;
    }

    public String getRadLocationName() {
        return radLocationName;
    }

    public void setRadLocationName(String radLocationName) {
        this.radLocationName = radLocationName;
    }

    public int getRadDeviceId() {
        return radDeviceId;
    }

    public void setRadDeviceId(int radDeviceId) {
        this.radDeviceId = radDeviceId;
    }

    public int getRadOriginalId() {
        return radOriginalId;
    }

    public void setRadOriginalId(int radOriginalId) {
        this.radOriginalId = radOriginalId;
    }

    public int getRadMeasurementImportId() {
        return radMeasurementImportId;
    }

    public void setRadMeasurementImportId(int radMeasurementImportId) {
        this.radMeasurementImportId = radMeasurementImportId;
    }

    public double getRadHeight() {
        return radHeight;
    }

    public void setRadHeight(double radHeight) {
        this.radHeight = radHeight;
    }

    public int getRadDevicetypeId() {
        return radDevicetypeId;
    }

    public void setRadDevicetypeId(int radDevicetypeId) {
        this.radDevicetypeId = radDevicetypeId;
    }

    public int getRadSensorId() {
        return radSensorId;
    }

    public void setRadSensorId(int radSensorId) {
        this.radSensorId = radSensorId;
    }

    public int getRadStationId() {
        return radStationId;
    }

    public void setRadStationId(int radStationId) {
        this.radStationId = radStationId;
    }

    public int getRadChannelId() {
        return radChannelId;
    }

    public void setRadChannelId(int radChannelId) {
        this.radChannelId = radChannelId;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) { this.distance=distance; }
}

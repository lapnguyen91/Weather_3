package com.example.lapnguyen.weather_3.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by lapnguyen on 14/06/2017.
 */

public class Datum {

    @SerializedName("time")
    @Expose

    private int mTime;
    @SerializedName("summary")
    @Expose
    private String mSummary;
    @SerializedName("icon")
    @Expose
    private String mIcon;
    @SerializedName("temperatureMin")
    @Expose
    private double mTemperatureMin;
    @SerializedName("temperatureMax")
    @Expose
    private double mTemperatureMax;
    @SerializedName("humidity")
    @Expose
    private double mHumidity;
    @SerializedName("windSpeed")
    @Expose
    private double mWindSpeed;
    @SerializedName("uvIndex")
    @Expose
    private int mUvIndex;

    public int getTime() {
        return mTime;
    }

    public void setTime(int time) {
        this.mTime = time;
    }

    public String getSummary() {
        return mSummary;
    }

    public void setSummary(String summary) {
        this.mSummary = summary;
    }

    public String getIcon() {
        return mIcon;
    }

    public void setIcon(String icon) {
        this.mIcon = icon;
    }

    public double getTemperatureMin() {
        return mTemperatureMin;
    }

    public void setTemperatureMin(double temperatureMin) {
        this.mTemperatureMin = temperatureMin;
    }

    public double getTemperatureMax() {
        return mTemperatureMax;
    }

    public void setTemperatureMax(double temperatureMax) {
        this.mTemperatureMax = temperatureMax;
    }

    public double getHumidity() {
        return mHumidity;
    }

    public void setHumidity(double humidity) {
        this.mHumidity = humidity;
    }

    public double getWindSpeed() {
        return mWindSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.mWindSpeed = windSpeed;
    }

    public int getUvIndex() {
        return mUvIndex;
    }

    public void setUvIndex(int uvIndex) {
        this.mUvIndex = uvIndex;
    }
}

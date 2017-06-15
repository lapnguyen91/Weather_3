package com.example.lapnguyen.weather_3.data;

import com.google.gson.annotations.SerializedName;

/**
 * Created by lapnguyen on 15/06/2017.
 */

public class Weather {
    private String mCurrentLocation;
    private String mLastUpdateTime;
    private String mWeatherIcon;
    @SerializedName("temperature")
    private double mCurrentTemperature;
    @SerializedName("windSpeed")
    private double mWindSpeed;
    @SerializedName("humidity")
    private double mHumidityPercent;

    public Weather() {
    }

    public String getCurrentLocation() {
        return mCurrentLocation;
    }

    public void setCurrentLocation(String currentLocation) {
        mCurrentLocation = currentLocation;
    }

    public String getLastUpdateTime() {
        return mLastUpdateTime;
    }

    public void setLastUpdateTime(String lastUpdateTime) {
        mLastUpdateTime = lastUpdateTime;
    }

    public String getWeatherIcon() {
        return mWeatherIcon;
    }

    public void setWeatherIcon(String weatherIcon) {
        mWeatherIcon = weatherIcon;
    }

    public double getCurrentTemperature() {
        return mCurrentTemperature;
    }

    public void setCurrentTemperature(double currentTemperature) {
        mCurrentTemperature = currentTemperature;
    }

    public double getWindSpeed() {
        return mWindSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        mWindSpeed = windSpeed;
    }

    public double getHumidityPercent() {
        return mHumidityPercent;
    }

    public void setHumidityPercent(double humidityPercent) {
        mHumidityPercent = humidityPercent;
    }

    public Weather(String currentLocation, String lastUpdateTime, String weatherIcon,
            double currentTemperature, double windSpeed, double humidityPercent) {
        this.mCurrentLocation = currentLocation;
        this.mLastUpdateTime = lastUpdateTime;
        this.mWeatherIcon = weatherIcon;
        this.mCurrentTemperature = currentTemperature;
        this.mWindSpeed = windSpeed;
        this.mHumidityPercent = humidityPercent;
    }
}

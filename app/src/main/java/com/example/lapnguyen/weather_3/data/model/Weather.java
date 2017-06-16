package com.example.lapnguyen.weather_3.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by lapnguyen on 14/06/2017.
 */

public class Weather {

    @SerializedName("latitude")
    @Expose

    private double mLatitude;
    @SerializedName("longitude")
    @Expose
    private double mLongitude;
    @SerializedName("currently")
    @Expose
    private Currently mCurrently;

    public Weather(double latitude, double longitude, Currently currently) {
        this.mLatitude = latitude;
        this.mLongitude = longitude;
        this.mCurrently = currently;
    }

    public double getLatitude() {
        return mLatitude;
    }

    public void setLatitude(double latitude) {
        this.mLatitude = latitude;
    }

    public double getLongitude() {
        return mLongitude;
    }

    public void setLongitude(double longitude) {
        this.mLongitude = longitude;
    }

    public Currently getCurrently() {
        return mCurrently;
    }

    public void setCurrently(Currently currently) {
        this.mCurrently = currently;
    }
}

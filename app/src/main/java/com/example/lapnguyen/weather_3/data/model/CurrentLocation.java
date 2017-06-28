package com.example.lapnguyen.weather_3.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by lapnguyen on 28/06/2017.
 */

public class CurrentLocation {

    @SerializedName("address")
    @Expose
    private Address address;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}

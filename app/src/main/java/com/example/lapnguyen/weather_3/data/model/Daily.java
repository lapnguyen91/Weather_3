package com.example.lapnguyen.weather_3.data.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by lapnguyen on 14/06/2017.
 */

public class Daily {

    @SerializedName("summary")
    @Expose

    private String mSummary;
    @SerializedName("icon")
    @Expose
    private String mIcon;
    @SerializedName("data")
    @Expose
    private List<Datum> mData = null;

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

    public List<Datum> getData() {
        return mData;
    }

    public void setData(List<Datum> data) {
        this.mData = data;
    }
}

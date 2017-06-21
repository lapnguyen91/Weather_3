package com.example.lapnguyen.weather_3.api;

import com.example.lapnguyen.weather_3.data.model.Weather;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by lapnguyen on 16/06/2017.
 */

public interface WeatherService {
    @GET("/forecast/428f2cb27c18bfb39610879d88d33033/{lat},{long}")
    Observable<Weather> getWeather(@Path("lat") Double latitude, @Path("long") Double longitude);
}


package com.example.lapnguyen.weather_3.data.source;

import com.example.lapnguyen.weather_3.data.model.Weather;
import io.reactivex.Observable;

/**
 * Created by lapnguyen on 16/06/2017.
 */

public interface MainRepository {
    Observable<Weather> getWeather(double latitude , double longitude);
}


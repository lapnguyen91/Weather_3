package com.example.lapnguyen.weather_3.data.source;

import com.example.lapnguyen.weather_3.api.WeatherService;

import com.example.lapnguyen.weather_3.data.model.Weather;
import io.reactivex.Observable;

/**
 * Created by lapnguyen on 16/06/2017.
 */
public class MainRepositoryImplement implements MainRepository {
    WeatherService mWeatherService;
    private static MainRepository instance;

    public MainRepositoryImplement(WeatherService weatherService) {
        mWeatherService = weatherService;
    }

    public static MainRepository getInstance(WeatherService weatherService) {
        if (instance == null) {
            instance = new MainRepositoryImplement(weatherService);
        }
        return instance;
    }

    @Override
    public Observable<Weather> getWeather(double latitude, double longitude) {

        return mWeatherService.getWeather(latitude, longitude);
    }
}


package com.example.lapnguyen.weather_3.data.source;

import com.example.lapnguyen.weather_3.api.LocationService;
import com.example.lapnguyen.weather_3.api.WeatherService;
import com.example.lapnguyen.weather_3.data.model.CurrentLocation;
import com.example.lapnguyen.weather_3.data.model.Weather;
import io.reactivex.Observable;

/**
 * Created by lapnguyen on 16/06/2017.
 */
public class MainRepositoryImplement implements MainRepository {
    WeatherService mWeatherService;
    LocationService mLocationService;
    private static MainRepository instance;

    private MainRepositoryImplement(WeatherService weatherService,
            LocationService locationService) {
        mWeatherService = weatherService;
        mLocationService = locationService;
    }

    public static MainRepository getInstance(WeatherService weatherService,
            LocationService locationService) {
        if (instance == null) {
            instance = new MainRepositoryImplement(weatherService, locationService);
        }
        return instance;
    }

    @Override
    public Observable<Weather> getWeather(double latitude, double longitude) {
        return mWeatherService.getWeather(latitude, longitude);
    }

    public Observable<CurrentLocation> getLocationName(double latitude, double longitude) {
        return mLocationService.getLocationName(latitude, longitude);
    }
}

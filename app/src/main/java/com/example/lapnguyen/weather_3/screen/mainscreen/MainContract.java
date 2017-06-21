package com.example.lapnguyen.weather_3.screen.mainscreen;

import com.example.lapnguyen.weather_3.data.model.Weather;

/**
 * Created by lapnguyen on 15/06/2017.
 */

public class MainContract {
    /**
     * View
     */
    public interface View {
        void loadWeatherDetailSuccess(Weather weather);
    }

    /**
     * Presenter
     */

    public interface Presenter {
        void loadWeatherDetail(double latitude, double longitude);
    }
}

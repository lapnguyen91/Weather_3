package com.example.lapnguyen.weather_3.screen.mainscreen;

/**
 * Created by lapnguyen on 15/06/2017.
 */

public class MainContract {
    /**
     * View
     */
    public interface View {
        void LoadWeatherDetailSuccess();
    }

    /**
     * Presenter
     */

    public interface Presenter {
        void LoadWeatherDetail();
    }
}

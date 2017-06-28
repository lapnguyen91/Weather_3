package com.example.lapnguyen.weather_3.screen.mainscreen;

import com.example.lapnguyen.weather_3.data.model.CurrentLocation;
import com.example.lapnguyen.weather_3.data.model.Weather;

/**
 * Created by lapnguyen on 15/06/2017.
 */

public class MainContract {
    /**
     * View
     */
    public interface View {
        void loadWeatherDetailSuccess(Weather weather, CurrentLocation currentLocation);
    }

    /**
     * Presenter
     */

    public interface Presenter {
        void loadWeatherDetail(double latitude, double longitude);

        void startGoogleApi();

        void updateScreen();

        void stopGoogleApi();
    }
}

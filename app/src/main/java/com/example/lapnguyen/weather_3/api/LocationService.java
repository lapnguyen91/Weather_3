package com.example.lapnguyen.weather_3.api;

import com.example.lapnguyen.weather_3.data.model.CurrentLocation;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by lapnguyen on 28/06/2017.
 */

public interface LocationService {
    @GET("v1/reverse.php?format=json&key=03af1be9b64c8fef3a09")
    Observable<CurrentLocation> getLocationName(@Query("lat") Double latitude,
            @Query("lon") Double longitude);
}

package com.example.lapnguyen.weather_3.api;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by lapnguyen on 15/06/2017.
 */

public final class ServiceGenerator {
    private ServiceGenerator() {
    }

    private static final String BASE_URL_WEATHER = "https://api.darksky.net/";
    private static final String BASE_URL_LOCATION = "http://locationiq.org/";

    private static Retrofit retrofitLocation, retrofitWeather;

    public static <T> T createService(Class<T> serviceClass) {
        String baseUrl = null;
        Retrofit retrofit;
        if (serviceClass.getName().equals(LocationService.class.getName())) {
            baseUrl = BASE_URL_LOCATION;
            retrofit = retrofitLocation;
        } else {
            baseUrl = BASE_URL_WEATHER;
            retrofit = retrofitWeather;
        }
        Retrofit.Builder reBuilder =
                new Retrofit.Builder().addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        // chi dinh su dung RXJava (dung Observable thay Call)
                        .addConverterFactory(GsonConverterFactory.create())
                        // chi dinh Gson parse chuoi Json thanh POJO class
                        .baseUrl(baseUrl);

        HttpLoggingInterceptor httpLoggingInterceptor =
                new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder okBuilder =
                new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor);

        OkHttpClient okHttpClient = okBuilder.build();

        if (retrofit == null) {
            retrofit = reBuilder.client(okHttpClient).build();
        }
        return retrofit.create(serviceClass);
    }
}


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

    private static final String BASE_URL =
            "https://api.darksky.net/";

    private static Retrofit retrofit;

    private static Retrofit.Builder reBuilder =
            new Retrofit.Builder().addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    // chi dinh su dung RXJava (dung Observable thay Call)
                    .addConverterFactory(GsonConverterFactory.create())
                    // chi dinh Gson parse chuoi Json thanh POJO class
                    .baseUrl(BASE_URL);

    private static HttpLoggingInterceptor httpLoggingInterceptor =
            new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);

    private static OkHttpClient.Builder okBuilder = new OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor);

    private static OkHttpClient okHttpClient = okBuilder.build();

    public static <T> T createService(Class<T> serviceClass) {
        if (retrofit == null) {
            retrofit = reBuilder.client(okHttpClient).build();
        }
        return retrofit.create(serviceClass);
    }
}


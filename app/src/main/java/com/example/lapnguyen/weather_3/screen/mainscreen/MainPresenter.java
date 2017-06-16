package com.example.lapnguyen.weather_3.screen.mainscreen;

import android.app.Activity;
import com.example.lapnguyen.weather_3.data.model.Weather;
import com.example.lapnguyen.weather_3.data.source.MainRepository;
import com.google.android.gms.location.FusedLocationProviderClient;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by lapnguyen on 16/06/2017.
 */

public class MainPresenter extends Activity implements MainContract.Presenter {

    MainContract.View mWeatherDetailView;
    private MainRepository mMainRepository;
    private CompositeDisposable mCompositeDisposable;
    private FusedLocationProviderClient mFusedLocationClient;

    public MainPresenter(MainContract.View view, MainRepository mainRepository) {
        mWeatherDetailView = view;
        mMainRepository = mainRepository;
        mCompositeDisposable = new CompositeDisposable();
        loadWeatherDetail(65.9667 , -18.5333);
        //        gps = new GPSTracker(this);
        //        Log.d("ABC",String.valueOf((gps.getLatitude()+(gps.getLongitude()))));
        //        loadWeatherDetail(gps.getLatitude(), gps.getLongitude());
    }

    @Override
    public void loadWeatherDetail(double latitude, double longitude) {
        Disposable disposable = mMainRepository.getWeather(latitude, longitude)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Weather>() {
                    @Override
                    public void accept(@NonNull Weather weather) throws Exception {
                        mWeatherDetailView.loadWeatherDetailSuccess(weather);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable) throws Exception {
                        throwable.printStackTrace();
                    }
                });
        mCompositeDisposable.add(disposable);
    }
}


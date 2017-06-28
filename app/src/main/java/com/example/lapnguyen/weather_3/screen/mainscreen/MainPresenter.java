package com.example.lapnguyen.weather_3.screen.mainscreen;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import com.example.lapnguyen.weather_3.data.model.CurrentLocation;
import com.example.lapnguyen.weather_3.data.model.Weather;
import com.example.lapnguyen.weather_3.data.source.MainRepository;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by lapnguyen on 16/06/2017.
 */

public class MainPresenter extends Activity
        implements MainContract.Presenter, GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener, LocationListener {

    private static final String TAG = "MainPresenter";
    boolean isFirst = true;
    Context mContext;
    MainContract.View mWeatherDetailView;
    private MainRepository mMainRepository;
    private CompositeDisposable mCompositeDisposable;
    private GoogleApiClient mGoogleApiClient;
    private LocationRequest mLocationRequest;
    private Location mCurrentLocation;

    public MainPresenter(Context context, MainContract.View view, MainRepository mainRepository) {
        mContext = context;
        mWeatherDetailView = view;
        mMainRepository = mainRepository;
        mCompositeDisposable = new CompositeDisposable();
        mGoogleApiClient = new GoogleApiClient.Builder(context).addApi(LocationServices.API)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .build();
    }

    public void startGoogleApi() {
        mGoogleApiClient.connect();
    }

    public void stopGoogleApi() {
        mGoogleApiClient.disconnect();
    }

    @Override
    public void loadWeatherDetail(final double latitude, final double longitude) {
        Disposable disposable = mMainRepository.getWeather(latitude, longitude)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Weather>() {
                    @Override
                    public void accept(@NonNull Weather weather) throws Exception {
                        getAddress(weather, latitude, longitude);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable) throws Exception {
                        throwable.printStackTrace();
                    }
                });
        mCompositeDisposable.add(disposable);
    }

    private void getAddress(final Weather weather, final double latitude, final double longitude) {
        Disposable disposable = mMainRepository.getLocationName(latitude, longitude)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<CurrentLocation>() {
                    @Override
                    public void accept(@NonNull CurrentLocation currentLocation) throws Exception {
                        mWeatherDetailView.loadWeatherDetailSuccess(weather, currentLocation);
                    }
                });
        mCompositeDisposable.add(disposable);
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {

        mLocationRequest = LocationRequest.create();
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        mLocationRequest.setInterval(1000); // Update location every second
        if (ActivityCompat.checkSelfPermission(mContext, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            Log.d(TAG, "onConnected: not granted");
            return;
        }
        LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest,
                this);
    }

    @Override
    public void onConnectionSuspended(int i) {
        Log.d(TAG, "onConnectionSuspended: ");
    }

    @Override
    public void onConnectionFailed(
            @android.support.annotation.NonNull ConnectionResult connectionResult) {
        Log.d(TAG, "onConnectionFailed: ");
    }

    @Override
    public void onLocationChanged(Location location) {
        mCurrentLocation = location;
        if (isFirst) {
            loadWeatherDetail(mCurrentLocation.getLatitude(), mCurrentLocation.getLongitude());
            isFirst = false;
        } else {
            isFirst = false;
        }
    }

    public void updateScreen() {
        loadWeatherDetail(mCurrentLocation.getLatitude(), mCurrentLocation.getLongitude());
    }
}

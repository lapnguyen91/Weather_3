package com.example.lapnguyen.weather_3.screen.mainscreen;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.format.DateFormat;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.example.lapnguyen.weather_3.R;
import com.example.lapnguyen.weather_3.api.ServiceGenerator;
import com.example.lapnguyen.weather_3.api.WeatherService;
import com.example.lapnguyen.weather_3.data.model.Weather;
import com.example.lapnguyen.weather_3.data.source.MainRepository;
import com.example.lapnguyen.weather_3.data.source.MainRepositoryImplement;
import com.example.lapnguyen.weather_3.screen.settingscreen.SettingsActivity;
import com.example.lapnguyen.weather_3.utils.Navigator;
import java.util.Date;

/**
 * Created by lapnguyen on 14/06/2017.
 */
public class MainActivity extends AppCompatActivity implements MainContract.View {

    private SwipeRefreshLayout mSwipeView;
    private MainContract.Presenter mPresenter;
    private TextView mCurrentLocation, mCurrentTemperature, mWindSpeed, mHumidityPercent, mUvIndex,
            mLastUpdatedTime;
    private ImageView mWeatherIcon;
    public long milisec = 1000;
    public double percentage = 100.0;
    Navigator mNavigator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initWidget();
        mNavigator = new Navigator(this);
        MainRepository mainRepository =
                new MainRepositoryImplement(ServiceGenerator.createService(WeatherService.class));
        mPresenter = new MainPresenter(this, mainRepository);
        mSwipeView.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPresenter.loadWeatherDetail(65.9667, 18.5333);
                mSwipeView.setRefreshing(false);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.settings:
                mNavigator.startActivity(SettingsActivity.class);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void initWidget() {
        mSwipeView = (SwipeRefreshLayout) findViewById(R.id.swiperefresh);
        mCurrentLocation = (TextView) findViewById(R.id.text_currentLocation);
        mCurrentTemperature = (TextView) findViewById(R.id.text_currentTemperature);
        mWindSpeed = (TextView) findViewById(R.id.text_windSpeed);
        mHumidityPercent = (TextView) findViewById(R.id.text_humidity_percent);
        mUvIndex = (TextView) findViewById(R.id.text_uv_index);
        mWeatherIcon = (ImageView) findViewById(R.id.image_weather_icon);
        mLastUpdatedTime = (TextView) findViewById(R.id.text_lastUpdate);
    }

    public String epochConvert(long epoch) {
        return DateFormat.format(this.getString(R.string.datetime_format), new Date(epoch * milisec)).toString();
    }

    @Override
    public void loadWeatherDetailSuccess(Weather weather) {
        displayData(weather);
    }

    @SuppressLint("SetTextI18n")
    public void displayData(Weather weather) {
        mLastUpdatedTime.setText(this.getString(R.string.last_update_time) + epochConvert(
                weather.getCurrently().getTime()));
        mUvIndex.setText(this.getString(R.string.uv_index) + weather.getCurrently().getUvIndex());
        mCurrentTemperature.setText(String.valueOf(weather.getCurrently().getTemperature()));
        mWindSpeed.setText(
                this.getString(R.string.wind_speed) + weather.getCurrently().getWindSpeed());
        mHumidityPercent.setText(this.getString(R.string.humidity_percent)
                + weather.getCurrently().getHumidity() * percentage
                + "%");
        Glide.with(this).load(weather.getCurrently().getIcon()).centerCrop().into(mWeatherIcon);
    }
}

package com.example.lapnguyen.weather_3;

import android.os.Bundle;
import android.preference.PreferenceActivity;

/**
 * Created by lapnguyen on 14/06/2017.
 */

public class SettingsActivity extends PreferenceActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.setting_screen);
    }
}

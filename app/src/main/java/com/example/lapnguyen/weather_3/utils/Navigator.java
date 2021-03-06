package com.example.lapnguyen.weather_3.utils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.widget.Toast;

/**
 * Created by l apon 6/15/17.
 */

public class Navigator {
    @NonNull
    private Activity mActivity;
    @NonNull
    private Fragment mFragment;

    public Navigator(@NonNull Activity activity) {
        mActivity = activity;
    }

    public Navigator(@NonNull Fragment fragment) {
        mFragment = fragment;
        mActivity = fragment.getActivity();
    }

    @NonNull
    public Activity getActivity() {
        return mActivity;
    }

    public void setActivity(@NonNull Activity activity) {
        mActivity = activity;
    }

    @NonNull
    public Fragment getFragment() {
        return mFragment;
    }

    public void setFragment(@NonNull Fragment fragment) {
        mFragment = fragment;
    }

    public void startActivity(@NonNull Intent intent) {
        mActivity.startActivity(intent);
    }

    public void startActivity(@NonNull Class<? extends Activity> clazz) {
        Intent intent = new Intent(mActivity, clazz);
        startActivity(intent);
    }

    public void startActivity(@NonNull Class<? extends Activity> clazz, Bundle args) {
        Intent intent = new Intent(mActivity, clazz);
        intent.putExtras(args);
        startActivity(intent);
    }

    public void startActivityAtRoot(@NonNull Class<? extends Activity> clazz) {
        Intent intent = new Intent(mActivity, clazz);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    public void startActivityForResult(@NonNull Intent intent, int requestCode) {
        mActivity.startActivityForResult(intent, requestCode);
    }

    public void startActivityForResult(@NonNull Class<? extends Activity> clazz, Bundle args,
                                       int requestCode) {
        Intent intent = new Intent(mActivity, clazz);
        intent.putExtras(args);
        startActivityForResult(intent, requestCode);
    }

    public void showMessage(String message) {
        Toast.makeText(mActivity, message, Toast.LENGTH_SHORT).show();
    }
}

package com.example.spotifyclone;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class LoadingActivity extends AppCompatActivity {

    static final int LOADING_TIME = 2500;

    Handler mHandler;
    Runnable mLoadingSimulation;
    SharedPreferences mPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

        mHandler = new Handler();
        mLoadingSimulation = new Runnable() {
            @Override
            public void run() {
                mPreferences = getSharedPreferences("User", MODE_PRIVATE);
                SharedPreferences.Editor editor = mPreferences.edit();
                editor.putString("username", "testname");
                editor.commit();

                Intent intent = new Intent(getApplication(), CentralActivity.class);
                startActivity(intent);
                finish();
            }
        };

        mHandler.postDelayed(mLoadingSimulation, LOADING_TIME);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        mHandler.removeCallbacks(mLoadingSimulation);
    }
}

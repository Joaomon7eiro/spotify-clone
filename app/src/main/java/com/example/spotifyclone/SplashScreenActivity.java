package com.example.spotifyclone;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashScreenActivity extends AppCompatActivity {
    static final int SPLASH_SCREEN_TIME = 1500;
    SharedPreferences mPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Handler mHandler = new Handler();
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mPreferences = getSharedPreferences("User", MODE_PRIVATE);

                if (mPreferences.contains("username")) {
                    Intent intent = new Intent(getApplication(), CentralActivity.class);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(getApplication(), MainActivity.class);
                    startActivity(intent);
                }
                finish();
            }
        }, SPLASH_SCREEN_TIME);

    }
}

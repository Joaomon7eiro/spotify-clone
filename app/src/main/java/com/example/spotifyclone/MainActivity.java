package com.example.spotifyclone;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button mSignUpButton;
    Button mFacebookButton;
    Button mSignInButton;

    final float DECREASED_SIZE = 0.97f;
    final int FULL_SIZE = 1;

    SimpleTouchListener signUpButtonTouchListener = new SimpleTouchListener() {
        @Override
        public void onDownTouchAction() {
            mSignUpButton.setScaleX(DECREASED_SIZE);
            mSignUpButton.setScaleY(DECREASED_SIZE);
            mSignUpButton.setBackgroundTintList(getResources().getColorStateList(R.color.colorPrimaryLight));
        }

        @Override
        public void onUpTouchAction() {
            mSignUpButton.setScaleX(FULL_SIZE);
            mSignUpButton.setScaleY(FULL_SIZE);
            mSignUpButton.setBackgroundTintList(getResources().getColorStateList(R.color.colorPrimary));

            Intent intent = new Intent(getApplication(), SignInActivity.class);
            startActivity(intent);
            overridePendingTransition(0,0);
        }

        @Override
        public void onCancelTouchAction() {
            mSignUpButton.setScaleX(FULL_SIZE);
            mSignUpButton.setScaleY(FULL_SIZE);
            mSignUpButton.setBackgroundTintList(getResources().getColorStateList(R.color.colorPrimary));
        }
    };

    SimpleTouchListener facebookButtonTouchListener = new SimpleTouchListener() {
        @Override
        public void onDownTouchAction() {
            mFacebookButton.setScaleX(DECREASED_SIZE);
            mFacebookButton.setScaleY(DECREASED_SIZE);
            mFacebookButton.setBackgroundTintList(getResources().getColorStateList(R.color.facebookColorLight));
        }

        @Override
        public void onUpTouchAction() {
            mFacebookButton.setScaleX(FULL_SIZE);
            mFacebookButton.setScaleY(FULL_SIZE);
            mFacebookButton.setBackgroundTintList(getResources().getColorStateList(R.color.facebookColor));

        }

        @Override
        public void onCancelTouchAction() {
            mFacebookButton.setScaleX(FULL_SIZE);
            mFacebookButton.setScaleY(FULL_SIZE);
            mFacebookButton.setBackgroundTintList(getResources().getColorStateList(R.color.facebookColor));
        }
    };

    SimpleTouchListener signInButtonTouchListener = new SimpleTouchListener() {
        @Override
        public void onDownTouchAction() {
            mSignInButton.setScaleX(DECREASED_SIZE);
            mSignInButton.setScaleY(DECREASED_SIZE);
            mSignInButton.setBackgroundTintList(getResources().getColorStateList(R.color.colorGray));
        }

        @Override
        public void onUpTouchAction() {
            mSignInButton.setScaleX(FULL_SIZE);
            mSignInButton.setScaleY(FULL_SIZE);
            mSignInButton.setBackgroundTintList(getResources().getColorStateList(R.color.colorWhite));

        }

        @Override
        public void onCancelTouchAction() {
            mSignInButton.setScaleX(FULL_SIZE);
            mSignInButton.setScaleY(FULL_SIZE);
            mSignInButton.setBackgroundTintList(getResources().getColorStateList(R.color.colorWhite));
        }
    };

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSignUpButton   = findViewById(R.id.sign_up_button);
        mFacebookButton = findViewById(R.id.facebook_button);
        mSignInButton   = findViewById(R.id.sign_in_button);


        mSignUpButton.setOnTouchListener(signUpButtonTouchListener);
        mFacebookButton.setOnTouchListener(facebookButtonTouchListener);
        mSignInButton.setOnTouchListener(signInButtonTouchListener);
    }
}

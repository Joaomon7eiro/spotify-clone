package com.example.spotifyclone;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

public class SignInActivity extends AppCompatActivity {

    static final int REQUEST_CODE_GET_ACCOUNTS = 1;

    ImageView mReturnButton;
    ImageButton mPasswordVisibilityIcon;
    EditText mEditTextPassword;
    AutoCompleteTextView mAutoCompleteTextViewEmail;

    boolean mPasswordVisibility = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        mEditTextPassword = findViewById(R.id.password);
        mAutoCompleteTextViewEmail = findViewById(R.id.email);
        mReturnButton = findViewById(R.id.return_button);
        mPasswordVisibilityIcon = findViewById(R.id.password_visibility_icon);

        mReturnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        mAutoCompleteTextViewEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int permissionCheck = ContextCompat.checkSelfPermission(getApplication(),
                        Manifest.permission.GET_ACCOUNTS);

                if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(SignInActivity.this,
                            new String[]{Manifest.permission.GET_ACCOUNTS}, REQUEST_CODE_GET_ACCOUNTS);
                }
            }
        });



        mPasswordVisibilityIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPasswordVisibility = !mPasswordVisibility;
                if (mPasswordVisibility) {
                    mPasswordVisibilityIcon.setImageDrawable(getResources().getDrawable(R.drawable.ic_visibility_black_24dp));
                    mEditTextPassword.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    mEditTextPassword.setSelection(mEditTextPassword.getText().length());
                } else {
                    mPasswordVisibilityIcon.setImageDrawable(getResources().getDrawable(R.drawable.ic_visibility_off_black_24dp));
                    mEditTextPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    mEditTextPassword.setSelection(mEditTextPassword.getText().length());
                }
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String permissions[], @NonNull int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CODE_GET_ACCOUNTS: {
                // If request is cancelled, the result arrays are empty.
//                if (grantResults.length > 0
//                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//
//                } else {
//                    // permission denied, boo! Disable the
//                    // functionality that depends on this permission.
//                }
//                return;
            }
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(0, 0);
    }
}
package com.example.spotifyclone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

public class SignInActivity extends AppCompatActivity {

    EditText mEmailEditText;
    EditText mPasswordEditText;
    ImageView mReturnButton;
    ImageButton mPasswordVisibilityIcon;

    boolean mPasswordVisibility = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        mReturnButton = findViewById(R.id.return_button);
        mEmailEditText = findViewById(R.id.sign_in_email);
        mPasswordEditText = findViewById(R.id.sign_in_password);
        mPasswordVisibilityIcon = findViewById(R.id.sign_in_password_visibility_icon);

        mPasswordVisibilityIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPasswordVisibility = !mPasswordVisibility;
                if (mPasswordVisibility) {
                    mPasswordVisibilityIcon.setImageDrawable(getResources().getDrawable(R.drawable.ic_visibility_black_24dp));
                    mPasswordEditText.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    mPasswordEditText.setSelection(mPasswordEditText.getText().length());
                } else {
                    mPasswordVisibilityIcon.setImageDrawable(getResources().getDrawable(R.drawable.ic_visibility_off_black_24dp));
                    mPasswordEditText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    mPasswordEditText.setSelection(mPasswordEditText.getText().length());
                }
            }
        });

        mReturnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(0, 0);
    }
}

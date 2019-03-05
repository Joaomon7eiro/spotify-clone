package com.example.spotifyclone;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.auth.api.credentials.CredentialPickerConfig;
import com.google.android.gms.auth.api.credentials.Credentials;
import com.google.android.gms.auth.api.credentials.CredentialsClient;
import com.google.android.gms.auth.api.credentials.HintRequest;
import com.google.android.gms.auth.api.credentials.IdentityProviders;


public class SignUpActivity extends AppCompatActivity {

    static final String TAG = SignUpActivity.class.getSimpleName();
    static final int REQUEST_CODE_HINT = 1;

    ImageView mReturnButton;
    ImageButton mPasswordVisibilityIcon;
    EditText mPasswordEditText;
    EditText mEmailEditText;
    CredentialsClient mCredentialsClient;

    boolean mPasswordVisibility = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mReturnButton = findViewById(R.id.return_button);
        mPasswordEditText = findViewById(R.id.password);
        mEmailEditText = findViewById(R.id.email);
        mPasswordVisibilityIcon = findViewById(R.id.password_visibility_icon);

        mCredentialsClient = Credentials.getClient(this);

        mEmailEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mEmailEditText.getText().toString().equals("")) {
                    HintRequest hintRequest = new HintRequest.Builder()
                            .setHintPickerConfig(new CredentialPickerConfig.Builder()
                                    .setShowCancelButton(true)
                                    .build())
                            .setEmailAddressIdentifierSupported(true)
                            .setAccountTypes(IdentityProviders.GOOGLE)
                            .build();

                    PendingIntent intent = mCredentialsClient.getHintPickerIntent(hintRequest);
                    try {
                        startIntentSenderForResult(intent.getIntentSender(), REQUEST_CODE_HINT, null, 0, 0, 0);
                    } catch (IntentSender.SendIntentException e) {
                        Log.e("a", "Could not start hint picker Intent", e);
                    }
                }

            }

        });

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
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_HINT) {
            if (resultCode == RESULT_OK) {
                Credential credential = data.getParcelableExtra(Credential.EXTRA_KEY);
                mEmailEditText.setText(credential.getId());
            }
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(0, 0);
    }

}
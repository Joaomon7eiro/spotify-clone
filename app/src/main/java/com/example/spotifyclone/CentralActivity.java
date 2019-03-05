package com.example.spotifyclone;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Toast;

public class CentralActivity extends AppCompatActivity {

    SharedPreferences mPreferences;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    Toast.makeText(getApplication(), "home", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.navigation_search:
                    Toast.makeText(getApplication(), "search", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.navigation_library:
                    SharedPreferences.Editor editor = mPreferences.edit();
                    editor.clear();
                    editor.commit();
                    Toast.makeText(getApplication(), "saiu", Toast.LENGTH_SHORT).show();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_central);

        mPreferences = getSharedPreferences("User", MODE_PRIVATE);

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}

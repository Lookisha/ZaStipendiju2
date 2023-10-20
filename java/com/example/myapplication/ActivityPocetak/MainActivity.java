package com.example.myapplication.ActivityPocetak;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

import com.example.myapplication.ActivitySredina.PlayActivity;
import com.example.myapplication.R;
import com.example.myapplication.utils.Jezici;
import com.example.myapplication.utils.SharedPrefs;

public class MainActivity extends AppCompatActivity {
    String name = "";
    SharedPrefs sharedPreferences;


    Boolean isNightModeON;
    SharedPreferences sharedPreferences2;
    SharedPreferences.Editor editor;

    @Override
    protected void attachBaseContext(Context newBase) {
        sharedPreferences = new SharedPrefs(newBase);
        String languageCode = sharedPreferences.getLocale();
        Context context = Jezici.changeLanguage(newBase, languageCode);
        super.attachBaseContext(context);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(getResources().getString(R.string.welcome)+name);

        sharedPreferences2 = getSharedPreferences("MODE", Context.MODE_PRIVATE);
        isNightModeON = sharedPreferences2.getBoolean("night",false);

        if(isNightModeON) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }

    }

    public void play(View v) {
        Button buttonPlay = findViewById(R.id.button_PLAY);
        Intent intent = new Intent(this, PlayActivity.class);
        startActivity(intent);
        this.finish();
    }

    public void settings(View v) {
        Button buttonSettings = findViewById(R.id.button_SETTINGS);
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }

    public void info(View v) {
        Button buttonInfo = findViewById(R.id.button_INFO);
        Intent intent = new Intent(this, InfoActivity.class);
        startActivity(intent);
    }

    public void exit(View v) {
        finish();
    }
}
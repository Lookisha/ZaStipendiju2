package com.example.myapplication.ActivityPocetak;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.utils.Jezici;
import com.example.myapplication.utils.SharedPrefs;

public class SettingsActivity extends AppCompatActivity {

    Button b1;
    SharedPrefs sharedPreferences;
    //udepdp uanpgzq o pmyy
    @Override
    protected void attachBaseContext(Context newBase) {
        sharedPreferences = new SharedPrefs(newBase);
        String languageCode = sharedPreferences.getLocale();
        Context context = Jezici.changeLanguage(newBase, languageCode);
        super.attachBaseContext(context);
    }
    TextView eng;
    TextView hrv;

    Switch switcher;
    Boolean isNightModeON;
    SharedPreferences sharedPreferences2;
    SharedPreferences.Editor editor;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        setTitle(getResources().getString(R.string.settingsTitle));

        /*int optionn = 0;
        Button fontDugme = findViewById(R.id.font_button);

        SharedPreferences prefs = getSharedPreferences("FONT", MODE_PRIVATE);
        int myFont = prefs.getInt("myInt", 18);

        if(myFont == 18) {
            optionn = 1;
        }
        else if(myFont == 26) {
            optionn = 2;
        }
        else if(myFont == 14) {
            optionn = 0;
        }
        int finalOption = optionn;
        fontDugme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(finalOption % 3 == 0) {
                    SharedPreferences.Editor editorFont = getSharedPreferences("FONT", MODE_PRIVATE).edit();
                    editorFont.putInt("myInt", 12345);
                    editorFont.apply();
                }
                else if(finalOption % 3 == 1){
                    SharedPreferences.Editor editorFont = getSharedPreferences("FONT", MODE_PRIVATE).edit();
                    editorFont.putInt("myInt", 12345);
                    editorFont.apply();
                }
                else {
                    SharedPreferences.Editor editorFont = getSharedPreferences("FONT", MODE_PRIVATE).edit();
                    editorFont.putInt("myInt", 12345);
                    editorFont.apply();
                }
            }
        });*/


        switcher = findViewById(R.id.switch_DarkMode2);

        sharedPreferences2 = getSharedPreferences("MODE", Context.MODE_PRIVATE);
        isNightModeON = sharedPreferences2.getBoolean("night",false);

        if(isNightModeON) {
            switcher.setChecked(true);
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }
        switcher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isNightModeON) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    editor = sharedPreferences2.edit();
                    editor.putBoolean("night",false);
                }else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    editor = sharedPreferences2.edit();
                    editor.putBoolean("night",true);
                }
                editor.apply();
            }
        });

        eng = (TextView) findViewById(R.id.english_textview);
        hrv = (TextView) findViewById(R.id.croatian_textView);
        if (sharedPreferences.getLocale().equals("en")) {
            eng.setTextColor(getResources().getColor(R.color.neon_zelena, null));
            eng.setTypeface(null, Typeface.BOLD);
            hrv.setTextColor(getResources().getColor(R.color.tekst_u_sjeni, null));
            hrv.setTypeface(null, Typeface.NORMAL);
        } else {
            hrv.setTextColor(getResources().getColor(R.color.neon_zelena, null));
            hrv.setTypeface(null, Typeface.BOLD);
            eng.setTextColor(getResources().getColor(R.color.tekst_u_sjeni, null));
            eng.setTypeface(null, Typeface.NORMAL);
        }

        b1 = findViewById(R.id.change_language);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sharedPreferences.getLocale().equals("en")) {
                    sharedPreferences.setLocale("hr");
                } else {
                    sharedPreferences.setLocale("en");
                }
                SettingsActivity.this.recreate();
            }
        });
    }
}
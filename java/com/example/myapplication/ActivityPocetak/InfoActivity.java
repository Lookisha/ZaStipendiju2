package com.example.myapplication.ActivityPocetak;

import android.app.ActionBar;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        setTitle(getResources().getString(R.string.infoTitle));
    }
}
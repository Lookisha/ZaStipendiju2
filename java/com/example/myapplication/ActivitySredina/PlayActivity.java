package com.example.myapplication.ActivitySredina;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.example.myapplication.ActivityKraj.DeKoncept1;
import com.example.myapplication.ActivityKraj.DeKoncept2;
import com.example.myapplication.ActivityKraj.Koncept4;
import com.example.myapplication.ActivityKraj.Koncept5;
import com.example.myapplication.ActivityPocetak.MainActivity;
import com.example.myapplication.ActivityKraj.Koncept1;
import com.example.myapplication.ActivityKraj.Koncept2;
import com.example.myapplication.ActivityKraj.Koncept3;
import com.example.myapplication.R;

import java.util.Objects;

public class PlayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play2);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Objects.requireNonNull(getSupportActionBar()).hide();
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
    }
    public void caesar(View v) {
        Button caesar = findViewById(R.id.button_caesar);
        Intent intent = new Intent(this, Koncept1.class);
        startActivity(intent);
        this.finish();
    }

    public void supstitucijska(View v) {
        Button supstitucijska = findViewById(R.id.button_supstitucijska);
        Intent intent = new Intent(this, Koncept4.class);
        startActivity(intent);
        this.finish();
    }

    public void vigenereova(View v) {
        Button vigenereova = findViewById(R.id.button_vigenereova);
        Intent intent = new Intent(this, Koncept5.class);
        startActivity(intent);
        this.finish();
    }

    public void enigma(View v) {
        Button enigma = findViewById(R.id.button_enigma);
        Intent intent = new Intent(this, Koncept2.class);
        startActivity(intent);
        this.finish();
    }

    public void rsa(View v) {
        Button rsa = findViewById(R.id.button_rsa);
        Intent intent = new Intent(this, Koncept3.class);
        startActivity(intent);
        this.finish();
    }

    public void frekvencijskaAnaliza(View v) {
        Button frekvencijskaAnaliza = findViewById(R.id.button_frekvencijska);
        Intent intent = new Intent(this, DeKoncept1.class);
        startActivity(intent);
        this.finish();
    }
    public void rsabf(View v) {
        Button rsabf = findViewById(R.id.button_RSABF);
        Intent intent = new Intent(this, DeKoncept2.class);
        startActivity(intent);
        this.finish();
    }

    public void back(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        this.finish();
    }
}
package com.example.myapplication.ActivityKraj;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.ActivitySredina.PlayActivity;
import com.example.myapplication.Cezarova.CezarovaSifra;
import com.example.myapplication.R;
import com.example.myapplication.frekvencijskaAnaliza.FrekvencijskaAnaliza;

import java.util.ArrayList;
import java.util.Objects;

public class DeKoncept1 extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.de_koncept1_activity);

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

    public void kriptiraj(View v) {
        EditText text_input = findViewById(R.id.editText1);
        String input = text_input.getText().toString();
        TextView text_output1 = findViewById(R.id.display1);
        TextView text_output2 = findViewById(R.id.display2);
        TextView text_output3 = findViewById(R.id.display3);

        if(input.equals("")) {
            Toast.makeText(this,"Text not found",Toast.LENGTH_LONG).show();
        }
        else {
            FrekvencijskaAnaliza fa = new FrekvencijskaAnaliza(input);

            ArrayList<Character> simbol = fa.getSimbol();
            ArrayList <Integer> brojPonavljanja = fa.getBrojPonavljanja();
            ArrayList <Double> postotak = fa.getPostotak();

            String zaDisplay1 = "";
            String zaDisplay2 = "";
            String zaDisplay3 = "";

            for(int i = 0; i < simbol.size(); i++) {
                if(i % 10 == 0) {
                    zaDisplay1 = zaDisplay1 + "*-------*" + '\n';
                    zaDisplay2 = zaDisplay2 + "*-------*" + '\n';
                    zaDisplay3 = zaDisplay3 + "*-------*" + '\n';
                }

                zaDisplay1 = zaDisplay1 + simbol.get(i) + '\n';
                zaDisplay2 = zaDisplay2 + brojPonavljanja.get(i) + '\n';
                zaDisplay3 = zaDisplay3 + postotak.get(i).toString() + '\n';
            }

            text_output1.setText(zaDisplay1);
            text_output2.setText(zaDisplay2);
            text_output3.setText(zaDisplay3);

            text_output1.setMovementMethod(new ScrollingMovementMethod());
            text_output2.setMovementMethod(new ScrollingMovementMethod());
            text_output3.setMovementMethod(new ScrollingMovementMethod());
        }

    }

    public void info(View v) {
        ConstraintLayout layout = findViewById(R.id.LAYOUT_INFO);
        layout.setVisibility(ConstraintLayout.VISIBLE);
    }

    public void edit(View v) {
        ConstraintLayout layout = findViewById(R.id.LAYOUT_EDIT);
        layout.setVisibility(ConstraintLayout.VISIBLE);
    }
    public void deInfo(View v) {
        ConstraintLayout layout = findViewById(R.id.LAYOUT_EDIT);
        ConstraintLayout layout2 = findViewById(R.id.LAYOUT_INFO);

        layout.setVisibility(ConstraintLayout.INVISIBLE);
        layout2.setVisibility(ConstraintLayout.INVISIBLE);

        hideKeyboard(this);

    }

    public void back(View v) {
        if(v.getId() == findViewById(R.id.button_BACK).getId()) {
            Intent intent = new Intent(this, PlayActivity.class);
            startActivity(intent);
            this.finish();
        }
        else if(v.getId() == findViewById(R.id.button_BACK2).getId()) {
            ConstraintLayout layout = findViewById(R.id.LAYOUT_EDIT);
            layout.setVisibility(ConstraintLayout.INVISIBLE);
        }
        else if(v.getId() == findViewById(R.id.button_BACK3).getId()) {
            ConstraintLayout layout2 = findViewById(R.id.LAYOUT_INFO);
            layout2.setVisibility(ConstraintLayout.INVISIBLE);
        }
    }

    public static void hideKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        View view = activity.getCurrentFocus();
        if (view == null) {
            view = new View(activity);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
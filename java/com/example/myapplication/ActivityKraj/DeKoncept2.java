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
import com.example.myapplication.RSA_BF.RSA_BF;
import com.example.myapplication.frekvencijskaAnaliza.FrekvencijskaAnaliza;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Objects;

public class DeKoncept2 extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.de_koncept2_activity);

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
        TextView text_output = findViewById(R.id.display1);

        if(input.equals("")) {
            Toast.makeText(this,"Text not found",Toast.LENGTH_LONG).show();
        }
        else {
            BigInteger N = new BigInteger(""+input);
            RSA_BF rsa_bf = new RSA_BF(N);
            String output = "";
            BigInteger p = rsa_bf.calculate_p(); //dead man will never come back
            BigInteger q = N.divide(p);
            output = "p = " + p.toString() + '\n' + "q = " + q.toString();
            text_output.setText(output);
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
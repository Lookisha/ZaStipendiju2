package com.example.myapplication.ActivityKraj;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.ActivitySredina.PlayActivity;
import com.example.myapplication.R;
import com.example.myapplication.Vigenereova.VigenereovaSifra;

import java.util.Objects;

public class Koncept5 extends AppCompatActivity {

    public String key;
    public boolean isEnkripcija = true;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.koncept5_activity);

        @SuppressLint("UseSwitchCompatOrMaterialCode") Switch sw = (Switch) findViewById(R.id.switch_BINARNI_MOD);
        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @SuppressLint("SetTextI18n")
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    sw.setText("Decryption");
                    binarnaMetoda(isChecked);
                } else {
                    sw.setText("Encryption");
                    binarnaMetoda(isChecked);
                }
            }
        });

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
        EditText text_output = findViewById(R.id.display3);
        String input = text_input.getText().toString();
        if(key.equals("") || key == null) {
            Toast.makeText(this,"Key not found",Toast.LENGTH_LONG).show();
        }
        else if(input.equals("")) {
            Toast.makeText(this,"Text not found",Toast.LENGTH_LONG).show();
        }
        else if(isEnkripcija){
            VigenereovaSifra cs = new VigenereovaSifra(key,input);
            String output = cs.kriptiraj();
            text_output.setText(output);
        }
        else if(!isEnkripcija) {
            VigenereovaSifra cs = new VigenereovaSifra(key,input);
            String output = cs.dekriptiraj();
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
    public void key(View v) {
        TextView text_key = findViewById(R.id.Textview_KEY);
        EditText systemData = findViewById(R.id.KEY_SYSTEM_DATA);

        if(!text_key.getText().toString().equals("")) {
            key = text_key.getText().toString();
            Toast.makeText(this,"Update complete", Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(this,"Input error",Toast.LENGTH_LONG).show();
        }
    }


    public void binarnaMetoda(boolean isChecked) {
        Button button = findViewById(R.id.button_ENCRYPT);

        if(isChecked) {
            button.setText(getResources().getString(R.string.decrypt));
            isEnkripcija = false;
        }
        else {
            button.setText(getResources().getString(R.string.encrypt));
            isEnkripcija = true;
        }

    }
    public void copy(View v) {
        EditText text_output = findViewById(R.id.display3);
        String output = text_output.getText().toString();
        copyToClipBoard(output);
    }
    private void copyToClipBoard(String text) {

        ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText(
                "DATA",
                text);
        clipboard.setPrimaryClip(clip);

        Toast.makeText(this, "Saved to clipboard", Toast.LENGTH_SHORT).show();
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
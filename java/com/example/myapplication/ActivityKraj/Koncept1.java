package com.example.myapplication.ActivityKraj;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.os.Bundle;
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

import java.util.Objects;

public class Koncept1 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    public Spinner spinner;
    //public EditText systemData = findViewById(R.id.editText_SYSTEM_DATA);
    public int mode = 1;
    public int key = -1;
    public boolean isEnkripcija = true;
    public String costumAbeceda = "a b c d e f g h i j k l m n o p q r s t u v w x y z"; //dodati datu
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.koncept1_activity);

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

        spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);

        String[] opcije = getResources().getStringArray(R.array.koncept1_opcije);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, opcije);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);


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
        Button button = findViewById(R.id.button_ENCRYPT);
        EditText text_input = findViewById(R.id.editText1);
        EditText text_output = findViewById(R.id.display3);
        String input = text_input.getText().toString();
        if(key == -1) {
            Toast.makeText(this,"Key not found",Toast.LENGTH_LONG).show();
        }
        else if(input.equals("")) {
            Toast.makeText(this,"Text not found",Toast.LENGTH_LONG).show();
        }
        else if(isEnkripcija){
            CezarovaSifra cs = new CezarovaSifra(key,input,mode,costumAbeceda);
            String output = cs.kriptiraj();
            text_output.setText(output);
        }
        else if(!isEnkripcija) {
            CezarovaSifra cs = new CezarovaSifra(key,input,mode,costumAbeceda);
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
        TextView text_key = findViewById(R.id.textView_q);
        EditText systemData = findViewById(R.id.KEY_SYSTEM_DATA);

        Log.d("proba","ovo je mod"+mode);
        if(mode == 100) {
            if(isCostumAbecedaOK(systemData.getText().toString())) {
                costumAbeceda = systemData.getText().toString();
            }
            else {
                Toast.makeText(this,"alphabet error", Toast.LENGTH_LONG).show();
            }
        }
        if(!text_key.getText().toString().equals("")) {
            String key_text = text_key.getText().toString();
            key = Integer.parseInt(key_text);
            Toast.makeText(this,"Update complete", Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(this,"Input error",Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        EditText systemData = findViewById(R.id.KEY_SYSTEM_DATA);
        if(parent.getId() == R.id.spinner) {
            String spinnerValue = parent.getItemAtPosition(position).toString();
            if (spinnerValue.equals("Mode: Default")) {
                mode = 1;
                systemData.setEnabled(false);
                systemData.setText("a b c d e f g h i j k l m n o p q r s t u v w x y z");
                Log.d("proba","ovo je mod"+mode);
            }
            else if (spinnerValue.equals("Mode: Lookisha")) {
                mode = 10;
                systemData.setEnabled(false);
                systemData.setText("a b c d e f g h i j k l m n o p q r s t u v w x y z . ? ! , ; - \" ( ) / : * < >  ");
                Log.d("proba","ovo je mod"+mode);
            }
            else if (spinnerValue.equals("Mode: RANDOM")) {
                mode = 100;
                systemData.setEnabled(true);
                systemData.setText(costumAbeceda);
                Log.d("proba","ovo je mod"+mode);
            }
            else {
                mode = 1;
                systemData.setEnabled(false);
                systemData.setText(costumAbeceda);
                Log.d("proba","ovo je mod"+mode);
                /*
                dodaj nesto cool (to je za onaj coming soon)
                 */
            }
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

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
    public static void hideKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        View view = activity.getCurrentFocus();
        if (view == null) {
            view = new View(activity);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
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
    public boolean isCostumAbecedaOK(String abeceda) {
        for(int i = 0; i < abeceda.length(); i++) {
            if(i % 2 == 1 && abeceda.charAt(i) != ' ') {
                return false;
            }
        }

        for(int i = 0; i < abeceda.length(); i+=2) {
            for(int j = i + 2; j < abeceda.length(); j+=2) {
                if(abeceda.charAt(i) == abeceda.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }
}
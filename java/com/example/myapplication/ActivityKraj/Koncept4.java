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
import android.widget.Toast;

import com.example.myapplication.ActivitySredina.PlayActivity;
import com.example.myapplication.R;
import com.example.myapplication.Supstitucijska.SupstitucijskaSifra;

import java.util.ArrayList;
import java.util.Objects;

public class Koncept4 extends AppCompatActivity {

    int key = 1;
    public boolean isEnkripcija = true;

    private int brojNula;
    ArrayList<Character> sifrat = new ArrayList<>(); //abeceda sifrirana
    ArrayList<Character> nule = new ArrayList<>(); //random simboli koji se umeću
    ArrayList<Character> simbolZaRijec = new ArrayList<>(); //arraylist simbola za rijeci
    ArrayList<String> rijec = new ArrayList<>(); //arraylist rijeci

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.koncept4_activity);

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
            SupstitucijskaSifra substitucijskaSifra = new SupstitucijskaSifra(sifrat,nule,brojNula,simbolZaRijec,rijec,input);
            String output = substitucijskaSifra.kriptiraj();
            text_output.setText(output);
        }
        else if(!isEnkripcija) {
            SupstitucijskaSifra substitucijskaSifra = new SupstitucijskaSifra(sifrat,nule,brojNula,simbolZaRijec,rijec,input);
            String output = substitucijskaSifra.dekriptiraj();
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
    public void key(View v) throws NumberFormatException{
        EditText a = findViewById(R.id.KEY_SYSTEM_DATA);
        EditText b = findViewById(R.id.KEY_nule);
        EditText c = findViewById(R.id.KEY_nule_broj);
        EditText d = findViewById(R.id.KEY_simbolZaRijec);

        String key_abeceda = a.getText().toString();
        String key_nule = b.getText().toString();
        String key_nule_broj = c.getText().toString();
        String key_simboliZaRijec = d.getText().toString();

        if(isCostumAbecedaOK(key_abeceda)) {
            for (int i = 0; i < 25; i++) {
                sifrat.add(key_abeceda.charAt(i * 2));
            }
        }
        else {
            Toast.makeText(this,"alphabet error", Toast.LENGTH_LONG).show();
        }

        for(int i = 0; i < (key_nule.length()+1)/2; i++) {
            nule.add(key_nule.charAt(i*2));
        }

        if(!key_nule_broj.equals("")) {
            brojNula = Integer.parseInt(key_nule_broj);
        }
        else {
            brojNula = 0;
        }
        //Im here waiting .\ /.

        String subString;
        int odPrije = 0;
        if(!key_simboliZaRijec.equals("")) {
            for(int i = 0; i < key_simboliZaRijec.length(); i++) {
                if(key_simboliZaRijec.charAt(i) == ':') {
                    subString = key_simboliZaRijec.substring(odPrije, i);
                    rijec.add(subString);
                    simbolZaRijec.add(key_simboliZaRijec.charAt(i+1));
                    odPrije = i+3;
                }
            }
        }




        Toast.makeText(this,"Update complete", Toast.LENGTH_LONG).show();
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
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
import com.example.myapplication.RSA.ASCII;
import com.example.myapplication.RSA.RSA_Dekripcija;
import com.example.myapplication.RSA.RSA_Enkripcija;

import java.math.BigInteger;
import java.util.Objects;

public class Koncept3 extends AppCompatActivity {

    private BigInteger p = new BigInteger("0"); // prosti broj, PRIVATNO, VEĆI!
    private BigInteger q = new BigInteger("0"); // prosti broj, PRIVATNO, MANJI!
    private BigInteger N = new BigInteger("0"); // p * q, JAVNO
    private int e = 0; // e i (p-1)*(q-1) - ne djeljivi JAVNO
    public boolean isEnkripcija = true;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.koncept3_activity);

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
        ASCII ascii = new ASCII();

        if((p.equals(BigInteger.ZERO) || q.equals(BigInteger.ZERO) || e == 0) && !isEnkripcija) {
            Toast.makeText(this,"Decryption Key not found",Toast.LENGTH_LONG).show();
        }
        else if((N.equals(BigInteger.ZERO) || e == 0) && isEnkripcija) {
            Toast.makeText(this,"Encryption Key not found",Toast.LENGTH_LONG).show();
        }
        else if(input.equals("")) {
            Toast.makeText(this,"Text not found",Toast.LENGTH_LONG).show();
        }
        else if(isEnkripcija){
            RSA_Enkripcija rsa_enkripcija = new RSA_Enkripcija(ascii.stringInNumber(input),e,N);
            String output = rsa_enkripcija.enkriptirajMain();
            text_output.setText(output);
        }
        else if(!isEnkripcija) {
            RSA_Dekripcija rsa_dekripcija = new RSA_Dekripcija(input,p,q,e);
            String output = rsa_dekripcija.dekriptiraj();
            output = ascii.numberInString(new BigInteger(""+output));
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
        TextView text_key_p = findViewById(R.id.textView_p);
        TextView text_key_q = findViewById(R.id.textView_q);
        TextView text_key_N = findViewById(R.id.textView_N);
        TextView text_key_e = findViewById(R.id.textView_e);


        String key_text_p = text_key_p.getText().toString();
        String key_text_q = text_key_q.getText().toString();
        String key_text_N = text_key_N.getText().toString();
        String key_text_e = text_key_e.getText().toString();

        if(!key_text_p.equals("")) {
            p = new BigInteger(""+key_text_p);
        }
        if(!key_text_q.equals("")) {
            q = new BigInteger(""+key_text_q);
        }
        if(!key_text_N.equals("")) {
            N = new BigInteger(""+key_text_N);
        }
        if(!key_text_e.equals("")) {
            e = Integer.parseInt(key_text_e);
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
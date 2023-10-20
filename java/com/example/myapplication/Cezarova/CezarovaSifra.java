package com.example.myapplication.Cezarova;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import java.io.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CezarovaSifra extends AppCompatActivity {
    int key;
    String tekstData;
    int mode;
    String costumAbeceda;

    int size;
    ArrayList<Character> simboli;

    public final int DEFAULT = 1; //modovi
    public final int LOOKISHA = 10;
    public final int RANDOM = 100;

    public CezarovaSifra(int key, String tekstData, int mode, String costumAbeceda) {
        tekstData = tekstData.toLowerCase();
        this.key = key;
        this.tekstData = tekstData;
        this.mode = mode;
        this.costumAbeceda = costumAbeceda;

        generirajSimbole();
    }

    public String kriptiraj() {
        String sifrirano = "";

        for(int i = 0; i < tekstData.length(); i++) {
            sifrirano = sifrirano + sifrirajSlovo(tekstData.charAt(i));
        }

        return sifrirano.toUpperCase();
    }
    public String dekriptiraj() {
        String desifrirano = "";

        for(int i = 0; i < tekstData.length(); i++) {
            desifrirano = desifrirano + desifrirajSlovo(tekstData.charAt(i));
        }

        return desifrirano.toLowerCase();
    }


    private void generirajSimbole() { //dodati mogućnost dodavanja više simbola i razmještanja - dinamičnosti simboli ArrayLista
        simboli = new ArrayList<>();
        if(mode == DEFAULT) {
            simboli.add('a');
            simboli.add('b');
            simboli.add('c');
            simboli.add('d');
            simboli.add('e');
            simboli.add('f');
            simboli.add('g');
            simboli.add('h');
            simboli.add('i');
            simboli.add('j');
            simboli.add('k');
            simboli.add('l');
            simboli.add('m');
            simboli.add('n');
            simboli.add('o');
            simboli.add('p');
            simboli.add('q');
            simboli.add('r');
            simboli.add('s');
            simboli.add('t');
            simboli.add('u');
            simboli.add('v');
            simboli.add('w');
            simboli.add('x');
            simboli.add('y');
            simboli.add('z');
        }
        else if(mode == LOOKISHA) {
            simboli.add('a');
            simboli.add('b');
            simboli.add('c');
            simboli.add('d');
            simboli.add('e');
            simboli.add('f');
            simboli.add('g');
            simboli.add('h');
            simboli.add('i');
            simboli.add('j');
            simboli.add('k');
            simboli.add('l');
            simboli.add('m');
            simboli.add('n');
            simboli.add('o');
            simboli.add('p');
            simboli.add('q');
            simboli.add('r');
            simboli.add('s');
            simboli.add('t');
            simboli.add('u');
            simboli.add('v');
            simboli.add('w');
            simboli.add('x');
            simboli.add('y');
            simboli.add('z');

            simboli.add('.');
            simboli.add('?');
            simboli.add('!');
            simboli.add(',');
            simboli.add(';');
            simboli.add('-');
            simboli.add('"');
            simboli.add('(');
            simboli.add(')');
            simboli.add('/');
            simboli.add(':');
            simboli.add('*');
            simboli.add('<');
            simboli.add('>');
            simboli.add(' ');
        }
        else if (mode == RANDOM) {
            for(int i = 0; i < costumAbeceda.length(); i+=2) {
                simboli.add(costumAbeceda.charAt(i));
            }


        }

        size = simboli.size();
        key = key % size;
    }

    private Character sifrirajSlovo(char slovo) {
        boolean isOK = false;
        for(int i = 0; i < size; i++) {
            if(slovo == simboli.get(i)) {
                isOK = true;
                break;
            }
        }
        if(isOK) {
            int num = simboli.indexOf(slovo);
            int num2 = num + key;
            num2 = num2 % size;
            return simboli.get(num2);
        }
        else {
            return slovo;
        }
    }
    private Character desifrirajSlovo(char slovo) {

        int num = simboli.indexOf(slovo);
        int num2 = num - key;
        if(num2 < 0) num2 += size;
        return simboli.get(num2);
    }

}

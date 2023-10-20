package com.example.myapplication.Vigenereova;

import java.util.ArrayList;

public class VigenereovaSifra {

    private String key;
    private String tekstData;
    ArrayList<Character> simboli = new ArrayList<>();

    public VigenereovaSifra(String key, String tekstData) {
        this.key = key;
        this.tekstData = tekstData;

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

        String old = this.key;
        while(this.key.length() < this.tekstData.length()) {
            this.key = this.key + old;
        }
        this.key = this.key.toLowerCase();
        this.tekstData = this.tekstData.toLowerCase();
    }

    public String kriptiraj() {
        String sifrirano = "";
        int num;
        boolean proslo = true;
        for(int i = 0; i < tekstData.length(); i++) {
            for(int j = 0; j < simboli.size(); j++) {
                if(simboli.get(j) == tekstData.charAt(i)) {
                    num = (simboli.indexOf(tekstData.charAt(i)) + simboli.indexOf(key.charAt(i))) % 26; 
                    sifrirano = sifrirano + simboli.get(num);
                    proslo = true;
                    break;
                }
            }
            if(proslo == false) {
                sifrirano = sifrirano + tekstData.charAt(i);
            }
            proslo = false;
        }

        return sifrirano.toUpperCase();
    }
    public String dekriptiraj() {
        String desifrirano = "";
        int num;
        boolean proslo = true;
        for(int i = 0; i < tekstData.length(); i++) {
            for(int j = 0; j < simboli.size(); j++) {
                if(simboli.get(j) == tekstData.charAt(i)) {
                    num = (simboli.indexOf(tekstData.charAt(i)) - simboli.indexOf(key.charAt(i)));
                    if(num < 0) num += 26;
                    num %= 26; 
                    desifrirano = desifrirano + simboli.get(num);
                    proslo = true;
                    break;
                }
            }
            if(proslo == false) {
                desifrirano = desifrirano + tekstData.charAt(i);
            }
            proslo = false;
        }

        return desifrirano;
    }


}
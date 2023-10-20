package com.example.myapplication.Enigma;

import android.util.Log;

import java.util.ArrayList;

public class Reflektor {
    private static ArrayList<Character> abeceda;
    static char rez;
    public static int reflektor(char slovo) {
        abeceda = new ArrayList<Character>();

        abeceda.add(0,'a');
        abeceda.add(1,'b');
        abeceda.add(2,'c');
        abeceda.add(3,'d');
        abeceda.add(4,'e');
        abeceda.add(5,'f');
        abeceda.add(6,'g');
        abeceda.add(7,'h');
        abeceda.add(8,'i');
        abeceda.add(9,'j');
        abeceda.add(10,'k');
        abeceda.add(11,'l');
        abeceda.add(12,'m');
        abeceda.add(13,'n');
        abeceda.add(14,'o');
        abeceda.add(15,'p');
        abeceda.add(16,'q');
        abeceda.add(17,'r');
        abeceda.add(18,'s');
        abeceda.add(19,'t');
        abeceda.add(20,'u');
        abeceda.add(21,'v');
        abeceda.add(22,'w');
        abeceda.add(23,'x');
        abeceda.add(24,'y');
        abeceda.add(25,'z');

         switch (slovo) { // virtualni displai na mjestu reflektora
            case 'a': rez = 'h';
                break;
            case 'b': rez = 'j';
                break;
            case 'c': rez = 'x';
                break;
            case 'd': rez = 'r';
                break;
            case 'e': rez = 'k';
                break;
            case 'f': rez = 'l';
                break;
            case 'g': rez = 'u';
                break;
            case 'h': rez = 'a';
                break;
            case 'i': rez = 'o';
                break;
            case 'j': rez = 'b';
                break;
            case 'k': rez = 'e';
                break;
            case 'l': rez = 'f';
                break;
            case 'm': rez = 'y';
                break;
            case 'n': rez = 'p';
                break;
            case 'o': rez = 'i';
                break;
            case 'p': rez = 'n';
                break;
            case 'q': rez = 't';
                break;
            case 'r': rez = 'd';
                break;
            case 's': rez = 'w';
                break;
            case 't': rez = 'q';
                break;
            case 'u': rez = 'g';
                break;
            case 'v': rez = 'z';
                break;
            case 'w': rez = 's';
                break;
            case 'x': rez = 'c';
                break;
            case 'y': rez = 'm';
                break;
            case 'z': rez = 'v';
                break;
            default: rez = 'č';
        };

         Log.d("proba","char je: "+rez);
        int i = 0;

        for(i = 0; i < 26; i++) {
            if(abeceda.get(i) == rez) {
                break;
            }
        }
        return i;
    }
}

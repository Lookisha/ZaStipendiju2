package com.example.myapplication.Enigma;

import java.util.ArrayList;

public class EnigmaMain {
    int key1;
    int key2;
    int key3;
    String text;

    public EnigmaMain(int key1, int key2, int key3, String text) {
        this.key1 = key1;
        this.key2 = key2;
        this.key3 = key3;
        this.text = text;
    }

    public String classFunction() {
        ArrayList<Character> abeceda = new ArrayList<Character>();

        key1 = key1 % 26;
        key2 = key2 % 26;
        key3 = key3 % 26;

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

        String textOutput = "";
        int data = 0;
        int data2;
        char data3;
        int data4;
        char data5;

        for(int i = 0; i < text.length(); i++) {
            data = text.charAt(i);
            data = Character.toLowerCase(data);
            Boolean proslo = false;
            
            for(int j = 0; j < 26; j++) {
                if(data == abeceda.get(j)) { //tu se dodaju rotori
                    if(key1 >= 26) {
                        key1 = key1 - 26;
                        key2++;
                    }
                    if(key2 >= 26) {
                        key2 = key2 - 26;
                        key3++;
                    }
                    if(key3 >= 26) {
                        key3 = key3 - 26;
                    }
                    proslo = true;
                    data2 = Rotor1.rotor1(j, key1); //int
                    data2 = Rotor2.rotor2(data2, key2); //int
                    data3 = Rotor3.rotor3(data2, key3); //char
                    data4 = Reflektor.reflektor(data3); //int
                    data4 = RotorObrnuto3.rotorObrnuto3(data4, key3); //int
                    data4 = RotorObrnuto2.rotorObrnuto2(data4, key2); //int
                    data5 = RotorObrnuto1.rotorObrnuto1(data4, key1); //char

                    textOutput = textOutput + data5; //data se treba promjeniti u nesto drugo
                    key1++;
                }
                else if(j == 25 && proslo == false){
                    textOutput = textOutput + (char)data;
                }
            }
        }

        return textOutput;
    }
}
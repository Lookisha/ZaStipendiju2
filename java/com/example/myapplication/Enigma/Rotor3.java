package com.example.myapplication.Enigma;

import java.util.ArrayList;

public class Rotor3 {
    private static ArrayList<Integer> pomaci;
    private static ArrayList<Character> abeceda;
    private static ArrayList<Integer> pomaknutiPomaci;

    
    public static char rotor3(int slovo, int pomakRotora) { //slovo je broj od 0-25, a pomak rotora je trenutni pomak rotora od početka (dio ključa broj 0 - 25),
                                                            // ali isto tako i tokom izvođenja programa

        pomaci = new ArrayList<Integer>();
        pomaknutiPomaci = new ArrayList<Integer>();


        pomaci.add(0,11); //index predstavlja broj slova, a element pomak
        pomaci.add(1,3);
        pomaci.add(2,8);
        pomaci.add(3,10);
        pomaci.add(4,15);
        pomaci.add(5,-4);
        pomaci.add(6,-6);
        pomaci.add(7,16);
        pomaci.add(8,16);
        pomaci.add(9,-3);
        pomaci.add(10,-5);
        pomaci.add(11,7);
        pomaci.add(12,0);
        pomaci.add(13,7);
        pomaci.add(14,11);
        pomaci.add(15,-13);
        pomaci.add(16,-1);
        pomaci.add(17,-10);
        pomaci.add(18,-4);
        pomaci.add(19,2);
        pomaci.add(20,2);
        pomaci.add(21,-18);
        pomaci.add(22,-14);
        pomaci.add(23,-7);
        pomaci.add(24,-7);
        pomaci.add(25,-16);

        pomaknutiPomaci.add(0,2);
        pomaknutiPomaci.add(1,2);
        pomaknutiPomaci.add(2,2);
        pomaknutiPomaci.add(3,2);
        pomaknutiPomaci.add(4,2);
        pomaknutiPomaci.add(5,2);
        pomaknutiPomaci.add(6,2);
        pomaknutiPomaci.add(7,2);
        pomaknutiPomaci.add(8,2);
        pomaknutiPomaci.add(9,2);
        pomaknutiPomaci.add(10,2);
        pomaknutiPomaci.add(11,2);
        pomaknutiPomaci.add(12,2);
        pomaknutiPomaci.add(13,2);
        pomaknutiPomaci.add(14,2);
        pomaknutiPomaci.add(15,2);
        pomaknutiPomaci.add(16,2);
        pomaknutiPomaci.add(17,2);
        pomaknutiPomaci.add(18,2);
        pomaknutiPomaci.add(19,2);
        pomaknutiPomaci.add(20,2);
        pomaknutiPomaci.add(21,2);
        pomaknutiPomaci.add(22,2);
        pomaknutiPomaci.add(23,2);
        pomaknutiPomaci.add(24,2);
        pomaknutiPomaci.add(25,2);


        Character sifriranoSlovo;

        for(int i = 0; i < 26; i++) { //okreće rotor za veličinu "pomakRotora"
            int ppomak = pomakRotora + i;
            int s;
            s = 0;
            if(ppomak >= 26) {
                s = ppomak - 26;
                pomaknutiPomaci.set(s,pomaci.get(i));
            }
            else if (ppomak < 26) {
                s = ppomak;
                pomaknutiPomaci.set(s,pomaci.get(i));
            }
        }

        int noviBrojSlova;
        noviBrojSlova = slovo + pomaknutiPomaci.get(slovo);

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

        int i;
        for(i = 0; i < 26; i++) {
            if(noviBrojSlova >= 26) {
                noviBrojSlova = noviBrojSlova - 26;
            }
            if(noviBrojSlova < 0) {
                noviBrojSlova = noviBrojSlova + 26;
            }
            if(i == noviBrojSlova) {
                break;
            }
        }
        sifriranoSlovo = abeceda.get(i);

        return sifriranoSlovo;
    }
}
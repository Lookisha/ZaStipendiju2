package com.example.myapplication.frekvencijskaAnaliza;

import java.text.NumberFormat;
import java.util.ArrayList;

public class FrekvencijskaAnaliza {
    
    String tekstData;
    private ArrayList <Character> simbol = new ArrayList<>();
    private ArrayList <Integer> brojPonavljanja = new ArrayList<>();
    private ArrayList <Double> postotak = new ArrayList<>();

    public FrekvencijskaAnaliza(String tekstData) {
        this.tekstData = tekstData;
        fAnaliza();
    }

    private void fAnaliza() {

        boolean proslo = false;

        for(int i = 0; i < tekstData.length(); i++) {
            for(int j = 0; j < simbol.size(); j++) {
                if(tekstData.charAt(i) == simbol.get(j)) {
                    proslo = true;
                }
            }
            if(!proslo) simbol.add(tekstData.charAt(i));
            proslo = false;
        }
        
        simbol = sort(simbol);

        for(int i = 0; i < simbol.size(); i++) {
            brojPonavljanja.add(0);
        }

        for(int i = 0; i < tekstData.length(); i++) {
            for(int j = 0; j < simbol.size(); j++) {
                if(tekstData.charAt(i) == simbol.get(j)) {
                    brojPonavljanja.set(j, brojPonavljanja.get(j)+1);

                }
            }
        }

        for (int i = 0; i < simbol.size(); i++) {
            double posto = ((double) brojPonavljanja.get(i) / tekstData.length()) * 100;
            NumberFormat nf = NumberFormat.getInstance();
            double roundVal = Math.round(posto*100.0)/100.0;
            postotak.add(roundVal);
        }
        
    }
    

    public ArrayList<Character> getSimbol() {
        return simbol;
    }
    public ArrayList<Integer> getBrojPonavljanja() {
        return brojPonavljanja;
    }
    public ArrayList<Double> getPostotak() {
        return postotak;
    }

    public void printArray(ArrayList array) {
        for(int i = 0; i < array.size(); i++) {
            System.out.print(array.get(i)+" ");
        }
    }


    private ArrayList<Character> sort(ArrayList<Character> simbol2) {

        /*for(int i = 0; i < simbol2.size(); i++) {
            brojcaneVrijednosti.set(i, (int) simbol2.get(i));
        }*/

        for(int i = simbol2.size()-1; i >= 0; i--) {
            for(int j = 1; j <= i; j++) {
                if(simbol2.get(j-1) > simbol2.get(j)) {
                    Character temp = simbol2.get(j-1);
                    simbol2.set(j-1, simbol2.get(j));
                    simbol2.set(j, temp);
                }
            }
        }

        return simbol2;
    }
}

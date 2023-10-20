import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;

public class MersenePrimes extends Thread implements Konstante{
    private int limit;
    private int beginning;
    private int option;
    private int[] list;

    boolean isConstructingDone = false;
    public StringBuilder BROJ;
    public int BROJ_ZNAMENKI;

    MersenePrimes(int beginning,int limit, int option, int[] list) { // (0) = classFunctionMersenne(), (5) = classFunctionBaza10(), (10) = classFunctionRastaviNaProste()
        this.limit = limit;
        this.beginning = beginning;
        this.option = option;
        this.list = list;
    }

    public void run() {
        if(option == 0) {
            classFunctionMersenne();
        }
        else if(option == 5) {
            classFunctionBaza10();
        }
        else if(option == 6) {
            classFunctionBaza10(list);
        }
        else if(option == 10) {
            classFunctionRastaviNaProste();
        }
        
    }
    public void classFunctionMersenne() {
        int brojac = 0;
        BigInteger MersenneNumber = new BigInteger("1");
        try {
            String fileName = new String("MersennePrimesData" + ""+beginning+"-"+limit+".txt");
            FileWriter writer = new FileWriter(fileName);
            if(beginning % 2 ==0) {
                beginning++; 
            }
            for(int index = beginning; index <= limit; index+=2) {
                if(index % 10 == 1) {
                    System.out.println(index+" FROM THREAD"+(beginning-1)+"........."+(limit-index)+" = "+(((double)(index-beginning)/(limit-beginning))*100)+"% "+"IS DONE");
                }

                if(isBrojProst(new BigInteger(""+index))) {
                    MersenneNumber = BigInteger.TWO.pow(index).subtract(BigInteger.ONE);
                    if(MersenneNumber.isProbablePrime(1)) {
                        brojac++;
                        String brojacc = new String(""+brojac);
                        String indexx = new String(""+index); 
                        writer.write(brojacc+". "+ indexx +" "+MersenneNumber.toString()+"\n");
                        System.out.println("! PRIME FOUND IN THREAD"+(beginning-1));
                    }
                }

                //MersenneNumber = MersenneNumber.add(BigInteger.ONE).multiply(BigInteger.TWO).multiply(BigInteger.TWO).subtract(BigInteger.ONE);
                //System.out.println(MersenneNumber+" "+MersenneNumber.isProbablePrime(1));
            }
            System.out.println("! THREAD"+(beginning-1)+" IS DONE");
            System.out.println("! THREAD"+(beginning-1)+" FOUND"+brojac+"PROBABLE PRIME NUMBERS");
            writer.close();
        } catch (IOException e) {
            System.out.println("! SOMETHING IS WRONG IN THREAD"+(beginning-1));
        }

    }

    public void classFunctionBaza10() { //NOVO
        int brojac = 0;
        BigInteger MersenneNumber = new BigInteger("1");
        BigInteger DESET = new BigInteger("10");
        BigInteger TRI = new BigInteger("3");
        try {
            String fileName = new String("Baza10PrimesData" + ""+beginning+"-"+limit+".txt");
            FileWriter writer = new FileWriter(fileName);
            for(int index = beginning; index <= limit; index++) {
                if(index % 10 == 0) {
                    System.out.println(index+" FROM THREAD"+(beginning)+"........."+(limit-index)+" = "+(((double)(index-beginning)/(limit-beginning))*100)+"% "+"IS DONE");
                }

                if(provjeraValjanostiIndexa(index)) {
                    MersenneNumber = DESET.pow(index).subtract(TRI);
                    if(MersenneNumber.isProbablePrime(1)) {
                        brojac++;
                        String brojacc = new String(""+brojac);
                        String indexx = new String(""+index);
                        writer.append(brojacc+". "+ indexx +" "+MersenneNumber.toString()+"\n");
                        System.out.println("! PRIME FOUND IN THREAD"+(beginning));
                    }
                }
                else {
                    System.out.println("NE VALJA");
                }
            }
            System.out.println("! THREAD"+(beginning)+" IS DONE");
            System.out.println("! THREAD"+(beginning)+" FOUND "+brojac+" PROBABLE PRIME NUMBERS");
            writer.close();
        } catch (IOException e) {
            System.out.println("! SOMETHING IS WRONG IN THREAD"+(beginning));
        }
    }

    public void classFunctionBaza10(int[] list) { //NOVO NOVO
        int brojac = 0;
        int brojac2 = 0;
        BigInteger MersenneNumber = new BigInteger("1");
        BigInteger DESET = new BigInteger("10");
        BigInteger TRI = new BigInteger("3");
        try {
            String fileName = new String("Baza10LIST"+beginning+".txt");
            FileWriter writer = new FileWriter(fileName);
            for(int index = beginning; index < limit; index++) {
                if(index % 100 == 0) {
                    System.out.println(index+" FROM THREAD"+(beginning)+"........."+(limit-index)+" = "+(((double)(index-beginning)/(limit-beginning))*100)+"% "+"IS DONE .... TRENUTNO NA "+list[index]);
                }

                if(provjeraValjanostiIndexa(list[index])) {
                    MersenneNumber = DESET.pow(list[index]).subtract(TRI);
                    brojac++;
                    if(MersenneNumber.isProbablePrime(1)) {
                        String brojacc = new String(""+brojac);
                        writer.append(brojacc+". "+ list[index] +" "+MersenneNumber.toString()+"\n");
                        System.out.println("! PRIME FOUND IN THREAD"+(beginning)+" .... "+list[index]);
                    }
                }
                else {
                    brojac2++;
                }
            }
            System.out.println("! THREAD"+(beginning)+" IS DONE");
            System.out.println("! THREAD"+(beginning)+" FOUND "+brojac+" PROBABLE PRIME NUMBERS");
            System.out.println("! NIJE PRESKOCENO "+brojac+" BROJEVA");
            System.out.println("! PRESKOCENO JE "+brojac2+" BROJEVA");
            writer.close();
        } catch (IOException e) {
            System.out.println("! SOMETHING IS WRONG IN THREAD"+(beginning));
        }
    }

    public boolean isBrojProst(BigInteger broj) {
        boolean rezultat = false;
        BigInteger index = new BigInteger("2");
        BigInteger provjera = new BigInteger("1000000");

        while(true) {
            if(broj.equals(BigInteger.ONE) || broj.equals(BigInteger.TWO)) { //maknuti po potrebi
                rezultat = true;
                break;
            }

            if(broj.mod(index).equals(BigInteger.ZERO)) {
                rezultat = false;
                break;
            }
            else if(broj.sqrt().equals(index)) {
                rezultat = true;
                break;
            }
            index = index.add(BigInteger.ONE);
            if(index.mod(provjera).equals(BigInteger.ZERO)) { //maknuti po potrebi
                System.out.println(index);
            }
        }
        return rezultat;
    }

    public void classFunctionRastaviNaProste() {
        BigInteger MersenneNumber = new BigInteger("1");
        BigInteger DESET = new BigInteger("10");
        BigInteger TRI = new BigInteger("3");
        try {
            String fileName = new String("Baza10Data"+beginning+"-"+limit+".txt");
            FileWriter writer = new FileWriter(fileName);
            writer.append("EKSPONENT / FAKTOR1 / FAKTOR2\n");

            for(int index = beginning; index <= limit; index++) {
                if(index % 100 == 0) {
                    System.out.println(index+" FROM THREAD"+(beginning)+"........."+(limit-index)+" = "+(((double)(index-beginning)/(limit-beginning))*100)+"% "+"IS DONE");
                }

                if(provjeraValjanostiIndexa(index)) {
                    MersenneNumber = DESET.pow(index).subtract(TRI);
                    //System.out.println("KONSTRUKCIJA POCELA");
                    //MersenneNumber = konstrukcijaBroja(index);
                    //System.out.println("KONSTRUKCIJA GOTOVA");
                    String indexx = new String(""+index);
                    BigInteger factor1 = new BigInteger(""+rastaviNaProste(MersenneNumber));
                    if(factor1.equals(BigInteger.ZERO)) {
                        writer.append(indexx+" VEĆE OD 100 000 NE RACUNAM \n");
                    }
                    else {
                        writer.append(indexx+" "+factor1+" * ...\n");
                    }
                }
            }

            System.out.println("! THREAD"+(beginning)+" IS DONE");
            writer.close();
        } catch (IOException e) {
            System.out.println("! SOMETHING IS WRONG IN THREAD"+(beginning));
        }
    }

    public BigInteger rastaviNaProste(BigInteger N) {
        BigInteger q = new BigInteger("2"); // q < p
        while(true) {
            if(N.mod(q).equals(BigInteger.ZERO)) {
                break;
            }
            while(true) {
                q = q.add(BigInteger.ONE);
                if(isBrojProst(q)) {
                    break;
                }
            }
            if(q.intValue() > 1000000) { //100 003 je prvi prosti broj poslije 100 000
                q = BigInteger.ZERO;
                break;
            }
        }
        return q;
    }
    public void konstrukcijaBrojaPredprocesorskaNaredba(int index) { //MersenneNumber = DESET.pow(index).subtract(TRI);
                                                                     //index ovdje predstavlja prvu pozitivnu opciju od beginning broja
                                                                     //boolean isConstructingDone = false;
                                                                     //public String BROJ;
                                                                     //public int BROJ_ZNAMENKI;
        //String fill = "";
        /*for(int i = 0; i < index-1; i++) {
            fill = fill + '9';
        }*/
        BigInteger MersenneNumber = new BigInteger("1");
        BigInteger DESET = new BigInteger("10");
        BigInteger TRI = new BigInteger("3");
        MersenneNumber = DESET.pow(index).subtract(TRI);
        
        BROJ = new StringBuilder(""+MersenneNumber);
        BROJ_ZNAMENKI = index;
        isConstructingDone = true;
    }
    public void konstrukcijaBroja(int index) { //uvesti samo biginteger i izracunati unaprijed 10^n, a kasnije neka konacna varijabla oduzme 3
        BigInteger rezultatBigInt;

        if(!isConstructingDone) {
            System.out.println("RACUNANJE MAIN BROJA");
            konstrukcijaBrojaPredprocesorskaNaredba(index);
            rezultatBigInt = new BigInteger(""+BROJ);
        }
        else {
            BROJ = new StringBuilder("99997");
            BROJ_ZNAMENKI = 5;
            int rezlika = index - BROJ_ZNAMENKI;
            BROJ = BROJ.deleteCharAt(BROJ_ZNAMENKI-1);
            for(int i = 0; i < rezlika; i++) {
                
            }
            BROJ = BROJ.append("7");
            BROJ_ZNAMENKI = index;
            rezultatBigInt = new BigInteger(""+BROJ);

        }
    }
    public void K_L_ANALIZA() {

        BigInteger MersenneNumber = new BigInteger("1");
        BigInteger DESET = new BigInteger("10");
        BigInteger TRI = new BigInteger("3");
        ArrayList<Integer> F1 = new ArrayList<Integer>();
        boolean proslo = true;
        try {
            String fileName1 = new String("K_L_ANALIZA_K"+beginning+"-"+limit+".txt");
            String fileName2 = new String("K_L_ANALIZA_L"+beginning+"-"+limit+".txt");
            String fileName3 = new String("K_L_ANALIZA_SVE"+beginning+"-"+limit+".txt");
            FileWriter writer1 = new FileWriter(fileName1);
            FileWriter writer2 = new FileWriter(fileName2);
            FileWriter writer3 = new FileWriter(fileName3);
            writer3.append("PRVI SE PUTA JAVLJA(index) / PROSTI FAKTOR \n");

            for(int index = beginning; index <= limit; index++) {
                if(index % 100 == 0) {
                    System.out.println(index+" FROM THREAD"+(beginning)+"........."+(limit-index)+" = "+(((double)(index-beginning)/(limit-beginning))*100)+"% "+"IS DONE");
                }

                //if(provjeraValjanostiIndexa(index)) {
                    MersenneNumber = DESET.pow(index).subtract(TRI);
                    String indexx = new String(""+index);
                    BigInteger factor1 = new BigInteger(""+rastaviNaProste(MersenneNumber));
                    for(int i = 0;i<F1.size();i++) {
                        if(F1.get(i).equals(factor1.intValue())) {
                            proslo = false;
                            break;
                        }
                        else {
                            proslo = true;
                        }
                    }
                    if(proslo){
                        //writer1.append(indexx+" * "+F1.get(F1.size()-1)+" ...\n");
                        F1.add(factor1.intValue());
                        writer1.append((F1.get(F1.size()-1).intValue()-1)+",");
                        writer2.append(indexx+",");
                        writer3.append(indexx+" * "+F1.get(F1.size()-1)+" ...\n");
                        proslo = true;
                    }
                //}
            }

            System.out.println("! THREAD"+(beginning)+" IS DONE");
            writer1.close();
            writer2.close();
            writer3.close();
        } catch (IOException e) {
            System.out.println("! SOMETHING IS WRONG IN THREAD"+(beginning));
        }
    }

    public boolean provjeraValjanostiIndexa(int index) { //cilj je dodavati sto vise situacija kada index ne moze dati prosti broj
        boolean isValjan = true; //x*n + l
        if(index % 6 == 4 || index % 6 == 1) { // za F1 = 13,7
            isValjan = false;
        }

        for(int i = 0; i < duljina1_5000; i++) {
            if(index%k[i] == l[i]) {
                isValjan = false;
                break;
            }
        }
        
        
        return isValjan;
    }
}
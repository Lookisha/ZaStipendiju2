import java.math.BigInteger;

public class Dekripcija {
    private String C; // kriptirana poruka u ascii
    private String D = ""; // dekriptirana poruka u ascii
    private BigInteger p; // prosti broj, PRIVATNO, VEĆI!
    private BigInteger q; // prosti broj, PRIVATNO, MANJI!
    //private BigInteger N; // p * q, JAVNO
    private int e; // e i (p-1)*(q-1) - ne djeljivi JAVNO
    private BigInteger d; //racunas pomoću Euklidovog algoritma

    Dekripcija(String C,BigInteger p,BigInteger q,int e) {
        this.C = C;
        this.p = p;
        this.q = q;
        this.e = e;
    } 


    public String dekriptirajBF() { //brute force
        BigInteger minusJedan = new BigInteger("-1");
        BigInteger n = new BigInteger(""+((p.add(minusJedan)).multiply(q.add(minusJedan))));
        BigInteger ee = new BigInteger(""+e);
        BigInteger rezultat = new BigInteger("0");
        //N = p.multiply(q);
        while(true) {

            BigInteger de = new BigInteger(""+(d.multiply(ee)));
            rezultat = de.mod(n);
            d = d.add(BigInteger.ONE);
            if(rezultat.equals(BigInteger.ONE)){
                d = d.add(minusJedan);
                break;
            }
        }

        //D = C.pow(d.intValue()).mod(N);
        return D;
    }

    public String dekriptiraj() {
        BigInteger minusJedan = new BigInteger("-1");
        BigInteger ee = new BigInteger(""+e);
        BigInteger lcd = new BigInteger(""+lcd(p.add(minusJedan), q.add(minusJedan)));
        System.out.println("lcd"+lcd);
        d = lcd.divide(ee).add(BigInteger.ONE);
        d = d.multiply(ee);
        BigInteger dSingle = new BigInteger(""+d);
        //N = p.multiply(q);
        while(true) { //cilj je izračunati d

            d = d.add(dSingle);
            //BigInteger ed = new BigInteger(""+d.multiply(ee));
            while(true) {
                if(d.mod(lcd).compareTo(ee) == -1) { //if(d.mod(lcd).longValue() < e)
                    break;
                }
                d = d.add(ee.multiply(minusJedan));
            }

            if(d.mod(lcd).equals(BigInteger.ONE)) {
                d = d.divide(ee);
                break;
            }
        }

        BigInteger dp = new BigInteger("0");
        BigInteger dq = new BigInteger("0");
        BigInteger qinv = new BigInteger("0");

        BigInteger m1 = new BigInteger("0");
        BigInteger m2 = new BigInteger("0"); //m = D
        BigInteger h = new BigInteger("0");

        dp = d.mod(p.add(minusJedan));
        dq = d.mod(q.add(minusJedan));
        qinv = q.modInverse(p);

        BigInteger d = new BigInteger("0");
        int brojac = 1;
        while(brojac <= getBrojBlokova()) {
            BigInteger blok = new BigInteger(""+getBlock(brojac));

            //m1 = blok.pow(dp.intValueExact()).mod(p);
            //m2 = blok.pow(dq.intValueExact()).mod(q);
            m1 = blok.modPow(dp, p);
            m2 = blok.modPow(dq, q);
            h = (qinv.multiply(m1.add(m2.multiply(minusJedan)))).mod(p);
            d = m2.add(h.multiply(q));
            D = D + d.toString();

            brojac++;
        }
        return D;
    }

    public BigInteger lcd(BigInteger pFunction, BigInteger qFunction) {
        BigInteger rezultatFunkcija = new BigInteger("1");
        BigInteger rezultat = new BigInteger("1");

        BigInteger pFunctionPrije = new BigInteger(""+pFunction);
        BigInteger qFunctionPrije = new BigInteger(""+qFunction);

        while(true) {
            rezultat = pFunction.mod(qFunction); //vrijedi da je p > q
            if(rezultat.equals(BigInteger.ZERO)) {
                rezultatFunkcija = pFunctionPrije.multiply(qFunctionPrije).divide(qFunction);
                break;
            }
            pFunction = qFunction;
            qFunction = rezultat;
        }
        return rezultatFunkcija;
    }
    public BigInteger getBlock(int position) {
        int brojZnamenki;
        int brojac = 0;
        int data = 0;

        for(int i = 0; i < C.length(); i++) {
            if(brojac == position) {
                data = i;
                break;
            }
            if(C.charAt(i) == '$') {
                brojac++;
            }
        }
        brojZnamenki = (int) C.charAt(data) - 48;

        if(C.charAt(data+1) != '$') {
            brojZnamenki *= 10;
            brojZnamenki += C.charAt(data+1) - 48;
        }
        System.out.println(brojZnamenki);
        System.out.println(getZbrojDoUsklicnika(position));

        String x = C.substring(getZbrojDoUsklicnika(position), getZbrojDoUsklicnika(position)+brojZnamenki);
        System.out.println(x);
        BigInteger blok = new BigInteger(""+x);

        return blok;
    }
    public int getZbrojDoUsklicnika(int position) {
        int rezultat = 0;
        int brojac = 0;
        int data = 0;
        while(true) {
            int broj = 0;
            if(position-1 == brojac) {
                break;
            }
            for(int i = data; i < C.length(); i++) {
                if(C.charAt(i) == '$') {
                    data = i+1;
                    brojac++;
                    break;
                }
            }
            broj = (int)C.charAt(data) - 48;
            if(C.charAt(data+1) != '$') {
                broj *= 10;
                broj += (int)C.charAt(data+1) - 48;
            }
            rezultat = rezultat + broj;
        }

        return rezultat;
    }
    public int getBrojBlokova() {
        int rezultat = 0;
        int brojac = 0;
        for(int i = 0; i < C.length(); i++) {
            if(C.charAt(i) == '$') {
                brojac++;
            }
        }
        rezultat = brojac - 1;

        return rezultat;
    }

}
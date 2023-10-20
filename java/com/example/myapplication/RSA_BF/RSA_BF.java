package com.example.myapplication.RSA_BF;

import java.math.BigInteger;

public class RSA_BF {
    public final BigInteger NULA = new BigInteger("0");
    public final BigInteger JEDAN = new BigInteger("1");
    BigInteger N;
    BigInteger p = null;
    BigInteger q = null;

    public RSA_BF(BigInteger N) {
        this.N = N;
    }

    public BigInteger calculate_p () {
        if(N.isProbablePrime(1) || N.equals(BigInteger.ONE)) return new BigInteger("-1");

        BigInteger counter = new BigInteger("2");
        while(!N.mod(counter).equals(NULA)) {
            counter = getNewPrime(counter);
        }
        p = counter;

        return p;
    }

    public BigInteger calculate_q () {
        if(p == null) {
            return new BigInteger("-1");
        }
        q = N.divide(p);

        return q;
    }

    public int expectedTime() {
        int time = 0;

        return time;
    }

    private BigInteger getNewPrime(BigInteger counter) {

        do {
            counter = counter.add(JEDAN);
        } while (!counter.isProbablePrime(1));

        return counter;
    }

}
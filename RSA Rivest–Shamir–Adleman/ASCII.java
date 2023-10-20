import java.math.BigInteger;
public class ASCII {
    
    ASCII() {
        
    }
    
    public BigInteger stringInNumber (String string) {
        string = string.toUpperCase();
        String rezultatString = "";
        BigInteger rezultat = new BigInteger("0");
        BigInteger p = new BigInteger("1");
        BigInteger DESET = new BigInteger("10");
        char znak;
        StringBuffer buffer = new StringBuffer(rezultatString);


        for(int i = 0; i < string.length(); i++) {
            znak = string.charAt(i);
            rezultatString = buffer.append((int)znak).toString();
        }

        for(int i = rezultatString.length()-1; i >= 0; i--) {

            int broj = (int)rezultatString.charAt(i) - 48;
            BigInteger brojB = new BigInteger(""+broj);
            rezultat = rezultat.add(brojB.multiply(p));
            p = p.multiply(DESET);
        }
        

        if(rezultat.equals(BigInteger.ZERO)) {
            System.out.println("Something went wrong ):");
        }

        return rezultat;
    }
    public String numberInString (BigInteger ASCIIbroj) { //pretvara ASCII sekvencu brojeva nazad u String, da bi radio kako treba brojevi znakova ne smiju biti veći od 99, i manji od 10
        String rezultat = "";
        String rezultat2 = "";
        StringBuffer sb = new StringBuffer(rezultat);
        BigInteger STO = new BigInteger("100");
        
        while(true) {
            int code = ASCIIbroj.mod(STO).intValue();
            char codeC = (char)code;
            rezultat = sb.append(codeC).toString();
            ASCIIbroj = ASCIIbroj.divide(STO);
            
            if(ASCIIbroj.equals(BigInteger.ZERO)) {
                System.out.println("proslo");
                break;
                
            }
        }
        System.out.println(rezultat);
        rezultat2 = rezultat;
        for(int i = 0; i < rezultat.length(); i++) {

            sb.setCharAt(i, rezultat2.charAt(rezultat2.length()-1-i));
        }
        rezultat = sb.toString();
        return rezultat;
    }
}

package Osnove;
import java.awt.*;
public class PointConstructor implements Konstante { //eksplicitno za cube
    Point A;
    Point B;
    Point C;
    Point D;
    Point A1;
    Point B1;
    Point C1;
    Point D1;
    int xDisplay;
    int yDisplay;
    boolean isVrijednostValjana;
    PointConstructor(int[] relativneKoordinate, double[] playerPosition) { //eksplicitno za cube
        //MyPanel panel = new MyPanel();

        xDisplay = display(getX_Stv(relativneKoordinate, playerPosition),getZ_Stv(relativneKoordinate, playerPosition));
        yDisplay = display(getY_Stv(relativneKoordinate, playerPosition),getZ_Stv(relativneKoordinate, playerPosition));

        A = new Point(xDisplay,yDisplay);

        xDisplay =display(getX_Stv(relativneKoordinate, playerPosition),getZ_Stv(relativneKoordinate, playerPosition)+CUBE_LENGHT);
        yDisplay = display(getY_Stv(relativneKoordinate, playerPosition),getZ_Stv(relativneKoordinate, playerPosition)+CUBE_LENGHT);

        B = new Point(xDisplay,yDisplay);

        xDisplay = display(getX_Stv(relativneKoordinate, playerPosition)+CUBE_LENGHT,getZ_Stv(relativneKoordinate, playerPosition)+CUBE_LENGHT);
        yDisplay = display(getY_Stv(relativneKoordinate, playerPosition),getZ_Stv(relativneKoordinate, playerPosition)+CUBE_LENGHT);

        C = new Point(xDisplay,yDisplay);

        xDisplay = display(getX_Stv(relativneKoordinate, playerPosition)+CUBE_LENGHT,getZ_Stv(relativneKoordinate, playerPosition));
        yDisplay = display(getY_Stv(relativneKoordinate, playerPosition),getZ_Stv(relativneKoordinate, playerPosition));

        D = new Point(xDisplay,yDisplay);

        //dubina (y) se mijenja

        xDisplay = display(getX_Stv(relativneKoordinate, playerPosition),getZ_Stv(relativneKoordinate, playerPosition));
        yDisplay = display(getY_Stv(relativneKoordinate, playerPosition)+CUBE_LENGHT,getZ_Stv(relativneKoordinate, playerPosition));

        A1 = new Point(xDisplay,yDisplay);

        xDisplay = display(getX_Stv(relativneKoordinate, playerPosition),getZ_Stv(relativneKoordinate, playerPosition)+CUBE_LENGHT);
        yDisplay = display(getY_Stv(relativneKoordinate, playerPosition)+CUBE_LENGHT,getZ_Stv(relativneKoordinate, playerPosition)+CUBE_LENGHT);

        B1 = new Point(xDisplay,yDisplay);

        xDisplay = display(getX_Stv(relativneKoordinate, playerPosition)+CUBE_LENGHT,getZ_Stv(relativneKoordinate, playerPosition)+CUBE_LENGHT);
        yDisplay = display(getY_Stv(relativneKoordinate, playerPosition)+CUBE_LENGHT,getZ_Stv(relativneKoordinate, playerPosition)+CUBE_LENGHT);

        C1 = new Point(xDisplay,yDisplay);

        xDisplay = display(getX_Stv(relativneKoordinate, playerPosition)+CUBE_LENGHT,getZ_Stv(relativneKoordinate, playerPosition));
        yDisplay = display(getY_Stv(relativneKoordinate, playerPosition)+CUBE_LENGHT,getZ_Stv(relativneKoordinate, playerPosition));

        D1 = new Point(xDisplay,yDisplay);
    }
    

    //za cube
    public int getX_Stv (int[] relativneKoordinate,double[] playerPosition) { //vraća x koordinatu main točke za inesene relativne koordinate bloka, <STV = stvarno>
        int koordinata = 0;
        koordinata = (int)((relativneKoordinate[0]-playerPosition[0]) * CUBE_LENGHT);
        if(koordinata == 0) {
            //System.out.println("x");
            //System.out.println();
            //koordinata = -1;
        }
        return koordinata;
    }

    public int getY_Stv (int[] relativneKoordinate,double[] playerPosition) { //vraća y koordinatu main točke
        int koordinata = 0;
        koordinata = (int)((relativneKoordinate[1]+playerPosition[1]) * CUBE_LENGHT);
        if(koordinata == 0) {
            //System.out.println("y");
            //System.out.println();
            //koordinata = -1;
        }
        return koordinata;
    }

    public int getZ_Stv (int[] relativneKoordinate,double[] playerPosition) { //vraća z koordinatu main točke
        int koordinata = 0;
        koordinata = (int) ((relativneKoordinate[2]-22+playerPosition[2]) * CUBE_LENGHT);
        if(koordinata > -1 && koordinata < 1) {
            //System.out.println("z");
            //System.out.println(relativneKoordinate[2]+" "+playerPosition[2]);
            //koordinata = -1;
        }
        return koordinata;
    }

    public int display(int stvaranaKoordinata_XY, int stvaranaKoordinata_Z) { //XY je x ili y (ne može oboje)
        int koordinataDisplay = 0;

        koordinataDisplay = (int) ((double)stvaranaKoordinata_XY * (Konstante.z / (Konstante.z + stvaranaKoordinata_Z)));
        if(koordinataDisplay > -10 && koordinataDisplay <10) {
            //System.out.println(0);
        }
        return koordinataDisplay;
    } 

}
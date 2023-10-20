package Osnove;

public interface Konstante {
    int PANEL_WIDTH = 1000; //800 je bilo prije
    int PANEL_HEIGHT = 600;
    int FOV = 60;
    double FOV_RAD = FOV * 0.01745329252;
    int CUBE_LENGHT = 32;
    int[] relativneKoordinate = {0,0,0}; //  (x,y,z)
    
    double z = (PANEL_WIDTH / 2) / Math.tan(FOV_RAD/2);

    double PLAYER_SPEED = 0.1; //prava brzina igrača je zapravo 0.1 * (1000 / timerSpeed)

    int WORLD_SIZE_X = 10;
    int WORLD_SIZE_Y = 10;
    int WORLD_SIZE_Z = 2;
}

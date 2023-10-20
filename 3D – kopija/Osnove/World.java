package Osnove;

public class World implements Konstante{
    int[][] blockData = new int[WORLD_SIZE_X*WORLD_SIZE_Y*WORLD_SIZE_Z][4];
    int brojacBlokovi = 0;
    World() {
        //brojevi unutar viticastih zagrada predstavljaju koordinate jednog bloka -> {x,y,z,id}
        //int[][]blockData = {{0,0,0,0},{0,0,1,0},{0,0,2,0},{0,0,3,0}}; primjer -> prvo broj je broj kućice, a drugi je element u kućici

        for(int i = 0; i < WORLD_SIZE_X; i++) {
            for(int j = 0; j < WORLD_SIZE_Y; j++) {
                for(int k = 0; k < WORLD_SIZE_Z; k++) {

                    blockData[brojacBlokovi][0] = i; //x
                    blockData[brojacBlokovi][1] = j; //y
                    blockData[brojacBlokovi][2] = k; //z
                    blockData[brojacBlokovi][3] = 1; //ID = 1 za neki najobicniji block

                    brojacBlokovi++;
                }
            }
        }
    }

    public int getBlockID(int x,int y,int z) {
        int id = -1;
        for(int i = 0; i < (WORLD_SIZE_X*WORLD_SIZE_Y*WORLD_SIZE_Z); i++) {
            if(blockData[i][0] == x && blockData[i][1] == y && blockData[i][2] == z) {
                //System.out.println(i);
                id = blockData[i][3];
            }
        }
        return id;
    }

    public void terrainGeneration() {

    }
    public void blockDestroyed() {

    }
    public void blockPlaced() {

    }
    public void ispisiWorldData() {
        for(int i = 0; i < WORLD_SIZE_X*WORLD_SIZE_Y*WORLD_SIZE_Z; i++) {
            for(int j = 0; j < 4; j++) {
                System.out.print(blockData[i][j]);
                System.out.print(",");
            }
            System.out.println();
        }
    }



}
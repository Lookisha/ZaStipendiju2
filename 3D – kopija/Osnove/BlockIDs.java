package Osnove;

public class BlockIDs { //za dani id stavlja teksturu
    
    BlockIDs() {

    }

    public void getBlock(int id) {

        switch (id) {
            case -1: {
                System.out.println("nista");
            }
                break;
            case 0: {
                System.out.println("zrak");
            }
                break;
            case 1: {
                System.out.println("neki obican blok");
            }
                break;
            
        }

    }

}

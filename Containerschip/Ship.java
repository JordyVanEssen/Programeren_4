import java.util.ArrayList;
import java.util.concurrent.Semaphore;
import java.lang.Thread;


public class Ship{
    ArrayList<Container> containers = new ArrayList<Container>();

    // the contstructor of the ship class
    // the ship is filled with containers
    public Ship(){
       fillShip(100);
    }

    public void start(){
        while (!shipEmpty()){
            Main.notifyCrane();
        }
        System.out.println("Schip heeft geen containers meer...");
    }

    public void fillShip(int pAmount){
        for (int i = 0; i < pAmount; i++) {
            containers.add(new Container(i));
        }

        System.out.println("Er is een schip gearriveerd met "+ containers.size() + " containers.");
    }

    // this function is used to unload the ship
    public synchronized Container removeContainer(){
        Container container = new Container(-1);
        if (containers.size() > 0) {
            try {
                container = containers.get(containers.size() - 1) ;
            
            } catch (IndexOutOfBoundsException e) {
                container = containers.get(containers.size() - 2) ;
            }

            containers.remove(container);   
            System.out.println("SHIP: Container: " + container.volgNummer + " gegeven.");

            return container;
        }
        return null;
    }

    public boolean shipEmpty(){
        if(containers.size() <= 0)
            return true;

        return false;
    }
}
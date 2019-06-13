import java.util.ArrayList;
import java.util.concurrent.Semaphore;
import java.lang.Thread;


public class Ship{
    ArrayList<Container> containers = new ArrayList<Container>();

    // the contstructor of the ship class
    // the ship is filled with containers
    public Ship(){
       
    }

    public void fillShip(int pAmount){
        for (int i = 0; i < 100; i++) {
            containers.add(new Container(i));
        }

        System.out.println(containers.size());
        System.out.println("Er is een schip gearriveerd met "+ pAmount + " containers.");
    }

    // this function is used to unload the ship
    public Container removeContainer(){
        Container container = new Container(-1);
        if (containers.size() > 0) {
            try {
                container = containers.get(containers.size() - 1) ;
            
            } catch (IndexOutOfBoundsException e) {
                container = containers.get(containers.size() - 2) ;
            }

            if (!container.reserved) {
                container.reserved = true;
                containers.remove(container);   
                System.out.println("SHIP: Container: " + container.volgNummer + " gegeven.");

                return container;
            }
        }
        return null;
    }
}
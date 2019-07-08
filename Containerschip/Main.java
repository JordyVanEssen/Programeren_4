import java.util.*;

public class Main{
    private static int craneAmount = 2;
    private static int truckAmount = 3;

    private static Crane[] cranes;
    private static Truck[] trucks;

    public static Dock dock = new Dock();
    public static Ship ship = new Ship();

    public static void main(String[] args) {
        cranes = new Crane[craneAmount];
        trucks = new Truck[truckAmount];

        // create the cranes
        for (int i = 0; i < craneAmount; i++) {
            cranes[i] = new Crane("Kraan " + (i+1), ship, dock);
            Thread tr = new Thread(cranes[i]);
            tr.start();
        }

        // create the trucks
        for (int i = 0; i < truckAmount; i++) { 
            trucks[i] =  new Truck("Truck " + (i+1), dock);
            Thread tr = new Thread(trucks[i]);
            tr.start();
        }

        ship.start();
    }

    // notify the cranes when the ship has a container to offer
    public static void notifyCrane(){
        for (Crane c : cranes) {
            synchronized(c) {
                c.notify();
            }
        }
    }

    // notify all the trucks when the dock has some containers stored
    public static void notifyTruck(){
        for (Truck t : trucks) {
            synchronized(t) {
              t.notify();
            }
        }
    }
}
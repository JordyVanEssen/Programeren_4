import java.util.ArrayList;;

public class Ship{
    ArrayList<Container> containers = new ArrayList<Container>();

    // the contstructor of the ship class
    // the ship is filled with containers
    public Ship(){
        if (this.containers.size() < 0) {
            this.fillShip(100);
        }
    }

    public void fillShip(int pAmount){
        for (int i = 0; i < 100; i++) {
            containers.add(new Container(i));
        }

        System.out.println(containers.size());
        System.out.println("A ship has arrived at the docks with "+ pAmount + " containers.");
    }

    // this function is used to unload the ship
    public Container removeContainer(){
        System.out.println(containers.size());

        if (containers.size() > 0) {
            Container container = containers.get(containers.size() - 1) ;

            if (!container.reserved) {
                container.reserved = true;
    
                System.out.println("SHIP: Unloading container number: " + container.volgNummer);
                containers.remove(containers.size() - 1);   
                return container;
            }
        }
        return null;
    }
}
import java.util.*;

public class Dock{
    ArrayList<Container> containers = new ArrayList<Container>();
    int space = 5;

    public Dock(){    }

    public void storeContainer(Container pContainer){
        space--;
        containers.add(pContainer);
        System.out.println("DOCK: Container opgeslagen: " + pContainer.volgNummer);
        System.out.println("DOCK: Plaatsen beschikbaar: " + space);    

        Main.notifyTruck();
    }

    public synchronized Container releaseContainer(){
        Container container = containers.get(containers.size() - 1);
        if (container != null) {
            space++;
            containers.remove(container);
            System.out.println("DOCK: Container vrijgegeven: " + container.volgNummer);
            System.out.println("DOCK: Plaatsen beschikbaar: " + space);

            return container;
        }
        return null;
    }

    public boolean spaceAvailable(){
        if (space > 0) 
            return true; 
        return false;
    }
}
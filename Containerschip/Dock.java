import java.util.ArrayList;

public class Dock{
    ArrayList<Container> containers = new ArrayList<Container>();
    int space = 5;

    public Dock(){
        
    }

    public boolean storeContainer(Container pContainer){
        if (space > 0) {
            space--;
            containers.add(pContainer);
            System.out.println("DOCK: Container opgeslagen: " + pContainer.volgNummer);
            System.out.println("DOCK: Plaatsen beschikbaar: " + space);

            return true;
        }
        return false;
    }

    public Container releaseContainer(){
        Container container = containers.get(containers.size() - 1);
        if (container != null) {
            space++;
            containers.remove(container);
            System.out.println("DOCK: Container vrijgegeven: " + container.volgNummer);

            return container;
        }
        return null;
    }
}
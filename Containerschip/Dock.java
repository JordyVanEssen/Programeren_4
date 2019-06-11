import java.util.ArrayList;;

public class Dock{
    ArrayList<Container> containers = new ArrayList<Container>();
    int max = 5;

    public Dock(){
        
    }

    public boolean storeContainer(Container pContainer){
        if (max > 0) {
            max--;
            containers.add(pContainer);
            return true;
        }
        return false;
    }

    public Container releaseContainer(){
        if (containers.get(containers.size() - 1) != null) {
            max++;
            return containers.get(containers.size() - 1);
        }
        return null;
    }
}
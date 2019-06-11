import java.util.Random;

public class Crane extends Thread{
    Ship ship = new Ship();
    Dock dock = new Dock();
    Random random = new Random();
    String naam;

    public Crane(String pNaam){
        this.naam = pNaam;
    }

    @Override
    public void run() {
        getContainer();
    }

    public void getContainer(){
        Container container = ship.removeContainer();

        if (container == null) {
            getContainer();
        }

        System.out.println(this.naam + " Got container: " + container.volgNummer);

        try {
            Thread.sleep(random.nextInt(5000) + 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        container.reserved = false;
        dumpContainer(container);
    }

    public void dumpContainer(Container pContainer){
        boolean stored = false;
        while (!stored) {
            stored = dock.storeContainer(pContainer);
        }

        System.out.println("Container " + pContainer.volgNummer + " stored on the dock.");
    }
}
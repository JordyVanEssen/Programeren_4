import java.util.Random;

public class Crane extends Thread{
    Ship ship = new Ship();
    Dock dock = new Dock();
    Random random = new Random();
    String naam;

    public Crane(String pNaam){
        this.naam = pNaam;
        ship = Main.ship;
        dock = Main.dock;
    }

    @Override
    public void run() {
        while (true) {
            getContainer();
        }
    }

    public synchronized void getContainer(){
        System.out.println(this.naam.toUpperCase() + ": Wil container halen.");

        try {
            Thread.sleep(random.nextInt(5000) + 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Container container = ship.removeContainer();

        if (container == null) {
            getContainer();
        }

        System.out.println(this.naam.toUpperCase() + ": Kreeg container: " + container.volgNummer);
        
        container.reserved = false;
        dumpContainer(container);
    }

    public synchronized void dumpContainer(Container pContainer){
        boolean stored = false;
        while (!stored) {
            stored = dock.storeContainer(pContainer);
        }
    }
}
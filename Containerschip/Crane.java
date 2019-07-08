import java.util.Random;

public class Crane extends Thread {
    Random random = new Random();
    Ship ship;
    Dock dock;
    String naam;
    private Container container;

    public Crane(String pNaam, Ship pShip, Dock pDock) {
        this.naam = pNaam;
        this.ship = pShip;
        this.dock = pDock;
    }

    @Override
    public void run() {
        while (true) {
            getContainer();
        }
    }

    public void getContainer() {
        System.out.println(this.naam.toUpperCase() + ": Wil container halen.");

        // gets the container from the ship
        this.container = this.ship.removeContainer();

        // wait for a notification from the ship if there is a container available
        if (this.container == null) {
            try {
                synchronized (this) {
                    this.wait();
                }
            } catch (Exception e) {}
        }

        if (this.container != null) {
            try {
                this.container.sem.acquire(); // get semaphore to reserve the container
            } catch (Exception e) {
            }

            System.out.println(this.naam.toUpperCase() + ": Kreeg container: " + container.volgNummer);

            dock.storeContainer(this.container);

            this.container.sem.release();

            try {
                Thread.sleep(random.nextInt(3000) + 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
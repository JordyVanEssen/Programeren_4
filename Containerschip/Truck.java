import java.util.Random;

public class Truck extends Thread{
    Dock dock;
    Random random = new Random();
    String naam;
    Container container;

    public Truck(String pNaam, Dock pDock){
        this.naam = pNaam;   
        this.dock = pDock;
    }

    @Override
    public void run() {
        while (true) {
            getContainer();
        }
    }

    public void getContainer(){
        try {
            System.out.println(this.naam + ": Wil container halen....");

            this.container = dock.releaseContainer();
    
            if (this.container == null) {
                synchronized (this){
                    wait();
                }
            }

            if (this.container != null) {
                System.out.println("TRUCK " + this.naam + ": Heeft container " + this.container.volgNummer + " wegrijden...");
                Thread.sleep(random.nextInt(5000) + 1000);
            }

        } catch (Exception e) { }
    }
}
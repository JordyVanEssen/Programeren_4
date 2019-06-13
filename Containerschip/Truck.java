import java.util.Random;

public class Truck extends Thread{
    Dock dock = new Dock();
    Random random = new Random();
    String naam;

    public Truck(String pNaam){
        this.naam = pNaam;   
        dock = Main.dock; 
    }

    @Override
    public void run() {
        while (true) {
            getContainer();
        }
    }

    public synchronized void getContainer(){
        try {
            Container container = new Container(-1);

            System.out.println("TRUCK " + this.naam + ": Wil container halen....");

            Thread.sleep(random.nextInt(1000) + 1000);

            container = dock.releaseContainer();

            if (container == null) {
                getContainer();
            }

            System.out.println("TRUCK " + this.naam + ": Heeft container: " + container.volgNummer + " wegrijden...");

            Thread.sleep(random.nextInt(1000) + 5000);

        } catch (Exception e) {
            //TODO: handle exception
        }
    }
}
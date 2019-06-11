public class Truck extends Thread{
    String naam;

    public Truck(String pNaam){
        this.naam = pNaam;    
    }

    @Override
    public void run() {
        getContainer();
    }

    public void getContainer(){

    }
}
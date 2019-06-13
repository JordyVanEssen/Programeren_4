public class Main{
        
        static Ship ship = new Ship();
        static Dock dock = new Dock();
        static Crane cr1 = new Crane("Kraan 1");
        static Crane cr2 = new Crane("Kraan 2");
        static Truck truck1 = new Truck("A");
        static Truck truck2 = new Truck("B");
        static Truck truck3 = new Truck("C");

    public static void main(String[] args) {
        Thread tCrane1 = new Thread(cr1);
        Thread tCrane2 = new Thread(cr2);

        Thread tTruck1 = new Thread(truck1);
        Thread tTruck2 = new Thread(truck2);
        Thread tTruck3 = new Thread(truck3);

        ship.fillShip(100);

        tCrane1.start();
        tCrane2.start();

        tTruck1.start();
        tTruck2.start();
        tTruck3.start();
    }
}
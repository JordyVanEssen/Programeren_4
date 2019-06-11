public class Main{
        Ship ship = new Ship();

    public static void main(String[] args) {
        Crane cr1 = new Crane("Crane 1");
        Crane cr2 = new Crane("Crane 2");

        cr1.start();
        cr2.start();
    }
}
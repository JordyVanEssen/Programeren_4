import java.util.concurrent.Semaphore;

public class Container{
    Semaphore sem;
    public int volgNummer;

    public Container(int pVolgnummer){
        this.volgNummer = pVolgnummer;
        sem = new Semaphore(1);
    }
}
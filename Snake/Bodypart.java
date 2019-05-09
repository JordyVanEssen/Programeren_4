import java.awt.Point;

public abstract class Bodypart extends Point{
    
    public void create(int pX, int pY){
        this.x = pX;
        this.y = pY;
    }
}
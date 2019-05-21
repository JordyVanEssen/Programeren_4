import java.awt.Color;
import java.awt.Point;

public class Head extends Bodypart{

    public Head(Bodypart pNext){
        super(Color.black, pNext);
    }

    // creates a new position
    @Override
    public Point create(int pX, int pY) {
        return super.create(pX, pY);
    }
}
import java.awt.Color;
import java.awt.Point;

public class Food extends GameElement {
    
    public Food(){
        super(Color.RED);
    }

    @Override
    public Point create(Bodypart pBodypart) {
        _position = new Point(50, 50);

        if (pBodypart._position.equals(this._position)) {
            if (pBodypart._next != null) {
                create(pBodypart._next);
            }
        }
        return _position;
    }
}
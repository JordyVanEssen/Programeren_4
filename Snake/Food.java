import java.awt.Color;
import java.awt.Point;
import java.util.Random;

public class Food extends GameElement {
    Random _random = new Random();
    
    public Food(){
        super(Color.RED);
    }

    @Override
    public Point create(Bodypart pBodypart) {
        _position = new Point(_random.nextInt(60) + 10, _random.nextInt(60) + 10);

        // checks if the new position is on top of the snake
        if (pBodypart._position.equals(this._position)) {
            if (pBodypart._next != null) {
                create(pBodypart._next);
            }
        }
        return _position;
    }
}
import java.awt.Color;
import java.awt.Point;

// Game element, Head, Body and the food
public class GameElement extends Point{
    Color _partColor;
    Point _position;
    public GameElement(Color pColor){
        this._partColor = pColor;
    }

    public Point create(int pX, int pY){
        _position = new Point(pX, pY);
        return _position;
    }

    /**
     * @return the _position
     */
    public Point getPosition() {
        return _position;
    }
}
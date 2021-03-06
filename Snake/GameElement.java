import java.awt.Color;
import java.awt.Point;

// GameElement => Head, Body and Food
public abstract class GameElement extends Point{
    Color _partColor;
    Point _position;

    public GameElement(Color pColor){
        this._partColor = pColor;
    }

    public Point create(int pX, int pY){
        _position = new Point(pX, pY);
        return _position;
    }

    public abstract Point create(Bodypart pBodypart);
}
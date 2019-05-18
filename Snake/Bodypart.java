import java.awt.Color;
import java.awt.Point;

public class Bodypart extends GameElement{
    Bodypart _next, _prev = null;
    boolean _endReached = false;

    public Bodypart(Color pColor, Bodypart pNext){
        super(pColor);
        this._next = pNext;

        if (pNext != null) {
            this._next._prev = this;
        }
    }

    public void print(Bodypart pBodypart){
        if (pBodypart != null) {
            System.out.println("Positions: " + pBodypart._position);
            print(pBodypart._next);
        }
    }

    public Bodypart getPart(Bodypart pBodypart){
        if (pBodypart != null) {
            return pBodypart;
        }
        return null;
    }

    public Boolean collision(Bodypart pBodypart){
        Point head = new Point();
        if (pBodypart._next != null) {
            if (pBodypart._prev == null) {
                head = pBodypart._position;
            }

            if (head.equals(pBodypart._next._position)) {
                return true;
            }
            collision(pBodypart._next);
        }
        return false;
    }

    public void update(Bodypart pBodypart, int pX, int pY){
        Snake snake = Program._snake;
        if (pBodypart._next != null && !_endReached) {
            update(pBodypart._next, pX, pY);
        }
        else{
            _endReached = true;
            if (pBodypart._prev != null) {
                pBodypart._position = pBodypart._prev._position;

                if (pBodypart._position.equals(snake._head._position)) {
                    pBodypart._position = new Point(snake._head._position.x - pX, snake._head._position.y - pY);
                }
                update(pBodypart._prev, pX, pY);
            }
            else{
                _endReached = false;
            }
        }
    }

    public void addBodyPart(Bodypart pBodypart, int pX, int pY){
        if (pBodypart._next == null) {

            pBodypart._next = new Bodypart(Color.BLUE, null);
            pBodypart._next._prev = pBodypart;
            pBodypart._next._position = new Point(pBodypart._position.x + pX, pBodypart._position.y + pY);
            return;
        }
        else{
            addBodyPart(pBodypart._next, pX, pY);
        }
    }

    public void delete(Bodypart pBodypart){
        if (pBodypart._next != null) {
            pBodypart._next = null;
        }
    }

    @Override
    public Point create(int pX, int pY) {
        return super.create(pX, pY);
    }

    @Override
    public Point getPosition() {
        return super.getPosition();
    }

    /**
     * @return _next
     */
    public GameElement getNext() {
        return _next;
    }
}
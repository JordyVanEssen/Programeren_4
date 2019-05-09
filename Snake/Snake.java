import java.awt.Point;
import java.util.ArrayList;
import java.util.LinkedList;

public class Snake extends Bodypart{
    Draw _draw = new Draw();
    public LinkedList<Bodypart> snakeBody = new LinkedList<Bodypart>();
    Point _startPosition;
    Bodypart _head;
    Frame _frame;
    
    //counter, movementspeed of the snake
    private int _millis = 0;

    //scale of the snake
    public int _scale = 10;

    public Snake(Point pPoint){
        _frame = new Frame();
        _startPosition = pPoint;
        _head = new Bodypart(pPoint);
    }

    // 0 => DOWN
    // 1 => RIGHT
    // 2 => UP
    // 3 => LEFT
    public void Move(int pDirection){
        _draw.repaint();
        _millis++;

        // defines the movementspeed of the snake
        if (_millis % 2 == 0) {
            snakeBody.add(_head);

            switch (pDirection) {
                case 0:
                    // DOWN
                    _head = new Bodypart(_head.x, _head.y + 1);
                    break;
                case 1:
                    // RIGHT
                    break;
                case 2:
                    // UP
                    break;
                case 3:
                    // LEFT
                    break;
                default:
                    break;
            }    
        }

        
    }
}
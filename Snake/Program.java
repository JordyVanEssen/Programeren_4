import java.awt.Point;

public class Program implements ActionListener, KeyListener{
    Draw _draw = new Draw();
    private static Snake _snake;
    public static void main(String[] args) {
        Point startPosition = new Point(0, -1);
        _snake = new Snake(startPosition);
    }

    @Override
    public void actionPerformed(){
        _snake.Move(0);// Move down by default
    }
}
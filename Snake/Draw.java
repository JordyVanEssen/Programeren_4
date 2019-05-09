import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import javax.swing.JPanel;

public class Draw extends JPanel{
    private Snake _snake;
    public Draw(Snake pSnake){
        _snake = pSnake;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.lightGray);
		g.fillRect(0, 0, 800, 700);

        g.setColor(Color.BLACK);

        for (Bodypart part : _snake.snakeBody) {
            g.fillRect(part.x * _snake._scale, part.y * _snake._scale, _snake._scale, _snake._scale);
        }
    }
}
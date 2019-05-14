import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.LinkedList;
import java.util.Iterator;

import javax.swing.JPanel;


public class Draw extends JPanel{

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Snake _snake = Program._snake;


        g.setColor(Color.GREEN);
		g.fillRect(0, 0, 800, 700);

        g.setColor(_snake._food._partColor);
        g.fillRect(_snake._food._position.x * _snake._scale, _snake._food._position.y * _snake._scale, _snake._scale, _snake._scale);

        for (GameElement bodyPart : _snake.snakeBody) {
            g.setColor(bodyPart._partColor);
            g.fillRect(bodyPart._position.x * _snake._scale, bodyPart._position.y * _snake._scale, _snake._scale, _snake._scale);
        }
    }
}
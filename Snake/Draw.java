import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;


public class Draw extends JPanel{
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Snake _snake = Program._snake;

        // draws a recangle on screen as representation of a part of the snake
        g.setColor(_snake._food._partColor);
        g.fillRect(_snake._food._position.x * _snake._scale, _snake._food._position.y * _snake._scale, _snake._scale, _snake._scale);

        Bodypart currentPart = _snake._head;
        g.fillRect(currentPart._position.x * _snake._scale, currentPart._position.y * _snake._scale, _snake._scale, _snake._scale);

        while (true) {
            // draws every part of the snake
            if (currentPart != null) {
                g.setColor(currentPart._partColor);
                g.fillRect(currentPart._position.x * _snake._scale, currentPart._position.y * _snake._scale, _snake._scale, _snake._scale);
            }

            if (currentPart._next != null) {
                currentPart = _snake._head.getPart(currentPart._next);
            }
            else{
                break;
            }
        }

        String text = "Score: " + _snake._score;
		
		g.setColor(Color.black);
		
        g.drawString(text, (int) (getWidth() / 2 - text.length() * 2.5f), 20);
        
        // if the snake's dead -> game over
        if (_snake._dead) {
            text = "GAME OVER";
            g.drawString(text, (int) (getWidth() / 2 - text.length() * 2.5f), (int) (getHeight() / 2 - text.length() * 2.5f));
            text = "press space to restart";
            g.drawString(text, (int) (getWidth() / 2 - text.length() * 2.5f), (int) ((getHeight() + 2) / 2 - text.length() * 2.5f));
        }
    }
}
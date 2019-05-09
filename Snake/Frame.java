import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import javax.swing.JFrame;

public class Frame{
    private int _height = 700;
    private int _width = 700; 
    Draw _draw = new Draw();

    public Frame(){
        JFrame frame = new JFrame("Snake");
        frame.setSize(_width, _height);
        frame.setVisible(true);
        frame.setResizable(false);
    }
}
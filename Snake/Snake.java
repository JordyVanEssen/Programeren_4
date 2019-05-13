import java.awt.Color;
import java.awt.Point;
import java.util.LinkedList;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;
import java.util.Random;

public class Snake implements ActionListener, KeyListener{
    Draw _draw;
    public LinkedList<GameElement> snakeBody = new LinkedList<GameElement>();
    GameElement _head = new GameElement(Color.BLACK);
    GameElement _bodyPart = new GameElement(Color.RED);
    GameElement _food = new GameElement(Color.ORANGE);
    JFrame _frame = new JFrame("Snake");
    Timer _timer = new Timer(20, this);
    Random _random;


    //length of the snake, default 1 => head
    private int _snakeLength = 1;
    
    //counter, movementspeed of the snake
    private int _millis = 0;

    int _fWidth;
    int _fHeight;
    
    // 0 => DOWN
    // 1 => RIGHT
    // 2 => UP
    // 3 => LEFT
    private int _direction = 0;

    //scale of the snake
    public int _scale = 10;

    public Snake(){
        _random = new Random();
        _draw = new Draw();

        _frame.setContentPane(_draw);
        _frame.setSize(700, 700);
        _frame.setLocationRelativeTo(null);
        _frame.setVisible(true);
        _frame.setResizable(false);
        _frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        _frame.addKeyListener(this);

        _fWidth = _frame.getBounds().width / 10;
        _fHeight = _frame.getBounds().height / 10;

        _head.create(0, 0);
        _food.create(_random.nextInt(_fWidth), _random.nextInt(_fHeight));
        System.out.println(_food.getPosition());

        snakeBody.add(_head);

        _snakeLength++;
        _millis = 0;
        _timer.start();
    }

    
    public void Move(int pDirection){
        if (collision()) {
            System.out.println("ATE FOOD");
            /*
            _bodyPart.create(_head._position.x, _head._position.y);
            snakeBody.add(_bodyPart);

            _food.create(_random.nextInt(_fWidth), _random.nextInt(_fHeight));
*/
            _snakeLength++;
            System.out.println(_snakeLength + " " + snakeBody.size());
        }
        
        if (snakeBody.size() > _snakeLength - 1) {
            snakeBody.removeLast();
        }

        _draw.repaint();
        _millis++;

        // defines the movementspeed of the snake as does the timer
        // the frame updates every 2 milliseconds
        if (_millis % 2 == 0 && _head != null) {
            snakeBody.add(_head);
            System.out.println(_head.getPosition());

            if (_direction == 0) {
                // DOWN
                updatePosition(1, 'y');
                // If the snakes exits the window border
                if (_head._position.y >= _fHeight) {
                    _head._position.y = 0;   
                }

            }else if (_direction == 1) {
                // RIGHT
                updatePosition(1, 'x');
                
                if (_head._position.x >= _fWidth) {
                    _head._position.x = 0;                    
                }
            }else if (_direction == 2){
                // UP
                updatePosition(-1, 'y');
                
                if (_head._position.y <= 0) {
                    _head._position.y = 0;                    
                }

            }else if (_direction == 3){
                // LEFT
                updatePosition(-1, 'x');
                
                if (_head._position.x <= 0) {
                    _head._position.x = 0;                    
                }
            }
            _head._position = CreatePosition(_head._position.x, _head._position.y);
        }
    }

    public boolean collision(){
        if (_head.getPosition().equals(_food.getPosition())) {
            return true;
        }

        return false;
    }

    // 1 or -1 && x or y
    public void updatePosition(int pAmount, char pC){
        for (GameElement body : snakeBody) {
            if (pC == 'x') {
                body._position.x += pAmount;
            }
            else{
                body._position.y += pAmount;
            }
        }
    }

    public Point CreatePosition(int pX, int pY){
        Point newPos;
        newPos = _head.create(pX, pY);

        return newPos;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Move(_direction);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        if (keyCode == KeyEvent.VK_LEFT && _direction != 3)
		{
			_direction = 3;
		}
		else if (keyCode == KeyEvent.VK_RIGHT && _direction != 1)
		{
			_direction = 1;
		}
		else if (keyCode == KeyEvent.VK_UP && _direction != 2)
		{
            _direction = 2;
        }
		else if (keyCode == KeyEvent.VK_DOWN && _direction != 0)
		{
            _direction = 0;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }
}
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
    Bodypart _bodyPart;
    Bodypart _head = new Head(null);
    GameElement _food = new Food();
    JFrame _frame = new JFrame("Snake");

    Timer _timer = new Timer(50, this);
    Random _random;
    Draw _draw;

    //the height and width of the frame
    int _fWidth;
    int _fHeight;

    // Counter to keep track of the score
    public int _score = 0;

    // 0 => DOWN
    // 1 => RIGHT
    // 2 => UP
    // 3 => LEFT
    private int _direction = 0;

    //scale of the snake
    public int _scale = 10;

    public boolean _dead = false;
    private boolean _move = true;
    private boolean _addPart = false;

    public Snake(){
        System.out.println(_food);
        _random = new Random();
        _draw = new Draw();

        _frame.setContentPane(_draw);
        _frame.setSize(700, 700);
        _frame.setLocationRelativeTo(null);
        _frame.setVisible(true);
        _frame.setResizable(false);
        _frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        _frame.addKeyListener(this);

        _fWidth = (_frame.getBounds().width) / 10;
        _fHeight = (_frame.getBounds().height) / 10;

       startGame();
    }

    public void startGame(){
        _head.create(_fWidth / 2, _fHeight / 2 - 20);
        _food._position = _food.create(_head);
        _head.delete(_head);

        _dead = false;
        _score = 0;
        _move = true;
        _direction = 0;
        _timer.start();
    }

    
    public void Move(int pDirection){
        _draw.repaint();

        if (!_dead) {
            if (_direction == 0) {
                // DOWN
                updateHead(0, 1);

            } else if (_direction == 1) {
                // RIGHT
                updateHead(1, 0);

            } else if (_direction == 2) {
                // UP
                updateHead(0, -1);

            } else if (_direction == 3) {
                // LEFT
                updateHead(-1, 0);
            }

            if (ateFood()) {
                _score++;
                _food.create(_random.nextInt(_fWidth - 10), _random.nextInt(_fHeight - 10));
                _addPart = true;
            }
        }
    }

    private void updateHead(int pX, int pY){
        if (!_head.collision(_head, pX, pY)) {
            if (_head._position.x < 0 
                    || _head._position.y < 0 
                        || _head._position.x > _fWidth 
                            || _head._position.y > _fHeight) {
                                System.out.println("Out of frame");
                                _dead = true;
                            }
                            else{
                                _head._position = CreatePosition(_head._position.x + pX, _head._position.y + pY);
                                if (_addPart) {
                                    _head.addBodyPart(_head, pX, pY);
                                    _addPart = false;
                                }
                                updateSnake(pX, pY);
                                _move = true;
                            }
        }
        else{
            _dead = true;
            System.out.println(_dead);
        }
    }

    private void updateSnake(int pX, int pY) {
        _head.update(_head, pX, pY);
        _head._endReached = false;
    }

    public boolean ateFood(){
        if (_head._position.equals(_food._position)) {
            return true;
        }    
        return false;
    }

    public Point CreatePosition(int pX, int pY){
        return _head.create(pX, pY);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Move(_direction);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        if (keyCode == KeyEvent.VK_LEFT && _direction != 1 && _move)
		{
            _move = false;
			_direction = 3;
		}
		else if (keyCode == KeyEvent.VK_RIGHT && _direction != 3 && _move)
		{
            _move = false;
			_direction = 1;
		}
		else if (keyCode == KeyEvent.VK_UP && _direction != 0 && _move)
		{
            _move = false;
            _direction = 2;
        }
		else if (keyCode == KeyEvent.VK_DOWN && _direction != 2 && _move)
		{
            _move = false;
            _direction = 0;
        }
        else if (keyCode == KeyEvent.VK_SPACE) {
            startGame();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }
}
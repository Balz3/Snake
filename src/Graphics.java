import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Graphics extends JPanel implements ActionListener {
    private Timer timer = new Timer(100, this);
    public enum SState {START, PLAY, END};

    public SState screenState;
    private Snake snake;
    private Food food;
    private Game game;

    public Graphics(Game game) {
        timer.start();
        screenState = SState.START;

        this.game = game;
        snake = game.getPlayer();
        food = game.getFood();

        this.addKeyListener(game);
        this.setFocusable(true);
        this.setFocusTraversalKeysEnabled(false);
    }

    public void paintComponent(java.awt.Graphics graphics){
        super.paintComponent(graphics);

        Graphics2D graphics2D = (Graphics2D) graphics;

        graphics2D.setColor(Color.BLACK);
        graphics2D.fillRect(0, 0, Game.width * Game.dimension, Game.height * Game.dimension);

        if(screenState == SState.START){
            graphics2D.setColor(Color.WHITE);
            graphics2D.drawString("Press Any Key to Start!", Game.width/2 * Game.dimension - 40, Game.height/2 * Game.dimension - 20);

        } else if(screenState == SState.PLAY){
            graphics2D.setColor(Color.RED);
            graphics2D.fillRect(food.getX() * Game.dimension, food.getY() * Game.dimension, Game.dimension, Game.dimension);

            graphics2D.setColor(Color.GREEN);

            for(Rectangle rectangle: snake.getBody()){
                graphics2D.fill(rectangle);
            }
        } else if(screenState == SState.END){
            graphics2D.setColor(Color.WHITE);
            graphics2D.drawString("Your Score: " + (snake.getBody().size() - 3), Game.width/2 * Game.dimension - 40, Game.height/2 * Game.dimension - 20);
        }

    }

    @Override
    public void actionPerformed(ActionEvent event) {
        repaint();

        game.manageGame();
    }
}

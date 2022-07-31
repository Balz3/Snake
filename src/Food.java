import java.awt.*;

public class Food {
    private int x, y;

    public Food(Snake snake) {
        randomSpawn(snake);

    }

    public void randomSpawn(Snake snake){
        boolean onSnake = true;
        while(onSnake){
            onSnake = false;
            x = (int) (Math.random() * Game.width);
            y = (int) (Math.random() * Game.height);

            for(Rectangle r: snake.getBody()){
                if(r.getX() == x && r.getY() == y){
                    onSnake = true;
                }
            }
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}

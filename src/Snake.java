import java.awt.*;
import java.util.ArrayList;

public class Snake {
    private ArrayList<Rectangle> body;
    public enum Direction {NOTHING, UP, DOWN, LEFT, RIGHT};
    Direction direction;

    public Snake() {
        body = new ArrayList<>();

        Rectangle tempRectangle1 = new Rectangle(Game.dimension, Game.dimension);
        tempRectangle1.setLocation((Game.height / 2) * Game.dimension, (Game.width / 2) * Game.dimension);
        Rectangle tempRectangle2 = new Rectangle(Game.dimension, Game.dimension);
        tempRectangle2.setLocation((Game.height / 2 - 1) * Game.dimension, (Game.width / 2) * Game.dimension);
        Rectangle tempRectangle3 = new Rectangle(Game.dimension, Game.dimension);
        tempRectangle3.setLocation((Game.height / 2 - 2) * Game.dimension, (Game.width / 2) * Game.dimension);

        body.add(tempRectangle1);
        body.add(tempRectangle2);
        body.add(tempRectangle3);

        direction = Direction.NOTHING;
    }

    public ArrayList<Rectangle> getBody() {
        return body;
    }

    public void setBody(ArrayList<Rectangle> body) {
        this.body = body;
    }

    public void setDirection(Direction direction){
        this.direction = direction;
        return;
    }

    public Direction getDirection(){
        return direction;
    }

    public void move() {
        if(direction != Direction.NOTHING){
            Rectangle rectangle = new Rectangle(Game.dimension, Game.dimension);
            Rectangle snakeHead = body.get(0);

            if(direction == Direction.UP){
                rectangle.setLocation(snakeHead.x, snakeHead.y - Game.dimension);
            } else if(direction == Direction.LEFT){
                rectangle.setLocation(snakeHead.x - Game.dimension, snakeHead.y);
            } else if(direction == Direction.DOWN){
                rectangle.setLocation(snakeHead.x, snakeHead.y + Game.dimension);
            } else if(direction == Direction.RIGHT){
                rectangle.setLocation(snakeHead.x + Game.dimension, snakeHead.y);
            }

            body.add(0, rectangle);
            body.remove(body.size() - 1);
        }
    }

    public void grow() {
        Rectangle rectangle = new Rectangle(Game.dimension, Game.dimension);
        Rectangle snakeHead = body.get(0);

        if(direction == Direction.UP){
            rectangle.setLocation(snakeHead.x, snakeHead.y - Game.dimension);
        } else if(direction == Direction.LEFT){
            rectangle.setLocation(snakeHead.x - Game.dimension, snakeHead.y);
        } else if(direction == Direction.DOWN){
            rectangle.setLocation(snakeHead.x, snakeHead.y + Game.dimension);
        } else if(direction == Direction.RIGHT){
            rectangle.setLocation(snakeHead.x + Game.dimension, snakeHead.y);
        }

        body.add(0, rectangle);
    }

    public int getX() {
        return body.get(0).x;
    }

    public int getY() {
        return body.get(0).y;
    }
}

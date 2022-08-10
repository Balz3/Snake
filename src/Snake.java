import java.awt.*;
import java.util.ArrayList;

public class Snake {
    private ArrayList<Rectangle> body;
    public enum Direction {UP, DOWN, LEFT, RIGHT};
    Direction direction;

    public Snake() {
        body = new ArrayList<>();

        Rectangle tempBody1 = new Rectangle(Game.dimension, Game.dimension);
        tempBody1.setLocation((Game.height / 2) * Game.dimension, (Game.width / 2) * Game.dimension);
        Rectangle tempBody2 = new Rectangle(Game.dimension, Game.dimension);
        tempBody2.setLocation((Game.height / 2 - 1) * Game.dimension, (Game.width / 2) * Game.dimension);
        Rectangle tempBody3 = new Rectangle(Game.dimension, Game.dimension);
        tempBody3.setLocation((Game.height / 2 - 2) * Game.dimension, (Game.width / 2) * Game.dimension);

        body.add(tempBody1);
        body.add(tempBody2);
        body.add(tempBody3);

        direction = null;
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
        if(direction != null){
            Rectangle newBody = new Rectangle(Game.dimension, Game.dimension);
            Rectangle snakeHead = body.get(0);

            if(direction == Direction.UP){
                newBody.setLocation(snakeHead.x, snakeHead.y - Game.dimension);
            } else if(direction == Direction.LEFT){
                newBody.setLocation(snakeHead.x - Game.dimension, snakeHead.y);
            } else if(direction == Direction.DOWN){
                newBody.setLocation(snakeHead.x, snakeHead.y + Game.dimension);
            } else if(direction == Direction.RIGHT){
                newBody.setLocation(snakeHead.x + Game.dimension, snakeHead.y);
            }

            body.add(0, newBody);
            body.remove(body.size() - 1);
        }
    }

    public void grow() {
        Rectangle newBody = new Rectangle(Game.dimension, Game.dimension);
        Rectangle snakeHead = body.get(0);

        if(direction == Direction.UP){
            newBody.setLocation(snakeHead.x, snakeHead.y - Game.dimension);
        } else if(direction == Direction.LEFT){
            newBody.setLocation(snakeHead.x - Game.dimension, snakeHead.y);
        } else if(direction == Direction.DOWN){
            newBody.setLocation(snakeHead.x, snakeHead.y + Game.dimension);
        } else if(direction == Direction.RIGHT){
            newBody.setLocation(snakeHead.x + Game.dimension, snakeHead.y);
        }

        body.add(0, newBody);
    }

    public int getX() {
        return body.get(0).x;
    }

    public int getY() {
        return body.get(0).y;
    }
}

package com.uoc.robot;

import com.uoc.utils.Coordinates;

public class Robot {

    private Coordinates position;
    private Direction direction;

    public Robot(Coordinates position, Direction direction){
        this.position = position;
        this.direction = direction;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Coordinates getPosition() {
        return position;
    }

    public void setPosition(Coordinates position) {
        this.position = position;
    }

    public void moveRight(){
        position.setX(position.getX() + 1);
    }

    public void moveLeft(){
        position.setX(position.getX() - 1);
    }

    public void moveUp(){
        position.setY(position.getY() + 1);
    }

    public void moveDown(){
        position.setY(position.getY() - 1);
    }

    @Override
    public String toString() {
        return position.getX() + " " + position.getY() + " " + direction;
    }
}

package com.uoc.robot;

import com.uoc.utils.Coordinates;
import com.uoc.planet.Planet;

public class RobotManager {

    private Robot robot;
    private Planet planet;

    public RobotManager(Planet planet){
        this.planet = planet;
    }

    public void setRobot(Robot robot) {
        this.robot = robot;
    }

    public Robot getRobot() {
        return robot;
    }

    public void processOrders(String orders){
        orders = orders.toUpperCase();
        for(int i = 0; i < orders.length(); i++) {
          processOrder(orders.charAt(i));
        }
    }

    private void processOrder(char order){
        switch (order){
            case 'L':
                turnLeft();
                break;
            case 'R':
                turnRight();
                break;
            case 'M':
                move();
                break;
            default:
                break;
        }
    }

    private void turnLeft(){
        switch (robot.getDirection()){
            case N:
                robot.setDirection(Direction.W);
                break;
            case E:
                robot.setDirection(Direction.N);
                break;
            case S:
                robot.setDirection(Direction.E);
                break;
            case W:
                robot.setDirection(Direction.S);
                break;
            default:
                break;
        }
    }

    private void turnRight(){
        switch (robot.getDirection()){
            case N:
                robot.setDirection(Direction.E);
                break;
            case E:
                robot.setDirection(Direction.S);
                break;
            case S:
                robot.setDirection(Direction.W);
                break;
            case W:
                robot.setDirection(Direction.N);
                break;
            default:
                break;
        }
    }

    private void move(){
        Coordinates planetCoordinates = planet.getFinalCoordinates();
        Coordinates robotCoordinates = robot.getPosition();
        switch (robot.getDirection()){
            case N:
                if(robotCoordinates.getY() >= 0 && robotCoordinates.getY() < planetCoordinates.getY())
                    robot.moveUp();
                break;
            case E:
                if(robotCoordinates.getX() >= 0 && robotCoordinates.getX() < planetCoordinates.getX())
                    robot.moveRight();
                break;
            case S:
                if(robot.getPosition().getY() > 0)
                    robot.moveDown();
                break;
            case W:
                if(robot.getPosition().getX() > 0 )
                    robot.moveLeft();
                break;
            default:
                break;
        }
    }

}

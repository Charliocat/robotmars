package com.uoc.planet;

import com.uoc.robot.Robot;
import com.uoc.utils.Coordinates;

import java.util.ArrayList;
import java.util.List;

public class Planet {

    private Coordinates finalCoordinates;
    private List<Robot> robots;

    public Planet(Coordinates coordinates){
        finalCoordinates = coordinates;
    }

    public Coordinates getFinalCoordinates() {
        return finalCoordinates;
    }

    public void addRobot(Robot robotToAdd){
        if (robots == null){
            robots = new ArrayList<Robot>();
            robots.add(robotToAdd);
        } else {
            for(Robot robot: robots){
                if (robot.getPosition().equals(robotToAdd.getPosition()))
                    throw new RuntimeException("Robot position is occupied");
            }
            robots.add(robotToAdd);
        }
    }

}

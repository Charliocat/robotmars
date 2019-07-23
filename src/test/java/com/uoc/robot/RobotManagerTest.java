package com.uoc.robot;

import com.uoc.planet.Planet;
import com.uoc.utils.Coordinates;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

class RobotManagerTest {

    @Test
    void processOrders() {
        Planet planet = new Planet(new Coordinates(5, 5));
        RobotManager manager = new RobotManager(planet);
        manager.setRobot(new Robot(new Coordinates(1,2), Direction.N));
        manager.processOrders("LMLMLMLMM");

        assertThat(manager.getRobot().getPosition().getX(), equalTo(1));
        assertThat(manager.getRobot().getPosition().getY(), equalTo(3));
        assertThat(manager.getRobot().getDirection(), equalTo(Direction.N));
    }

    @Test
    void processOrders2() {
        Planet planet = new Planet(new Coordinates(5, 5));
        RobotManager manager = new RobotManager(planet);
        manager.setRobot(new Robot(new Coordinates(1,2), Direction.N));
        manager.processOrders("LMLMRRMRML");

        assertThat(manager.getRobot().getPosition().getX(), equalTo(1));
        assertThat(manager.getRobot().getPosition().getY(), equalTo(2));
        assertThat(manager.getRobot().getDirection(), equalTo(Direction.N));
    }
}
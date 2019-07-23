import com.uoc.utils.Coordinates;
import com.uoc.robot.Direction;
import com.uoc.planet.Planet;
import com.uoc.robot.Robot;
import com.uoc.robot.RobotManager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Main {

    public static void main(String[] args) throws Exception{
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        File file = new File(classloader.getResource("test.txt").getFile());
        BufferedReader br = new BufferedReader(new FileReader(file));

        Planet planet = new Planet(parsePlanetLine(br.readLine()));
        RobotManager manager = new RobotManager(planet);

        String line;
        while ((line = br.readLine()) != null){
            if (line.contains(" ")){
                manager.setRobot(parseRobotLine(line));
            }
            else {
                manager.processOrders(line);
                System.out.println(manager.getRobot().toString());
            }
        }

    }

    private static Coordinates parsePlanetLine(String planetLine) {
        String[] strArray = planetLine.split("\\s");
        return new Coordinates(Integer.parseInt(strArray[0]), Integer.parseInt(strArray[1]));
    }

    private static Robot parseRobotLine(String robotLine){
       String[] strArray = robotLine.split("\\s+");
       return new Robot(new Coordinates(Integer.parseInt(strArray[0]), Integer.parseInt(strArray[1])), Direction.valueOf(strArray[2]));
    }

}

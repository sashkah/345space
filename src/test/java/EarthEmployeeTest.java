import edu.ithaca.dragon.util.JsonUtil;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.awt.desktop.SystemSleepEvent;
import java.io.IOException;


public class EarthEmployeeTest {


    @Test
    void blockResourceTest()throws IOException {
        SpaceStation spaceStation= ReadFromFile.createSpaceStation("src/main/resources/SpaceShip.txt");

        EarthStation earthStation=new EarthStation();
        earthStation.setManagedStation(spaceStation);
        EarthEmployee earthEmployee=new EarthEmployee("employeeTest1",earthStation);

        Assert.assertEquals("Water was blocked for usage.",earthEmployee.blockResource("Water"));
        Assert.assertEquals("water",earthEmployee.getBlockedResources().get(0).getName());
        Assert.assertEquals(1,earthEmployee.getBlockedResources().size());
        Assert.assertEquals(2,spaceStation.getResources().size());
        Assert.assertEquals(2, earthEmployee.getEarthStation().getManagedStation().getResources().size());
    }

    @Test
    void sendResourcesTest() throws IOException, InterruptedException {
        SpaceStation spaceStation= ReadFromFile.createSpaceStation("src/main/resources/SpaceShip.txt");

        EarthStation earthStation=new EarthStation();
        earthStation.setManagedStation(spaceStation);
        Environment environment=new Environment(spaceStation,earthStation);
        EarthEmployee earthEmployee=new EarthEmployee("employeeTest1",earthStation);

        environment.runLoop(5,250,true);

        System.out.println(spaceStation.getResources().get(0).getName());//0-oxygen 1-food 2-water



    }
//    @Test
//    void unBlockResourceTest() throws IOException{
//        SpaceStation spaceStation= ReadFromFile.createSpaceStation("src/test/testResources/test4.txt");
//
//        EarthStation earthStation=new EarthStation();
//        earthStation.setManagedStation(spaceStation);
//        EarthEmployee earthEmployee=new EarthEmployee("employeeTest1",earthStation);
//        earthEmployee.blockResource("Water");
//        Assert.assertEquals(earthEmployee.getBlockedResources().get(0).getName(),"Water");
//        Assert.assertEquals(1,spaceStation.getResources().size());
//        Assert.assertEquals(1,earthEmployee.getBlockedResources().size());
//        Assert.assertEquals(1, earthEmployee.getEarthStation().getManagedStation().getResources().size());
//        earthEmployee.unBlockResource("Water", 100.0);
//        Assert.assertEquals(2,spaceStation.getResources().size());
//        Assert.assertEquals(0,earthEmployee.getBlockedResources().size());
//        Assert.assertEquals(2, earthEmployee.getEarthStation().getManagedStation().getResources().size());
//
//    }
}

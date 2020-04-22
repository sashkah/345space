import edu.ithaca.dragon.util.JsonUtil;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.io.IOException;


public class EarthEmployeeTest {


    @Test
    void blockResourceTest()throws IOException {
        SpaceStation spaceStation= ReadFromFile.createSpaceStation("src/test/testResources/test4.txt");

        EarthStation earthStation=new EarthStation();
        earthStation.setManagedStation(spaceStation);
        EarthEmployee earthEmployee=new EarthEmployee("employeeTest1",earthStation);
        earthEmployee.blockResource("Water");
        Assert.assertEquals(earthEmployee.getBlockedResources().get(0).getName(),"Water");
        Assert.assertEquals(1,spaceStation.getResources().size());
        Assert.assertEquals(1,earthEmployee.getBlockedResources().size());
        Assert.assertEquals(1, earthEmployee.getEarthStation().getManagedStation().getResources().size());
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

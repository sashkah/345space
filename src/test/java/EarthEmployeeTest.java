import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;


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
        ArrayList<Resource> resources=earthEmployee.getEarthStation().getManagedStation().getResources();
        environment.runLoop(5,250,false);

        double oxygenAfterDepletion= resources.get(0).getAmount();
        double foodAfterDepletion= resources.get(1).getAmount();
        double waterAfterDepletion= resources.get(2).getAmount();

        earthEmployee.sendResource("oxygen",20);
        Assert.assertEquals((oxygenAfterDepletion + 20), resources.get(0).getAmount(), 0.0);
        earthEmployee.sendResource("oxygen",9);
        Assert.assertEquals( "Amount should be 10 or greater",earthEmployee.sendResource("oxygen",9));

        Assert.assertEquals((oxygenAfterDepletion + 20), resources.get(0).getAmount(), 0.0);
        earthEmployee.sendResource("oxygen",-1.2);
        Assert.assertEquals((oxygenAfterDepletion + 20), resources.get(0).getAmount(), 0.0);
        earthEmployee.sendResource("oxygen",0);
        Assert.assertEquals((oxygenAfterDepletion + 20), resources.get(0).getAmount(), 0.0);
        earthEmployee.sendResource("oxygen",100);
        Assert.assertEquals((oxygenAfterDepletion + 120), resources.get(0).getAmount(), 0.0);

        earthEmployee.sendResource("food",20);
        Assert.assertEquals((foodAfterDepletion + 20), resources.get(1).getAmount(), 0.0);

        earthEmployee.sendResource("water",10);
        Assert.assertEquals((waterAfterDepletion + 10), resources.get(2).getAmount(), 0.0);

        Assert.assertEquals(3, resources.size());
        Assert.assertEquals( "Resource not found",earthEmployee.sendResource("w",10));
        Assert.assertEquals(3, resources.size());

    }

    @Test
    void restrictResource()throws IOException,InterruptedException{
        SpaceStation spaceStation= ReadFromFile.createSpaceStation("src/main/resources/SpaceShip.txt");

        EarthStation earthStation=new EarthStation();
        earthStation.setManagedStation(spaceStation);
        Environment environment=new Environment(spaceStation,earthStation);
        EarthEmployee earthEmployee=new EarthEmployee("employeeTest1",earthStation);
        ArrayList<Resource> resources=earthEmployee.getEarthStation().getManagedStation().getResources();
        ArrayList<Appliance> appliances=earthEmployee.getEarthStation().getManagedStation().getRooms().get(0).getAppliances();
        ArrayList<Astronaut> astronauts= earthEmployee.getEarthStation().getManagedStation().getAstronauts();
        astronauts.get(0).useAppliance(appliances.get(0));

        Assert.assertTrue(astronauts.get(0).getCurrentAppliance().getInUse());
        earthEmployee.restrictUserFromCurrentAppliance(astronauts.get(0).getId());
        Assert.assertEquals(false,astronauts.get(0).getCurrentAppliance().getInUse());

    }
}

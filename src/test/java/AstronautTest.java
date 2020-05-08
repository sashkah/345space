import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

public class AstronautTest {
    @Test
    void checkApplianceBlockTest() throws IOException, InterruptedException {
        SpaceStation spaceStation= ReadFromFile.createSpaceStation("src/main/resources/SpaceShip.txt");

        EarthStation earthStation=new EarthStation();
        earthStation.setManagedStation(spaceStation);
        Environment environment=new Environment(spaceStation,earthStation);
        EarthEmployee earthEmployee=new EarthEmployee("employeeTest1",earthStation);
        ArrayList<Resource> resources=earthEmployee.getEarthStation().getManagedStation().getResources();
        ArrayList<Resource> resources2=new ArrayList<>();
        resources2.add(resources.get(0));
        resources2.add(resources.get(1));
        Astronaut astronaut=spaceStation.getAstronauts().get(0);
        Astronaut astronaut1=spaceStation.getAstronauts().get(1);
        astronaut.setCannotUse(resources2);

        astronaut.setCurrentAppliance(spaceStation.getRooms().get(0).getAppliances().get(0));
        astronaut1.setCurrentAppliance(spaceStation.getRooms().get(0).getAppliances().get(0));

        Appliance appliance=spaceStation.getRooms().get(0).getAppliances().get(1);
        Assert.assertTrue(astronaut.checkIfBlockedAppliance(appliance));
        Assert.assertFalse(astronaut1.checkIfBlockedAppliance(appliance));


    }
}

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
public class ApplianceTest {

    @Test
    void usingResourceTest() throws IOException, InterruptedException {
        SpaceStation spaceStation= ReadFromFile.createSpaceStation("src/main/resources/SpaceShip.txt");

        ArrayList<Appliance> appliances= spaceStation.getRooms().get(0).getAppliances();
        EarthStation earthStation=new EarthStation();
        earthStation.setManagedStation(spaceStation);
        Environment environment=new Environment(spaceStation,earthStation);
        EarthEmployee earthEmployee=new EarthEmployee("employeeTest1",earthStation);
        ArrayList<Resource> resources=earthEmployee.getEarthStation().getManagedStation().getResources();
        environment.runLoop(5,250,false, 6);


    }
}

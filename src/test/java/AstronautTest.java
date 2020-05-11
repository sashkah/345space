import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

public class AstronautTest {


    @Test
    void checkNearLimit() throws IOException {
        SpaceStation spaceStation= ReadFromFile.createSpaceStation("src/main/resources/SpaceShip.txt");EarthStation earthStation=new EarthStation();
        earthStation.setManagedStation(spaceStation);
        ArrayList<Astronaut> astronauts= spaceStation.getAstronauts();

        ArrayList<Appliance> applianceAppliance=new ArrayList<>();
        for(Room room:spaceStation.getRooms()){
            applianceAppliance.addAll(room.getAppliances());
        }
        Assert.assertFalse(astronauts.get(0).checkIfNearLimit(applianceAppliance.get(0)));


        astronauts.get(0).getResourceLimits().get(1).setLimit(10);
        astronauts.get(0).getTotalResourceUsages().get(1).setTotalDailyUsage(12);
        Assert.assertTrue(astronauts.get(0).checkIfNearLimit(applianceAppliance.get(0)));

        astronauts.get(0).useAppliance(applianceAppliance.get(0));




    }
}
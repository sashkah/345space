import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
public class ApplianceTest {

    @Test
    void usingResourceTest() throws IOException, InterruptedException {
        SpaceStation spaceStation= ReadFromFile.createSpaceStation("src/main/resources/SpaceShip.txt");

        ArrayList<Appliance> appliances= spaceStation.getRooms().get(0).getAppliances();
        for(Room room:spaceStation.getRooms()){
            appliances.addAll(room.getAppliances());
        }
        EarthStation earthStation=new EarthStation();
        earthStation.setManagedStation(spaceStation);
        Environment environment=new Environment(spaceStation,earthStation);
        environment.runLoop(6,25,true, 10);
        //astronauts.get(0).getResourceLimits().get(1).setLimit(10);
        for(Appliance appliance:appliances)
            System.out.println(appliance.getTotalResourceUsages());

    }
}

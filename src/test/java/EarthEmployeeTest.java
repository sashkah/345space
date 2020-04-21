import edu.ithaca.dragon.util.JsonUtil;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class EarthEmployeeTest {


    @Test
    void blockResourceTest()throws IOException {
        SpaceStation spaceStation= ReadFromFile.createSpaceStation("src/main/resources/test.txt");
        ArrayList<User> users=spaceStation.getUsers();

        EarthStation earthStation=new EarthStation();
        earthStation.setManagedStation(spaceStation);
        EarthEmployee earthEmployee=new EarthEmployee("ds",earthStation);
        earthEmployee.blockResource("water");
    }
}

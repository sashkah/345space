import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class EarthStationTest {

    @Test
    void addEmployeeTest() {
        SpaceStation nullStation = null;
        EarthStation myStation = new EarthStation(nullStation, new ArrayList<EarthEmployee>());
        Assert.assertEquals(0, myStation.getEmployees().size());
        myStation.addEmployee(new EarthEmployee());
        Assert.assertEquals(1, myStation.getEmployees().size());
    }
}

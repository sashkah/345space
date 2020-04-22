import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class baseClassesTest {

    @Test
    void SpaceStationTest(){
        SpaceStation myStation = new SpaceStation();
        Astronaut myAstronaut = new Astronaut("123", null, null, null);
        Resource cashMoney = new Resource("Cash Money", 100.15);

        myStation.addAstronaut(myAstronaut);

        Assert.assertTrue(myStation.getAstronauts().contains(myAstronaut));

        myStation.addResource(cashMoney);

        Assert.assertTrue(myStation.getResources().size() == 1);
        Assert.assertTrue(myStation.getResources().contains(cashMoney));

        myStation.addResource("Cash Money", 50);

        Assert.assertTrue(myStation.getResources().get(0).getAmount() == 150.15);

        myStation.addResource(cashMoney);

        Assert.assertFalse(myStation.getResources().size() == 2);

        //getRandAstronaut test
        Astronaut myAstronaut2 = new Astronaut("456", null, null, null);
        Astronaut myAstronaut3 = new Astronaut("789", null, null, null);
        myStation.addAstronaut(myAstronaut2);
        myStation.addAstronaut(myAstronaut3);
        Astronaut tempAstronaut = myStation.selectRandAstronaut();
        Assert.assertTrue(myStation.getAstronauts().contains(tempAstronaut));

        //getRandRoom test
        Room room1 = new Room("room1", 100, "bathroom", null, null, null);
        Room room2 = new Room("room2", 100, "kitchen", null, null, null);
        Room room3 = new Room("room3", 100, "gym", null, null, null);
        myStation.addRoom(room1);
        myStation.addRoom(room2);
        myStation.addRoom(room3);
        Room tempRoom = myStation.selectRandRoom();
        Assert.assertTrue(myStation.getRooms().contains(tempRoom));

    }

    @Test
    void ResourceTest(){
        Resource myResource = new Resource("resource", 10);
        myResource.addAmount(10);

        Assert.assertTrue(myResource.getAmount() == 20);

        myResource.setAmount(50);

        Assert.assertTrue(myResource.getAmount() == 50);
    }

    @Test
    void RoomTest() {
        //getRandAppliance test
        Appliance app1 = new Appliance("app1", null, null);
        Appliance app2 = new Appliance("app2", null, null);
        Appliance app3 = new Appliance("app3", null, null);
        ArrayList<Appliance> apps = new ArrayList<Appliance>();
        apps.add(app1);
        apps.add(app2);
        apps.add(app3);
        Room room = new Room("room", 100, "room", null, apps, null);
        Appliance tempApp = room.selectRandAppliance();
        Assert.assertTrue(room.getAppliances().contains(tempApp));
    }

}

import edu.ithaca.dragon.util.JsonUtil;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class ReadFromFileTest {

    @Test
    void getContentsTest() throws FileNotFoundException {
        File fileIn = new File("src/main/resources/test2.txt");
        String fileString = ReadFromFile.getContents(fileIn);
        //System.out.println(fileString);
        String expectedString = "{" + "  \"users\" : [ {" + "    \"id\" : \"aidan\"," + "    \"resourceUsage\" : null" + "  }, {" + "    \"id\" : \"jolie\"," + "    \"resourceUsage\" : null" + "  } ]," + "  \"resources\" : [ {" + "    \"name\" : \"food\"," + "    \"amount\" : 100.0" + "  }, {" + "    \"name\" : \"water\"," + "    \"amount\" : 100.0" + "  } ]" + "}";
        assertEquals(expectedString, fileString);
    }

    @Test
    void createSpaceStationTest() throws IOException {
        //String expectedUsers = "[aidan [resourceName: oxygen usagePTF: 5.0 timeframe: 1, resourceName: food usagePTF: 3.0 timeframe: 4, resourceName: water usagePTF: 4.0 timeframe: 2], damion [resourceName: oxygen usagePTF: 5.0 timeframe: 1, resourceName: food usagePTF: 3.0 timeframe: 4, resourceName: water usagePTF: 4.0 timeframe: 2], jolie [resourceName: oxygen usagePTF: 5.0 timeframe: 1, resourceName: food usagePTF: 3.0 timeframe: 4, resourceName: water usagePTF: 4.0 timeframe: 2]]";
        String expectedAstronauts = "[aidan [resourceName: oxygen usagePTF: 5.0 timeframe: 1, resourceName: food usagePTF: 3.0 timeframe: 4, resourceName: water usagePTF: 4.0 timeframe: 2], damion [resourceName: oxygen usagePTF: 5.0 timeframe: 1, resourceName: food usagePTF: 3.0 timeframe: 4, resourceName: water usagePTF: 4.0 timeframe: 2], jolie [resourceName: oxygen usagePTF: 5.0 timeframe: 1, resourceName: food usagePTF: 3.0 timeframe: 4, resourceName: water usagePTF: 4.0 timeframe: 2]]";
        String expectedResources = "[oxygen 100.0, food 100.0, water 100.0]";
        SpaceStation spaceStation;
        spaceStation = ReadFromFile.createSpaceStation("src/main/resources/test.txt");
        assertEquals(expectedAstronauts, spaceStation.getAstronauts().toString());
        assertEquals(expectedResources, spaceStation.getResources().toString());
    }

    @Test
    void tempTest() throws IOException {
        //User user1 = new User("aidan");
        //User user2 = new User("jolie");
        Astronaut astronaut1  = new Astronaut("jolie", null, null, null);
        Astronaut astronaut2 = new Astronaut("aidan", null, null, null);
        Resource res1 = new Resource("food", 100);
        Resource res2 = new Resource("water", 100);
        Room room1 = new Room("kitchen 1", 100, "kitchen", null, null, null);
        Room room2 = new Room("bathroom 1", 50, "bathroom", null, null, null);
        //ArrayList<User> users = new ArrayList<User>();
        ArrayList<Astronaut> astronauts = new ArrayList<Astronaut>();
        //users.add(user1);
        //users.add(user2);
        astronauts.add(astronaut1);
        astronauts.add(astronaut2);
        ArrayList<Resource> resources = new ArrayList<Resource>();
        resources.add(res1);
        resources.add(res2);
        ArrayList<Room> rooms = new ArrayList<Room>();
        rooms.add(room1);
        rooms.add(room2);
        //SpaceStation station = new SpaceStation(users, resources);
        SpaceStation station = new SpaceStation(astronauts, resources, rooms);

        JsonUtil.toJsonFile("outFileUpdated", station);
    }

    @Test
    void tempTest2() throws IOException {
        SpaceStation myStation = new SpaceStation();

        ArrayList<ResourceUsage> resourceUsages = new ArrayList<ResourceUsage>();
        resourceUsages.add(new ResourceUsage("oxygen", 5, 1));
        resourceUsages.add(new ResourceUsage("food", 3, 4));
        resourceUsages.add(new ResourceUsage("water", 4, 2));

        Astronaut myAstronaut = new Astronaut("aidan", resourceUsages, null, null);
        Astronaut myAstronaut2 = new Astronaut("damion", resourceUsages, null, null);
        Astronaut myAstronaut3 = new Astronaut("jolie", resourceUsages, null, null);

        Resource oxygen = new Resource("oxygen", 100);
        Resource food = new Resource("food", 100);
        Resource water = new Resource("water", 100);

        myStation.addAstronaut(myAstronaut);
        myStation.addAstronaut(myAstronaut2);
        myStation.addAstronaut(myAstronaut3);
        myStation.addResource(oxygen);
        myStation.addResource(food);
        myStation.addResource(water);

        JsonUtil.toJsonFile("outFile4", myStation);
    }

    /*@Test
    void tempTest3() throws IOException {
        SpaceStation myStation = new SpaceStation();
        ArrayList<ResourceUsage> userList = new ArrayList<ResourceUsage>();
        userList.add(new ResourceUsage("Cash Money", 5, 1));
        userList.add(new ResourceUsage("Water", 29, 5));
        User myUser = new User("123", userList);
        Resource cashMoney = new Resource("Cash Money", 100);
        Resource water = new Resource("Water", 500);
        myStation.addUser(myUser);
        myStation.addResource(cashMoney);
        myStation.addResource(water);

        JsonUtil.toJsonFile("outFile3", myStation);
    }*/

    /*@Test
    void newTest() {
        SpaceStation myStation = new SpaceStation();

        ResourceUsage resUse1 = new ResourceUsage("oxygen", 5, 1);
        ResourceUsage resUse2 = new ResourceUsage("food", 3, 4);
        ResourceUsage resUse3 = new ResourceUsage("water", 4, 2);
        ArrayList<ResourceUsage> resourceUsages = new ArrayList<ResourceUsage>();
        resourceUsages.add(resUse1);
        resourceUsages.add(resUse2);
        resourceUsages.add(resUse3);

        Astronaut astronaut1 = new Astronaut("aidan", resourceUsages, null, null);
        Astronaut astronaut2 = new Astronaut("damion", resourceUsages, null, null);
        Astronaut astronaut3 = new Astronaut("jolie", resourceUsages, null, null);
        myStation.addAstronaut(astronaut1);
        myStation.addAstronaut(astronaut2);
        myStation.addAstronaut(astronaut3);

        Resource oxygen = new Resource()
    }*/

}

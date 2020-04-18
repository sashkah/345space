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
        String expectedUsers = "[aidan [resourceName: oxygen usagePTF: 5.0 timeframe: 1, resourceName: food usagePTF: 3.0 timeframe: 4, resourceName: water usagePTF: 4.0 timeframe: 2], damion [resourceName: oxygen usagePTF: 5.0 timeframe: 1, resourceName: food usagePTF: 3.0 timeframe: 4, resourceName: water usagePTF: 4.0 timeframe: 2], jolie [resourceName: oxygen usagePTF: 5.0 timeframe: 1, resourceName: food usagePTF: 3.0 timeframe: 4, resourceName: water usagePTF: 4.0 timeframe: 2]]";
        String expectedResources = "[oxygen 100.0, food 100.0, water 100.0]";
        SpaceStation spaceStation;
        spaceStation = ReadFromFile.createSpaceStation("src/main/resources/test.txt");
        assertEquals(expectedUsers, spaceStation.getUsers().toString());
        assertEquals(expectedResources, spaceStation.getResources().toString());
    }

    @Test
    void tempTest() throws IOException {
        User user1 = new User("aidan");
        User user2 = new User("jolie");
        Resource res1 = new Resource("food", 100);
        Resource res2 = new Resource("water", 100);
        ArrayList<User> users = new ArrayList<User>();
        users.add(user1);
        users.add(user2);
        ArrayList<Resource> resources = new ArrayList<Resource>();
        resources.add(res1);
        resources.add(res2);
        SpaceStation station = new SpaceStation(users, resources);

        JsonUtil.toJsonFile("outFile", station);
    }

    @Test
    void tempTest2() throws IOException {
        SpaceStation myStation = new SpaceStation();

        ArrayList<ResourceUsage> userList = new ArrayList<ResourceUsage>();
        userList.add(new ResourceUsage("oxygen", 5, 1));
        userList.add(new ResourceUsage("food", 3, 4));
        userList.add(new ResourceUsage("water", 4, 2));

        User myUser = new User("aidan", userList);
        User myUser2 = new User("damion", userList);
        User myUser3 = new User("jolie", userList);

        Resource oxygen = new Resource("oxygen", 100);
        Resource food = new Resource("food", 100);
        Resource water = new Resource("water", 100);

        myStation.addUser(myUser);
        myStation.addUser(myUser2);
        myStation.addUser(myUser3);
        myStation.addResource(oxygen);
        myStation.addResource(food);
        myStation.addResource(water);

        JsonUtil.toJsonFile("outFile2", myStation);
    }

    @Test
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
    }

}

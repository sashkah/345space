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

        File fileIn = new File("src/main/resources/test.txt");
        String fileString = ReadFromFile.getContents(fileIn);
        System.out.println(fileString);
        String expectedString = "{" + "  \"users\" : [ {" + "    \"id\" : \"damion\"," + "    \"resourceUsage\" : null" + "  }, {" + "    \"id\" : \"jolie\"," + "    \"resourceUsage\" : null" + "  }, {" + "    \"id\" : \"aidan\"," + "    \"resourceUsage\" : null" + "  } ]," + "  \"resources\" : [ {" + "    \"name\" : \"oxygen\"," + "    \"amount\" : 100.0" + "  }, {" + "    \"name\" : \"food\"," + "    \"amount\" : 100.0" + "  }, {" + "    \"name\" : \"water\"," + "    \"amount\" : 100.0" + "  } ]" + "}";
        assertEquals(expectedString, fileString);
    }

    @Test
    void createSpaceStationTest() throws IOException {
        String expectedUsers = "[damion, jolie, aidan]";
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

}

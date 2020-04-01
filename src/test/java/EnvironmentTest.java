import com.fasterxml.jackson.annotation.JsonIgnoreType;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

public class EnvironmentTest {

    @Test
    void EnvironmentTest() throws InterruptedException, IOException {
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

        System.out.println(myStation.getUsers().toString());
        System.out.println(myStation.getResources().toString());

        SpaceStation myStation2 = ReadFromFile.createSpaceStation("src/main/resources/test3.txt");
        System.out.println(myStation2.getUsers().toString());
        System.out.println(myStation2.getResources().toString());

        System.out.println(myStation.getUsers().toString().equals(myStation2.getUsers().toString()));
        System.out.println(myStation.getResources().toString().equals(myStation2.getResources().toString()));

        Environment myEnviro = new Environment(myStation2);
        myEnviro.runLoop(20, 1000, true);

        Assert.assertTrue(myStation.getResources().get(1).getAmount() == 384);

    }
}

import com.fasterxml.jackson.annotation.JsonIgnoreType;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

public class EnvironmentTest {

    @Test
    void EnvironmentTest() throws InterruptedException, IOException {

        //Creates a new SpaceStation object
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

        //Creates an identical SpaceStation object from file
        SpaceStation myStation2 = ReadFromFile.createSpaceStation("src/main/resources/test3.txt");
        //System.out.println(myStation2.getUsers().toString());
        //System.out.println(myStation2.getResources().toString());

        //prints true if the users and resources of each spacestation are equal
        //System.out.println(myStation.getUsers().toString().equals(myStation2.getUsers().toString()));
        //System.out.println(myStation.getResources().toString().equals(myStation2.getResources().toString()));

        //runs both spacestations through test environment
        //System.out.println("manually made spacestation");
        Environment myEnviro = new Environment(myStation);
        myEnviro.runLoop(20, 250, false);
        //System.out.println("spacestation from file");
        Environment myEnviro2 = new Environment(myStation2);
        myEnviro2.runLoop(20, 250, false);

        //passes if resources depleted properly
        Assert.assertTrue(myStation.getResources().get(1).getAmount() == 384);
        Assert.assertTrue(myStation2.getResources().get(1).getAmount() == 384);

    }
}

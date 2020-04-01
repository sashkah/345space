import org.junit.Assert;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

public class EnvironmentTest {

    @Test
    void EnvironmentTest() throws InterruptedException{
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

        Environment myEnviro = new Environment(myStation);
        myEnviro.runLoop(20, 0, false);

        Assert.assertTrue(myStation.getResources().get(1).getAmount() == 384);

    }
}

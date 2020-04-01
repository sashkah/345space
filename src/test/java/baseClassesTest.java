import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class baseClassesTest {

    @Test
    void SpaceStationTest(){
        SpaceStation myStation = new SpaceStation();
        User myUser = new User("123", null);
        Resource cashMoney = new Resource("Cash Money", 100.15);

        myStation.addUser(myUser);

        Assert.assertTrue(myStation.getUsers().contains(myUser));

        myStation.addResource(cashMoney);

        Assert.assertTrue(myStation.getResources().size() == 1);
        Assert.assertTrue(myStation.getResources().contains(cashMoney));

        myStation.addResource("Cash Money", 50);

        Assert.assertTrue(myStation.getResources().get(0).amount == 150.15);

        myStation.addResource(cashMoney);

        Assert.assertFalse(myStation.getResources().size() == 2);
    }

    @Test
    void ResourceTest(){
        Resource myResource = new Resource("resource", 10);
        myResource.addAmount(10);

        Assert.assertTrue(myResource.getAmount() == 20);

        myResource.setAmount(50);

        Assert.assertTrue(myResource.getAmount() == 50);
    }

}

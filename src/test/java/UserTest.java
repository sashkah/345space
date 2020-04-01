import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {

    @Test
    void setResourceUsageTest(){
        User user1=new User("TestUser1");
        user1.setResourceUsage("air",20,1);
        List<Double> resourceUsage1=user1.getResourceUsage().get("air");

        assertEquals(20.0,resourceUsage1.get(0),.01);
        assertEquals(1.0,resourceUsage1.get(1),.01);

        user1.setResourceUsage("air",15,2);
        resourceUsage1=user1.getResourceUsage().get("air");
        assertEquals(15.0,resourceUsage1.get(0),.01);
        assertEquals(2.0,resourceUsage1.get(1),.01);

    }
}

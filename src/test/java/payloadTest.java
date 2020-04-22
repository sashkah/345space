import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class payloadTest {

    @Test
    void payloadTest() throws InterruptedException{
        ArrayList<Astronaut> userlist = new ArrayList<Astronaut>();
        ResourceUsage myUsage = new ResourceUsage("water", 5, 1);
        ArrayList<ResourceUsage> usages = new ArrayList<ResourceUsage>();
        usages.add(myUsage);
        Astronaut me = new Astronaut("damion", usages, null, null);
        userlist.add(me);
        ArrayList<Resource> resourceList = new ArrayList<Resource>();
        Resource water = new Resource("water", 2900);
        resourceList.add(water);
        SpaceStation myStation = new SpaceStation(userlist, resourceList, null);
        ArrayList<EarthEmployee> employee = null;
        EarthStation newStationE = new EarthStation(myStation, employee);
        Resource newWater = new Resource("water", 29);
        ArrayList<Resource> cargo = new ArrayList<Resource>();
        cargo.add(newWater);
        Payload newPayload = new Payload(1, 5, cargo);
        ArrayList<Payload> thisOne = new ArrayList<Payload>();
        thisOne.add(newPayload);
        Environment myEnviro = new Environment(myStation, newStationE, thisOne);
        myEnviro.runLoop(10, 100, true);

    }
}

import edu.ithaca.dragon.util.JsonUtil;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

public class Demo {

    @Test
    void createSpaceStationFile() throws IOException {
        SpaceStation myStation = new SpaceStation();

        //Create ResourceUsage collection for Astronauts
        ArrayList<ResourceUsage> resourceUsages = new ArrayList<ResourceUsage>();
        resourceUsages.add(new ResourceUsage("power", 0, 1));
        resourceUsages.add(new ResourceUsage("oxygen", 5, 1));
        resourceUsages.add(new ResourceUsage("food", 3, 4));
        resourceUsages.add(new ResourceUsage("water", 4, 2));

        //Create TotalResourceUsage collection (currently not implemented with Environment)
        ArrayList<TotalResourceUsage> totalResourceUsages = new ArrayList<TotalResourceUsage>();
        totalResourceUsages.add(new TotalResourceUsage("power"));
        totalResourceUsages.add(new TotalResourceUsage("oxygen"));
        totalResourceUsages.add(new TotalResourceUsage("food"));
        totalResourceUsages.add(new TotalResourceUsage("water"));

        //Create ResourceLimit collection for Astronauts
        ArrayList<ResourceLimit> resourceLimits = new ArrayList<ResourceLimit>();
        resourceLimits.add(new ResourceLimit("power", -1));
        resourceLimits.add(new ResourceLimit("oxygen", -1));
        resourceLimits.add(new ResourceLimit("food", 100));
        resourceLimits.add(new ResourceLimit("water", 100));

        //Create Astronauts & add to SpaceStation
        myStation.addAstronaut(new Astronaut("Kerry Anne", resourceUsages, totalResourceUsages, resourceLimits));
        myStation.addAstronaut(new Astronaut("Amelia", resourceUsages, totalResourceUsages, resourceLimits));
        myStation.addAstronaut(new Astronaut("Scott", resourceUsages, totalResourceUsages, resourceLimits));
        myStation.addAstronaut(new Astronaut("Kelsey", resourceUsages, totalResourceUsages, resourceLimits));
        myStation.addAstronaut(new Astronaut("Robert", resourceUsages, totalResourceUsages, resourceLimits));

        //Create Resources & add to SpaceStation
        myStation.addResource(new Resource("power", 400));
        myStation.addResource(new Resource("oxygen", 500));
        myStation.addResource(new Resource("food", 100));
        myStation.addResource(new Resource("water", 200));

        //Create ResourceUsage collection for Kitchen Appliances
        ArrayList<ResourceUsage> kitchenAppsResourceUsages = new ArrayList<ResourceUsage>();
        kitchenAppsResourceUsages.add(new ResourceUsage("power", 2, 1));
        kitchenAppsResourceUsages.add(new ResourceUsage("oxygen", 0, 1));
        kitchenAppsResourceUsages.add(new ResourceUsage("food", 1, 1));
        kitchenAppsResourceUsages.add(new ResourceUsage("water", 1, 1));

        //Create ResourceUsage collection for Bathroom Appliances
        ArrayList<ResourceUsage> bathroomAppsResourceUsages = new ArrayList<ResourceUsage>();
        bathroomAppsResourceUsages.add(new ResourceUsage("power", 1, 1));
        bathroomAppsResourceUsages.add(new ResourceUsage("oxygen", 0, 1));
        bathroomAppsResourceUsages.add(new ResourceUsage("food", 0, 1));
        bathroomAppsResourceUsages.add(new ResourceUsage("water", 3, 1));

        //Create ResourceUsage collection for Gym Appliances
        ArrayList<ResourceUsage> gymAppsResourceUsages = new ArrayList<ResourceUsage>();
        gymAppsResourceUsages.add(new ResourceUsage("power", 4, 1));
        gymAppsResourceUsages.add(new ResourceUsage("oxygen", 0, 1));
        gymAppsResourceUsages.add(new ResourceUsage("food", 1, 1));
        gymAppsResourceUsages.add(new ResourceUsage("water", 1, 1));

        //Create collections of Appliances
        ArrayList<Appliance> kitchenApps = new ArrayList<Appliance>();
        kitchenApps.add(new Appliance("coffee machine", kitchenAppsResourceUsages, totalResourceUsages));
        kitchenApps.add(new Appliance("blender", kitchenAppsResourceUsages, totalResourceUsages));
        ArrayList<Appliance> bathroomApps = new ArrayList<Appliance>();
        bathroomApps.add(new Appliance("toilet", bathroomAppsResourceUsages, totalResourceUsages));
        bathroomApps.add(new Appliance("shower", bathroomAppsResourceUsages, totalResourceUsages));
        ArrayList<Appliance> gymApps = new ArrayList<Appliance>();
        gymApps.add(new Appliance("treadmill", gymAppsResourceUsages, totalResourceUsages));
        gymApps.add(new Appliance("elliptical", gymAppsResourceUsages, totalResourceUsages));

        //Create Rooms & add to SpaceStation
        myStation.addRoom(new Room("kitchen 1", 200, "kitchen", resourceUsages, kitchenApps, new ArrayList<Astronaut>()));
        myStation.addRoom(new Room("bathroom 1 ", 100, "bathroom", resourceUsages, bathroomApps, new ArrayList<Astronaut>()));
        myStation.addRoom(new Room("gym 1", 300, "gym", resourceUsages, gymApps, new ArrayList<Astronaut>()));

        //Create file
        JsonUtil.toJsonFile("src/main/resources/DemoFile.txt", myStation);
    }

    @Test
    void demo() throws IOException, InterruptedException {
        //Creates a SpaceStation object from file
        SpaceStation myStation = ReadFromFile.createSpaceStation("src/main/resources/DemoFile.txt");
        Environment myEnviro = new Environment(myStation);
        myEnviro.runLoop(25, 250, true);

    }
}

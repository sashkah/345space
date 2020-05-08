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
        //User myUser = new User("123", userList);
        Astronaut myAstronaut = new Astronaut("123", userList, null, null);
        Resource cashMoney = new Resource("Cash Money", 100);
        Resource water = new Resource("Water", 500);
        //myStation.addUser(myUser);
        myStation.addAstronaut(myAstronaut);
        myStation.addResource(cashMoney);
        myStation.addResource(water);

        //Creates an identical SpaceStation object from file
        SpaceStation myStation2 = ReadFromFile.createSpaceStation("src/main/resources/spaceShip.txt");
        //System.out.println(myStation2.getUsers().toString());
        //System.out.println(myStation2.getResources().toString());

        //prints true if the users and resources of each spacestation are equal
        //System.out.println(myStation.getUsers().toString().equals(myStation2.getUsers().toString()));
        //System.out.println(myStation.getResources().toString().equals(myStation2.getResources().toString()));

        //runs both spacestations through test environment
        //System.out.println("manually made spacestation");
//        Environment myEnviro = new Environment(myStation);
//        myEnviro.runLoop(20, 250, false);
        //System.out.println("spacestation from file");
        EarthStation station = new EarthStation(myStation2, null);
        Environment myEnviro2 = new Environment(myStation2, station);
        myEnviro2.runLoop(25, 250, true, 2);

        //passes if resources depleted properly
        //Assert.assertTrue(myStation.getResources().get(1).getAmount() == 384);
        //Assert.assertTrue(myStation2.getResources().get(1).getAmount() == 384);

    }

    @Test
    void RandomEventTest() {
        Astronaut astronaut1  = new Astronaut("jolie", null,null, null);
        Astronaut astronaut2 = new Astronaut("aidan", null,null, null);
        Astronaut astronaut3 = new Astronaut("damion", null,null, null);
        Astronaut astronaut4 = new Astronaut("kandace", null,null, null);
        Astronaut astronaut5 = new Astronaut("toby", null,null, null);
        Resource res1 = new Resource("food", 100);
        Resource res2 = new Resource("water", 100);

        Appliance app1 = new Appliance("coffee machine", null, null);
        Appliance app2 = new Appliance("blender", null, null);
        Appliance app3 = new Appliance("toilet", null, null);
        Appliance app4 = new Appliance("shower", null, null);
        Appliance app5 = new Appliance("treadmill", null, null);
        Appliance app6 = new Appliance("elliptical", null, null);
        ArrayList<Appliance> apps1 = new ArrayList<Appliance>();
        apps1.add(app1);
        apps1.add(app2);
        ArrayList<Appliance> apps2 = new ArrayList<Appliance>();
        apps2.add(app3);
        apps2.add(app4);
        ArrayList<Appliance> apps3 = new ArrayList<Appliance>();
        apps3.add(app5);
        apps3.add(app6);

        Room room1 = new Room("kitchen 1", 100, "kitchen", null, apps1, new ArrayList<Astronaut>());
        Room room2 = new Room("bathroom 1", 50, "bathroom", null, apps2, new ArrayList<Astronaut>());
        Room room3 = new Room("gym 1", 100, "gym", null, apps3, new ArrayList<Astronaut>());

        ArrayList<Astronaut> astronauts = new ArrayList<Astronaut>();
        astronauts.add(astronaut1);
        astronauts.add(astronaut2);
        astronauts.add(astronaut3);
        astronauts.add(astronaut4);
        astronauts.add(astronaut5);
        ArrayList<Resource> resources = new ArrayList<Resource>();
        resources.add(res1);
        resources.add(res2);
        ArrayList<Room> rooms = new ArrayList<Room>();
        rooms.add(room1);
        rooms.add(room2);
        rooms.add(room3);
        SpaceStation station = new SpaceStation(astronauts, resources, rooms);

        Environment myEnviro = new Environment(station);
        System.out.println(myEnviro.randomEvent());
        System.out.println(myEnviro.randomEvent());
        System.out.println(myEnviro.randomEvent());
        System.out.println(myEnviro.randomEvent());
        System.out.println(myEnviro.randomEvent());
        System.out.println(myEnviro.randomEvent());
        System.out.println(myEnviro.randomEvent());
        System.out.println(myEnviro.randomEvent());
        System.out.println(myEnviro.randomEvent());
        System.out.println(myEnviro.randomEvent());

    }


}

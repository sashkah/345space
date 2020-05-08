import edu.ithaca.dragon.util.JsonUtil;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class UserInterface {
    public static void main(String[] args) throws InterruptedException, IOException {
        System.out.println("Welcome! Please enter a number to select an option: " +
                "\n1) Start with the default space station\n2) Start with a random space station\n3) Set up a new Space Station manually");

        SpaceStation myStation = null;
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        boolean done = false;

        while(!done) {
            if (input.equals("1")) {
                done = true;
                myStation = defaultSpaceStation();
                System.out.println("Station contains: " + myStation.displayRooms());
            } else if (input.equals("2")) {
                done = true;
                myStation = randomSpaceStation();
                System.out.println("Station contains: " + myStation.displayRooms());
            } else if (input.equals("3")) {
                done = true;
                myStation = manualSpaceStation();
                System.out.println("Station contains: " + myStation.displayRooms());
            } else {
                System.out.println("Error: invalid input - please enter a number to select an option.");
            }
        }

        ArrayList<ResourceUsage> resourceUsages = new ArrayList<ResourceUsage>();
        resourceUsages.add(new ResourceUsage("oxygen", 5, 1));
        resourceUsages.add(new ResourceUsage("food", 3, 4));
        resourceUsages.add(new ResourceUsage("water", 4, 2));
        ArrayList<TotalResourceUsage> totalResourceUsages = new ArrayList<TotalResourceUsage>();
        totalResourceUsages.add(new TotalResourceUsage("oxygen"));
        totalResourceUsages.add(new TotalResourceUsage("food"));
        totalResourceUsages.add(new TotalResourceUsage("water"));
        ArrayList<ResourceLimit> resourceLimits = new ArrayList<ResourceLimit>();
        resourceLimits.add(new ResourceLimit("oxygen", -1));
        resourceLimits.add(new ResourceLimit("food", 100));
        resourceLimits.add(new ResourceLimit("water", 100));


        System.out.println("Please enter the name of the first astronaut: ");
        String name = in.nextLine();
        myStation.addAstronaut(new Astronaut(name, resourceUsages, totalResourceUsages, resourceLimits));
        System.out.println("Added " + name);

        boolean done2 = false;
        while(!done2) {
            System.out.println("Please enter the name of another astronaut, or type done.");
            String input2 = in.nextLine();
            if(!(input2.equalsIgnoreCase("done"))) {
                myStation.addAstronaut(new Astronaut(input2, resourceUsages, totalResourceUsages, resourceLimits));
                System.out.println("Added " + input2);
            } else {
                done2 = true;
            }
        }

        //simulation start
        done = false;
        int numHours = 0;
        int sleepTime = 0;
        int numStepsBetweenPause = 0;
        while(!done){
            System.out.println("How long would you like to run the sim for? (Each represents 30 minutes)");
            input = in.nextLine();
            try{
                numHours = Integer.parseInt(input);
                done = true;
            }
            catch(NumberFormatException e){
                System.out.println("Error: invalid input - please enter a number.");
            }
        }
        done = false;
        while(!done){
            System.out.println("How long would you like to wait between ticks? (In seconds)");
            input = in.nextLine();
            try{
                sleepTime = Integer.parseInt(input) * 1000;
                done = true;
            }
            catch(NumberFormatException e){
                System.out.println("Error: invalid input - please enter a number.");
            }
        }
        done = false;
        while(!done){
            System.out.println("How many ticks do you want to go between pauses?");
            input = in.nextLine();
            try{
                numStepsBetweenPause = Integer.parseInt(input);
                done = true;
            }
            catch(NumberFormatException e){
                System.out.println("Error: invalid input - please enter a number.");
            }
        }
        ArrayList<String> list = SpaceStation.resourceList(myStation);
        if(!list.contains("food")){
            list.add("food");
        }
        if(!list.contains("water")){
            list.add("water");
        }
        if(!list.contains("oxygen")){
            list.add("oxygen");
        }
        for (int i = 0; i < list.size(); i++){
            done = false;
            int num = 0;
            while(!done){
                System.out.println("How much " + SpaceStation.resourceList(myStation).get(i) + " do you want?");
                input = in.nextLine();
                try{
                    num = Integer.parseInt(input);
                    done = true;
                }
                catch(NumberFormatException e){
                    System.out.println("Error: invalid input - please enter a number.");
                }
            }
            myStation.addResource(new Resource(SpaceStation.resourceList(myStation).get(i), num));
        }

        EarthStation earthStation = new EarthStation(myStation,null);
        Environment myEnvironment = new Environment(myStation, earthStation);
        myEnvironment.runLoop(numHours, sleepTime, true, numStepsBetweenPause);
    }

    private static SpaceStation defaultSpaceStation() throws IOException {
        SpaceStation defaultStation = ReadFromFile.createSpaceStation("src/main/resources/DefaultSpaceStation.txt");
        System.out.println(defaultStation);

        return defaultStation;
    }

    private static SpaceStation randomSpaceStation() throws IOException {
        SpaceStation myStation = new SpaceStation();
        int roomNum = (int) (Math.random() * 15) + 1;
        ArrayList<String> str = new ArrayList<>();

        File f = new File("src/main/resources/rooms");
        for(String pathname:f.list()){
            str.add(pathname.substring(0, pathname.length() - 4));
        }

        for(int i = 0; i<= roomNum; i++){
            int r = (int) (Math.random() * 10);
            Room newRoom = JsonUtil.fromJsonFile("src/main/resources/rooms/" + str.get(r) + ".txt", Room.class);
            myStation.addRoom(newRoom);
        }
        return myStation;
    }

    private static SpaceStation manualSpaceStation() {
        boolean done = false;
        SpaceStation myStation = new SpaceStation();
        while(!done) {
            System.out.println("Type the name of the room file you want to load from the directory: \nsrc/main/resources/rooms/\nExample: commonArea\nType 'done' to finish");
            Scanner in = new Scanner(System.in);
            String input = in.nextLine();
            try {
                if(input.equalsIgnoreCase("done")){
                    done = true;
                }
                else{
                    Room newRoom = JsonUtil.fromJsonFile("src/main/resources/rooms/" + input + ".txt", Room.class);
                    myStation.addRoom(newRoom);
                }

            } catch (Exception e) {
                System.out.println("Error: invalid room - try again.");
            }
        }
        return myStation;
    }

}

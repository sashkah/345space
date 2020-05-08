import edu.ithaca.dragon.util.JsonUtil;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class UserInterface {

    public static int skipAmt = 0;

    public static void main(String[] args) throws InterruptedException, IOException {
        System.out.println("Welcome! Please enter a number to select an option: " +
                "\n1) Start with the default space station\n2) Start with a random space station\n3) Set up a new Space Station manually\n4) Load Space Station from file");

        SpaceStation myStation = null;
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        boolean done = false;
        boolean loadingFromFile = false;

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
            } else if (input.equals("4")) {
              boolean fileFound = false;
              loadingFromFile = true;
              while(!fileFound) {
                  System.out.println("Enter file path:");
                  Scanner fileScanner = new Scanner(System.in);
                  String filePath = fileScanner.nextLine();
                  try {
                      myStation = ReadFromFile.createSpaceStation(filePath);
                      fileFound = true;
                      done = true;
                      System.out.println("Station contains: " + myStation.displayRooms());
                  } catch (FileNotFoundException e) {
                      System.out.println("Error: File not found.");
                  }
              }
            } else {
                System.out.println("Error: invalid input - please enter a number to select an option.");
            }
        }

        ArrayList<ResourceUsage> resourceUsages = new ArrayList<ResourceUsage>();
        resourceUsages.add(new ResourceUsage("oxygen", 5, 1));
        resourceUsages.add(new ResourceUsage("food", 3, 4));
        resourceUsages.add(new ResourceUsage("water", 4, 2));
        ArrayList<ResourceLimit> resourceLimits = new ArrayList<ResourceLimit>();
        resourceLimits.add(new ResourceLimit("oxygen", -1));
        resourceLimits.add(new ResourceLimit("food", 100));
        resourceLimits.add(new ResourceLimit("water", 100));

        if(!loadingFromFile) {
            System.out.println("Please enter the name of the first astronaut: ");
            String name = in.nextLine();
            myStation.addAstronaut(new Astronaut(name, resourceUsages, new ArrayList<TotalResourceUsage>(), resourceLimits));
            System.out.println("Added " + name);


            boolean done2 = false;
            while (!done2) {
                System.out.println("Please enter the name of another astronaut, or type done.");
                String input2 = in.nextLine();
                if (!(input2.equalsIgnoreCase("done"))) {
                    myStation.addAstronaut(new Astronaut(input2, resourceUsages, new ArrayList<TotalResourceUsage>(), resourceLimits));
                    System.out.println("Added " + input2);
                } else {
                    done2 = true;
                }
            }
        }

        //simulation start
        if(!loadingFromFile) {
            ArrayList<String> list = SpaceStation.resourceList(myStation);
            if (!list.contains("food")) {
                list.add("food");
            }
            if (!list.contains("water")) {
                list.add("water");
            }
            if (!list.contains("oxygen")) {
                list.add("oxygen");
            }
            for (int i = 0; i < list.size(); i++) {
                done = false;
                int num = 0;
                while (!done) {
                    System.out.println("How much " + list.get(i) + " do you want?");
                    input = in.nextLine();
                    try {
                        num = Integer.parseInt(input);
                        done = true;
                    } catch (NumberFormatException e) {
                        System.out.println("Error: invalid input - please enter a number.");
                    }
                }
                myStation.addResource(new Resource(list.get(i), num));
            }
        }

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

        System.out.println("Starting simulation!");

        EarthStation earthStation = new EarthStation(myStation,null);
        Environment myEnvironment = new Environment(myStation, earthStation);
        myEnvironment.runLoop(numHours, sleepTime, true, numStepsBetweenPause);
    }

    private static SpaceStation defaultSpaceStation() throws IOException {
        SpaceStation defaultStation = ReadFromFile.createSpaceStation("src/main/resources/DefaultSpaceStation.txt");

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

    public static void whilePaused(Environment environment) {
        boolean pauseDone = false;
        while(!pauseDone) {
            System.out.println("Enter a command (type help for a list of commands, or press enter to continue):");
            Scanner scan = new Scanner(System.in);
            String cmd = scan.nextLine();
            if (cmd.equalsIgnoreCase("help")) {
                System.out.println("List of commands:");
                System.out.println("\thelp:\n\t\tDisplays a list of all commands and their uses");
                System.out.println("\tinfo:\n\t\tReturns an information report on the usages of all astronauts");
                System.out.println("\tsave:\n\t\tSaves the current station and quits the sim");
                System.out.println("\tsend:\n\t\tPrompts user to input details for a payload to be shipped to the station");
                System.out.println("\tskip:\n\t\tPrompts the user for a number of turns to go without pausing");
                System.out.println("\trestrict:\n\t\tPlaces a restriction on a user's resource usage");
                System.out.println("\texit:\n\t\tExits application without saving.");

            } else if (cmd.equalsIgnoreCase("")) {
                pauseDone = true;
            } else if (cmd.equalsIgnoreCase("send")) {
                boolean done = false;
                Scanner in = new Scanner(System.in);
                String input = null;
                String input2 = null;
                int numResource = 0;
                while(!done){
                    System.out.println("What resource are you sending?");
                    input = in.nextLine();
                    for(Resource resource:environment.getLocalStation().getResources()){
                        if(resource.getName().equalsIgnoreCase(input)){
                            done = true;
                        }
                    }
                    if(!done){System.out.println("Error: invalid input - invalid resource");}
                }
                done = false;
                while(!done){
                    System.out.println("How much?");
                    input2 = in.nextLine();
                    try{
                        numResource = Integer.parseInt(input);
                        done = true;
                    }
                    catch(NumberFormatException e){
                        System.out.println("Error: invalid input - please enter a number.");
                    }
                }
                ArrayList<Resource> temp = new ArrayList<>();
                temp.add(new Resource(input, numResource));
                Payload payload = new Payload(environment.getTimeCounter(), 5, temp);
                environment.recievePayload(payload);
                pauseDone = true;

            } else if (cmd.equalsIgnoreCase("save")) {
                boolean done = false;
                String input = null;
                Scanner in = new Scanner(System.in);
                while(!done){
                    System.out.println("Enter a filename:");
                    input = in.nextLine();
                    try{
                        SpaceStation.saveSpaceStation(input, environment.getLocalStation());
                        done = true;
                        pauseDone = true;
                        environment.close();
                    }
                    catch (Exception e){
                        System.out.println("Error: invalid input - enter a valid filename");
                    }
                }


            } else if (cmd.equalsIgnoreCase("info")) {
                environment.getEarthStation().viewResourceReport();

            } else if (cmd.equalsIgnoreCase("restrict")) {

            } else if (cmd.equalsIgnoreCase("skip")) {
                System.out.println("How many ticks would you like to skip user input for?");
                Scanner in = new Scanner(System.in);
                String input;
                int inputInt;
                boolean done = false;

                while(!done) {
                    input = in.nextLine();
                    try {
                        inputInt = Integer.parseInt(input);
                        if(inputInt > 0) {
                            System.out.println("Skipping for " + inputInt + " ticks.");
                            skipAmt = inputInt;
                            done = true;
                        } else {
                            System.out.println("Error: invalid input - please enter a number greater than zero.");
                        }

                    } catch (NumberFormatException e) {
                        System.out.println("Error: invalid input - please enter a number.");
                    }
                }

            } else if(cmd.equalsIgnoreCase("exit")) {
                System.exit(0);
            } else {
                System.out.println("Error: Invalid command. Type help for a list of commands.");
            }
        }

    }

}

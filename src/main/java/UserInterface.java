import edu.ithaca.dragon.util.JsonUtil;

import java.util.Scanner;

public class UserInterface {
    public static void main(String[] args) {
        System.out.println("Welcome! Please enter a number to select an option: " +
                "\n1) Start with the default space station\n2) Start with a random space station\n3) Set up a new Space Station manually");

        SpaceStation myStation;
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        boolean done = false;

        while(done == false) {
            if (input.equals("1")) {
                done = true;
                myStation = defaultSpaceStation();
                myStation.displayRooms();
            } else if (input.equals("2")) {
                done = true;
                myStation = randomSpaceStation();
                myStation.displayRooms();
            } else if (input.equals("3")) {
                done = true;
                myStation = manualSpaceStation();
                System.out.println("Station contains: " + myStation.displayRooms());
            } else {
                System.out.println("Error: invalid input - please enter a number to select an option.");
            }
        }

        //astronaut setup

        //simulation start
    }

    private static SpaceStation defaultSpaceStation() {
        return null;
    }

    private static SpaceStation randomSpaceStation() {
        return null;
    }

    private static SpaceStation manualSpaceStation() {
        boolean done = false;
        SpaceStation myStation = new SpaceStation();
        while(!done) {
            System.out.println("Type the name of the room file you want to load from the directory: \nsrc\\main\\resources\\rooms\\\nExample: commonArea\nType 'done' to finish");
            Scanner in = new Scanner(System.in);
            String input = in.nextLine();
            try {
                if(input.equalsIgnoreCase("done")){
                    done = true;
                }
                else{
                    Room newRoom = JsonUtil.fromJsonFile("src\\main\\resources\\rooms\\" + input + ".txt", Room.class);
                    myStation.addRoom(newRoom);
                }

            } catch (Exception e) {
                System.out.println("Error: invalid room - try again.");
            }
        }
        return myStation;
    }

}

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    public static void main(String[] args) {
        System.out.println("Welcome! Please enter a number to select an option: " +
                "\n1) Start with the default space station\n2) Start with a random space station\n3) Set up a new Space Station manually");

        SpaceStation myStation;
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        boolean done = false;

        while(!done) {
            if (input.equals("1")) {
                done = true;
                myStation = defaultSpaceStation();
                //myStation.displayRooms();
            } else if (input.equals("2")) {
                done = true;
                myStation = randomSpaceStation();
                myStation.displayRooms();
            } else if (input.equals("3")) {
                done = true;
                myStation = manualSpaceStation();
                myStation.displayRooms();
            } else {
                System.out.println("Error: invalid input - please enter a number to select an option.");
            }
        }

        System.out.println("Please enter the name of the first astronaut: ");
        String name = in.nextLine();
        myStation.addAstronaut(new Astronaut(name, null, null, null));
        System.out.println("Added " + name);

        boolean done2 = false;
        while(!done2) {
            System.out.println("Please enter the name of another astronaut, or type done.");
            String input2 = in.nextLine();
            if(!(input2.equalsIgnoreCase("done"))) {
                myStation.addAstronaut(new Astronaut(input2, null, null, null));
                System.out.println("Added " + input2);
            } else {
                done2 = true;
            }
        }

        //simulation start
    }

    private static SpaceStation defaultSpaceStation() {
        return null;
    }

    private static SpaceStation randomSpaceStation() {
        return null;
    }

    private static SpaceStation manualSpaceStation() {
        return null;
    }

}

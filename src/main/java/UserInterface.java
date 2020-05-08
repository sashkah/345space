import java.io.IOException;
import java.util.Scanner;

public class UserInterface {
    public static void main(String[] args) throws InterruptedException, IOException {
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
                myStation.displayRooms();
            } else {
                System.out.println("Error: invalid input - please enter a number to select an option.");
            }
        }

        //astronaut setup

        //simulation start
        EarthStation earthStation=new EarthStation(myStation,null);
        Environment myEnvironment = new Environment(myStation,earthStation);

        myEnvironment.runLoop(50, 2500, true, 50);
    }

    private static SpaceStation defaultSpaceStation() throws IOException {
        SpaceStation defaultStation = ReadFromFile.createSpaceStation("src/main/resources/DemoFile.txt");

        return defaultStation;
    }

    private static SpaceStation randomSpaceStation() {
        return null;
    }

    private static SpaceStation manualSpaceStation() {
        return null;
    }

}

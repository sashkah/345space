import java.util.Scanner;

public class UserInterface {
    public static void main(String[] args) {
        System.out.println("Welcome! Please enter a number to select an option: " +
                "\n1) Start with the default space station\n2) Start with a random space station\n3) Set up a new Space Station manually");

        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        if(input.equals("1")) {

        } else if(input.equals("2")) {

        } else if(input.equals("3")){

        } else {

        }

    }
}

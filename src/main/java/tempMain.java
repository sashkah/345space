import java.io.File;
import java.io.FileNotFoundException;

public class tempMain {
    public static void main(String[] args) {
        try {
            System.out.println("started!");
            File fileIn = new File("src/main/resources/test.txt");
            String s = ReadFromFile.getContents(fileIn);
            System.out.println(s);
        } catch(FileNotFoundException e) {
            System.out.println("Error: file not found");
        }
    }
}

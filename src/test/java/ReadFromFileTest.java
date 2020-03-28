import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;

public class ReadFromFileTest {

    @Test
    void readFromFileTest() {

        try {
            File fileIn = new File("src/main/resources/test.txt");
            String fileString = ReadFromFile.getContents(fileIn);
            String expectedString = "oxygen100water100food100astronaut1astronaut2astronaut3";
            assertEquals(expectedString, fileString);
        } catch(FileNotFoundException e) {
            System.out.println("Error: file not found");
        }

    }

}

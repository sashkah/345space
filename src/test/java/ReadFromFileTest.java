import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadFromFileTest {

    @Test
    void getContentsTest() throws FileNotFoundException {

        File fileIn = new File("src/main/resources/test.txt");
        String fileString = ReadFromFile.getContents(fileIn);
        System.out.println(fileString);
        String expectedString = "{\"users\": [\"damion\", \"aidan\", \"jolie\"], \"resources\" : {\"oxygen\": 100, \"water\": 100, \"food\": 100}}";
        assertEquals(expectedString, fileString);
    }

    @Test
    void createSpaceStationTest() throws IOException {
        File fileIn = new File("src/main/resources/test.txt");
        SpaceStation spaceStation;
        spaceStation = ReadFromFile.createSpaceStation(fileIn);
        System.out.println(spaceStation.getUsers());
        System.out.println(spaceStation.getResources());
    }

}

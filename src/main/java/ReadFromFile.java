import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class ReadFromFile {

    public ReadFromFile() {

    }

    public static String getContents(File fileIn) throws FileNotFoundException {
            Scanner in = new Scanner(fileIn);
            String s = "";

            while(in.hasNextLine()) {
                s += in.nextLine();
            }
        return s;
    }

    public static SpaceStation createSpaceStation(File fileIn) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String spaceStationJson = getContents(fileIn);
        SpaceStation spaceStation = objectMapper.readValue(spaceStationJson, SpaceStation.class);
        return spaceStation;
    }

}

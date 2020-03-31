import com.fasterxml.jackson.databind.ObjectMapper;
import edu.ithaca.dragon.util.JsonUtil;

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

    public static SpaceStation createSpaceStation(String filePath) throws IOException {
        SpaceStation spaceStation = JsonUtil.fromJsonFile(filePath, SpaceStation.class);
        return spaceStation;
    }

}

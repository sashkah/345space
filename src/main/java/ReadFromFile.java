import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFromFile {

    public ReadFromFile() {

    }

    public static String getContents(File fileIn) throws FileNotFoundException {
            Scanner in = new Scanner(fileIn);
            String s = "";

            while(in.hasNext()) {
                s += in.next();
            }
        return s;
    }

}

import java.util.ArrayList;
import java.util.Random;

public class Payload {
    private int ID;
    private int startTime;
    private int tripLength;
    private ArrayList<Resource> cargo;

    public Payload(int startTime, int tripLength, ArrayList<Resource> cargo){
        this.startTime = startTime;
        this.tripLength = tripLength;
        this.cargo = cargo;

        Random r = new Random();
        ID = r.nextInt((9999 - 1000) + 1) + 1000;
    }

    public Payload(){

    }

    public ArrayList<Resource> getCargo() {
        return cargo;
    }

    public int getID() {
        return ID;
    }

    public int getStartTime() {
        return startTime;
    }

    public int getTripLength() {
        return tripLength;
    }

    public void setCargo(ArrayList<Resource> cargo) {
        this.cargo = cargo;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public void setTripLength(int tripLength) {
        this.tripLength = tripLength;
    }

}

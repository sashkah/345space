import java.util.ArrayList;

public class Payload {
    private int ID;
    private int startTime;
    private int tripLength;
    private ArrayList<Resource> cargo;

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

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public void setTripLength(int tripLength) {
        this.tripLength = tripLength;
    }

}

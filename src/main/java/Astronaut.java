import java.util.ArrayList;

public class Astronaut extends User{

    ArrayList<ResourceLimit> resourceLimits;
    Room currentRoom;
    Appliance currentAppliance;


    public Astronaut(ArrayList<ResourceLimit> resourceLimits, Room currentRoom, Appliance currentAppliance){
        resourceLimits = null;
        currentRoom = null;
        currentAppliance = null;
    }

    public Room getCurrentRoom(){
        return currentRoom;
    }

    public Appliance getCurrentAppliance() {
        return currentAppliance;
    }

    public void changeRoom(Room newRoom){
        currentRoom = newRoom;
    }

    public void useAppliance(Appliance newAppliance){
        currentAppliance = newAppliance;
    }
}

import java.util.ArrayList;

public class Astronaut extends User{

    ArrayList<ResourceLimit> resourceLimits;
    Room currentRoom;
    Appliance currentAppliance;

    public Astronaut() {
    }

    public Astronaut(String idIn, ArrayList<ResourceUsage> resourceUsagesIn, ArrayList<ResourceLimit> resourceLimitsIn){
        super(idIn, resourceUsagesIn);
        resourceLimits = resourceLimitsIn;
        currentRoom = null;
        currentAppliance = null;
    }

    public void changeRoom(Room newRoom){
        currentRoom = newRoom;
    }

    public void useAppliance(Appliance newAppliance){
        currentAppliance = newAppliance;
    }

    public ArrayList<ResourceLimit> getResourceLimits(){
        return resourceLimits;
    }

    public Room getCurrentRoom(){
        return currentRoom;
    }

    public Appliance getCurrentAppliance() {
        return currentAppliance;
    }


}

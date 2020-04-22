import java.util.ArrayList;

public class Astronaut extends User{

    ArrayList<ResourceLimit> resourceLimits;
    Room currentRoom;
    Appliance currentAppliance;

    public Astronaut() {
    }

    public Astronaut(String idIn, ArrayList<ResourceUsage> resourceUsagesIn, ArrayList<TotalResourceUsage> totalResourceUsagesIn, ArrayList<ResourceLimit> resourceLimitsIn){
        super(idIn, resourceUsagesIn, totalResourceUsagesIn);
        resourceLimits = resourceLimitsIn;
        currentRoom = null;
        currentAppliance = null;
    }

    public void changeRoom(Room newRoom){
        currentRoom = newRoom;
        if(currentAppliance != null) {
            currentAppliance.setInUse(false);
            currentAppliance = null;
        }
    }

    public void useAppliance(Appliance newAppliance){
        if(currentAppliance != null) {
            currentAppliance.setInUse(false);
        }
        currentAppliance = newAppliance;
        if(currentAppliance != null) {
            currentAppliance.setInUse(true);
        }
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

    public ArrayList<ResourceUsage> getResourceUsages() {
        return super.getResourceUsages();
    }

}

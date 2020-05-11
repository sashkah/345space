import java.util.ArrayList;

public class Astronaut extends User{

    ArrayList<ResourceLimit> resourceLimits;
    Room currentRoom;
    Appliance currentAppliance;


    public ArrayList<Resource> cannotUse=new ArrayList<>();



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

    boolean checkIfBlockedAppliance(Appliance newAppliance) {
        for (Resource resource : cannotUse) {
            for (ResourceUsage resourceUsage2 : newAppliance.getResourceUsages()) {
                if (resource.getName().equals(resourceUsage2.getResourceName()))
                    return true;
            }
        }
        return false;
    }
    public void useAppliance(Appliance newAppliance){
        if(currentAppliance != null) {
            currentAppliance.setInUse(false);
        }
        if(!checkIfBlockedAppliance(newAppliance)) {//TODO:TEST!!!!!!!!!!!
            currentAppliance = newAppliance;
            if (currentAppliance != null) {
                currentAppliance.setInUse(true);
            }
        }//TODO:increment resource usage
    }
//    private boolean checkIfNearLimit(Appliance newAppliance){
//        for(ResourceLimit resourceLimit:getResourceLimits()){
//            if(resourceLimit.getLimit()<newAppliance.)
//        }
//        return true;
//    }


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
    public ArrayList<Resource> getCannotUse() {
        return cannotUse;
    }

    public void setCannotUse(ArrayList<Resource> cannotUse) {
        this.cannotUse = cannotUse;
    }
    public void setResourceLimits(ArrayList<ResourceLimit> resourceLimits) {
        this.resourceLimits = resourceLimits;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public void setCurrentAppliance(Appliance currentAppliance) {
        this.currentAppliance = currentAppliance;
    }

}

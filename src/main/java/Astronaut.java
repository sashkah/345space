import java.util.ArrayList;

public class Astronaut extends User {

    ArrayList<ResourceLimit> resourceLimits;
    Room currentRoom;
    Appliance currentAppliance;

    public Astronaut() {
    }

    public Astronaut(String idIn, ArrayList<ResourceUsage> resourceUsagesIn, ArrayList<TotalResourceUsage> totalResourceUsagesIn, ArrayList<ResourceLimit> resourceLimitsIn) {
        super(idIn, resourceUsagesIn, totalResourceUsagesIn);
        resourceLimits = resourceLimitsIn;
        currentRoom = null;
        currentAppliance = null;
    }

    public void changeRoom(Room newRoom) {
        currentRoom = newRoom;
        if (currentAppliance != null) {
            currentAppliance.setInUse(false);
            currentAppliance = null;
        }
    }

    public double getUsage(ResourceUsage resource) {
        for (TotalResourceUsage totalResourceUsage : getTotalResourceUsages()) {
            if (resource.getResourceName().equals(totalResourceUsage.getResourceName())) {
                return totalResourceUsage.getTotalDailyUsage();
            }
        }
        return 0;
    }

    public double getUsage(Resource resource) {
        for (TotalResourceUsage totalResourceUsage : getTotalResourceUsages()) {
            if (resource.getName().equals(totalResourceUsage.getResourceName())) {
                return totalResourceUsage.getTotalDailyUsage();
            }
        }
        return 0;
    }

    public boolean checkIfNearLimit(Appliance newAppliance) {
        if (newAppliance != null) {

            for (ResourceLimit resourceLimit : getResourceLimits()) {
                if (!resourceLimit.getResourceName().equalsIgnoreCase("oxygen") && !newAppliance.getId().equalsIgnoreCase("toilet")) {
                    for (ResourceUsage resourceUsage : newAppliance.getResourceUsages()) {
                        if (resourceLimit.getResourceName().equals(resourceUsage.getResourceName())) {
                            if (resourceLimit.getLimit() <= getUsage(resourceUsage)) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public boolean checkIfNearLimit(Resource resource) {
        for (ResourceLimit resourceLimit : getResourceLimits()) {
            if (!resourceLimit.getResourceName().equalsIgnoreCase("oxygen")) {
                if (resourceLimit.getResourceName().equals(resource.getName())) {
                    if (getUsage(resource) >= resourceLimit.getLimit()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void useAppliance(Appliance newAppliance) {
        if (newAppliance != null) {
            if(checkIfNearLimit(newAppliance)){
                System.out.println("Astronaut: " +getId()+" has reached resource limit. \nCannot use appliance: "+newAppliance.getId());
            }
            else{
                use(newAppliance);
            }

        }
        else {
            use(null);
        }
    }
    public void use(Appliance appliance){
        if (currentAppliance != null) {
            currentAppliance.setInUse(false);
        }
        currentAppliance = appliance;
        if (currentAppliance != null) {
            currentAppliance.setInUse(true);
        }
    }

    public ArrayList<ResourceLimit> getResourceLimits() {
        return resourceLimits;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public Appliance getCurrentAppliance() {
        return currentAppliance;
    }

    public ArrayList<ResourceUsage> getResourceUsages() {
        return super.getResourceUsages();
    }

}










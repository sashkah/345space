import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Objects;

public class EarthEmployee {

    public String employeeId;
    private EarthStation earthStation;
    public ArrayList<Resource> blockedResources;

    public EarthEmployee() {
    }

    public EarthEmployee(String employeeIdIn, EarthStation earthStationIn) {
        this.employeeId = employeeIdIn;
        this.earthStation = earthStationIn;
        this.blockedResources = new ArrayList<Resource>();
    }

    public EarthEmployee(String employeeIdIn) {
        this.employeeId = employeeIdIn;
        this.earthStation = null;
        this.blockedResources = new ArrayList<Resource>();
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public EarthStation getEarthStation() {
        return earthStation;
    }

    public void setEarthStation(EarthStation earthStation) {
        this.earthStation = earthStation;
    }

    public ArrayList<Resource> getBlockedResources() {
        return blockedResources;
    }

    public void setBlockedResources(ArrayList<Resource> blockedResources) {
        this.blockedResources = blockedResources;
    }

    public String blockResource(String resourceName) throws IOException {
        Resource removeSource = new Resource();
        for (Resource resource : earthStation.getManagedStation().getResources()) {
            if (resource.getName().equalsIgnoreCase(resourceName)) {
                blockedResources.add(resource);
                removeSource = resource;
            }
        }
        earthStation.getManagedStation().getResources().remove(removeSource);
        return resourceName + " was blocked for usage.";
    }

    public String sendResource(String resourceName, double amount) {
        boolean resourceFound = false;

        for (Resource resources : earthStation.getManagedStation().getResources()) {
            if (resources.getName().equals(resourceName))
                resourceFound = true;
        }

        if (resourceFound) {
            if (amount >= 10)
                earthStation.getManagedStation().addResource(resourceName, amount);

            else return "Amount should be 10 or greater";
        } else return "Resource not found";


        return "Resource:" + resourceName + " Amount Sent:" + amount;
    }

    public void addNewResource(String resourceName, double amount) {
        Resource newResource = new Resource(resourceName, amount);
        earthStation.getManagedStation().addResource(newResource);
    }

    public void restrictUserFromCurrentAppliance(String id) {
        ArrayList<Astronaut> astronauts = earthStation.getManagedStation().getAstronauts();
        for (Astronaut astronaut : astronauts) {
            if (astronaut.getId().equals(id)) {
                if (astronaut.getCurrentAppliance() != null) {
                    astronaut.getCurrentAppliance().setInUse(false);
                    System.out.println("Astronaut: " + id + " been stop from using Appliance:" + astronaut.getCurrentAppliance().getId());
                }
            }
        }
    }

    /**
     * check if the limit is being reached for resources for each astronaut
     */
    public void checkForLimitReach() {
        ArrayList<Astronaut> astronauts = earthStation.getManagedStation().getAstronauts();
        for (Astronaut astronaut : astronauts) {
            for (Resource resource : earthStation.getManagedStation().getResources()) {
                if (astronaut.checkIfNearLimit(resource)) {
                    System.out.println("Astronaut: " + astronaut.getId() + " has reached or is reaching " + resource.getName() + " limit.\n");
                }
            }
        }
    }

    /**
     * Sets a limit for the astronaut
     *
     * @param id       astronaut ID
     * @param resource what you want to block
     * @param amount   how much you want to send
     */
    public void setLimitForAstronaut(String id, String resource, Double amount) {
        for (Astronaut astronaut : earthStation.getManagedStation().getAstronauts()) {
            if (id.equalsIgnoreCase(astronaut.getId())) {
                for (ResourceLimit resource1 : astronaut.getResourceLimits()) {
                    if (resource.equalsIgnoreCase(resource1.getResourceName())) {
                        resource1.setLimit(amount);
                    }
                }
            }
        }
    }


}

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Objects;

public class EarthEmployee {

    public String employeeId;
    private EarthStation earthStation;
    public ArrayList<Resource> blockedResources;

    public EarthEmployee(){}

    public EarthEmployee(String employeeIdIn, EarthStation earthStationIn){
        this.employeeId=employeeIdIn;
        this.earthStation=earthStationIn;
        this.blockedResources=new ArrayList<Resource>();
    }

    public EarthEmployee(String employeeIdIn){
        this.employeeId=employeeIdIn;
        this.earthStation=null;
        this.blockedResources=new ArrayList<Resource>();
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

    public String blockResource(String resourceName)throws IOException {
        Resource removeSource=new Resource();
        for (Resource resource : earthStation.getManagedStation().getResources()) {
            if (resource.getName().equalsIgnoreCase(resourceName)) {
                blockedResources.add(resource);
                removeSource = resource;
            }
        }
        earthStation.getManagedStation().getResources().remove(removeSource);
        return resourceName+" was blocked for usage.";
    }

    public String sendResource(String resourceName, double amount){
        boolean resourceFound=false;

        for (Resource resources: earthStation.getManagedStation().getResources()) {
            if (resources.getName().equals(resourceName))
                resourceFound = true;
        }

        if(resourceFound) {
            if (amount >= 10)
                earthStation.getManagedStation().addResource(resourceName, amount);

            else return "Amount should be 10 or greater";
        }

        else return "Resource not found";


        return "Resource:" + resourceName + " Amount Sent:" + amount;
    }

    public void addNewResource(String resourceName, double amount){
        Resource newResource=new Resource(resourceName,amount);
        earthStation.getManagedStation().addResource(newResource);
    }

    public void restrictUserFromCurrentAppliance(String id){
        ArrayList<Astronaut> astronauts=earthStation.getManagedStation().getAstronauts();
        for(Astronaut astronaut:astronauts){
            if(astronaut.getId().equals(id)){
                if(astronaut.getCurrentAppliance()!=null) {
                    astronaut.getCurrentAppliance().setInUse(false);
                    System.out.println("Astronaut: " +id +" been stop from using Appliance:" + astronaut.getCurrentAppliance().getId());
                }
            }
        }
    }

}

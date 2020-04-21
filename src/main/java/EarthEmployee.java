import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class EarthEmployee {

    public String employeeId;
    private EarthStation earthStation;
    private ArrayList<Resource> blockedResources;

    public EarthEmployee(String employeeIdIn, EarthStation earthStationIn){
        this.employeeId=employeeIdIn;
        this.earthStation=earthStationIn;
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

    public String blockResource(String resourceName)throws IOException {//TODO?: ADD CHECKS STATEMENTS FOR THE RESOURCE NAME ?
        ArrayList<Resource> resourcesInUse = earthStation.getManagedStation().getResources();
        for (Resource resource : resourcesInUse) {
            if (resource.getName().equals(resourceName)) {
                blockedResources.add(resource);
                earthStation.getManagedStation().getResources().remove(resource);
                System.out.println(resourcesInUse);
            }

        }

        return resourceName+" was blocked for usage.";
    }

    public void checkResources()throws IOException{
        ArrayList<Resource> resourcesInUse=earthStation.getManagedStation().getResources();
        for(Resource resource:resourcesInUse){
            if(resource.getAmount()<40.0){
                blockResource(resource.getName());
            }
        }

        }
        public void unBlockResource(String resourceName){
            ArrayList<Resource> resourcesInUse = earthStation.getManagedStation().getResources();
            for (Resource resource : resourcesInUse) {
                if (resource.getName().equals(resourceName)) {
                    blockedResources.remove(resource);
                    resourcesInUse.remove(resource);
                    System.out.println(resourceName);
                }

            }
    }
}

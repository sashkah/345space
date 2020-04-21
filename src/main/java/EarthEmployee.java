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

    public String blockResource(String resourceName) {
        ArrayList<Resource> resourcesInUse = earthStation.getManagedStation().getResources();
        for (Resource resource : resourcesInUse) {
            if (resource.getName() == resourceName) {
                blockedResources.add(resource);
                resourcesInUse.remove(resource);
            }

        }

        return resourceName+" was blocked for usage.";
    }

    public void checkResources(){
        ArrayList<Resource> resourcesInUse=earthStation.getManagedStation().getResources();
        for(Resource resource:resourcesInUse){
            if(resource.getAmount()<40.0){
                blockResource(resource.getName());
            }
        }

        }
}

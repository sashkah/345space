import java.lang.reflect.Array;
import java.util.ArrayList;

public class EarthEmployee {

    public String employeeId;
    private EarthStation earthStation;

    public EarthEmployee(String employeeIdIn, EarthStation earthStationIn){
        this.employeeId=employeeIdIn;
        this.earthStation=earthStationIn;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public void blockResource(String resourceName){
        ArrayList<Resource> resourcesInUse=earthStation.getManagedStation().getResources();
        for(Resource resource: resourcesInUse){
            System.out.println (resource);
        }
    }
    public void checkResources(){

    }

}

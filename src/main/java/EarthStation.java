import java.util.ArrayList;

public class EarthStation {
    private SpaceStation managedStation;
    private ArrayList<EarthEmployee> employees;

    public EarthStation(){

    }

    public EarthStation(SpaceStation stationToManage, ArrayList<EarthEmployee> employeesToAdd){
        managedStation = stationToManage;
        employees = employeesToAdd;
    }

    public ArrayList<EarthEmployee> getEmployees() {
        return employees;
    }

    public SpaceStation getManagedStation() {
        return managedStation;
    }

    public void setEmployees(ArrayList<EarthEmployee> employees) {
        this.employees = employees;
    }

    public void addEmployee(EarthEmployee employee){
        this.employees.add(employee);
    }

    public void setManagedStation(SpaceStation managedStation) {
        this.managedStation = managedStation;
    }

    public Payload sendResource(ArrayList<Resource> resourcesToSend, int startTime, int tripLength) {
        Payload resourcePackage = new Payload(startTime, tripLength, resourcesToSend);
        return resourcePackage;
    }

}

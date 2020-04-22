import java.util.ArrayList;

public class EarthStation {
    private SpaceStation managedStation;
    private ArrayList<User> employees;

    public EarthStation(){

    }

    public EarthStation(SpaceStation stationToManage, ArrayList<User> employeesToAdd){
        managedStation = stationToManage;
        employees = employeesToAdd;
    }

    public ArrayList<User> getEmployees() {
        return employees;
    }

    public SpaceStation getManagedStation() {
        return managedStation;
    }

    public void setEmployees(ArrayList<User> employees) {
        this.employees = employees;
    }

    public void addEmployee(User employee){
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

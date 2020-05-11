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
        return new Payload(startTime, tripLength, resourcesToSend);
    }

    public void viewResourceReport(){
        for(Astronaut employee:managedStation.getAstronauts()){
            System.out.println(employee.getId() + ":");
            System.out.println("\tDaily Resource Usage:");
            for(TotalResourceUsage resource:employee.getTotalResourceUsages()){
                System.out.println("\t\t" + resource.getResourceName() + ":" + resource.getTotalDailyUsage());
            }
            System.out.println("\tDaily Resource Limits:");
            for(ResourceLimit resource:employee.getResourceLimits()){
                System.out.println("\t\t" + resource.getResourceName() + ":" + resource.getLimit());
            }
        }
    }

    public void resetResourceUsage(String resourceName) {
        for(Astronaut astronaut:getManagedStation().getAstronauts()){
            for(TotalResourceUsage totalResourceUsage:astronaut.getTotalResourceUsages()){
                if(resourceName.equalsIgnoreCase(totalResourceUsage.getResourceName())){
                    totalResourceUsage.setTotalDailyUsage(0);
                }
            }
        }
    }
}

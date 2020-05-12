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

    public void setLimitForAstronaut(String id, String resource, Double amount) {
        for (Astronaut astronaut : this.getManagedStation().getAstronauts()) {
            if (id.equalsIgnoreCase(astronaut.getId())) {
                for (ResourceLimit resource1 : astronaut.getResourceLimits()) {
                    if (resource.equalsIgnoreCase(resource1.getResourceName())) {
                        resource1.setLimit(amount);
                        return;
                    }
                }
                astronaut.getResourceLimits().add(new ResourceLimit(resource, amount));
            }
        }
    }

    public void checkForLimitReach() {
        ArrayList<Astronaut> astronauts = this.getManagedStation().getAstronauts();
        for (Astronaut astronaut : astronauts) {
            for (Resource resource : this.getManagedStation().getResources()) {
                if (astronaut.checkIfNearLimit(resource)) {
                    System.out.println("Astronaut: " + astronaut.getId() + " has reached or is reaching " + resource.getName() + " limit.\n");
                }
            }
        }
    }

    public void restrictUserFromCurrentAppliance(String id) {
        ArrayList<Astronaut> astronauts = this.getManagedStation().getAstronauts();
        for (Astronaut astronaut : astronauts) {
            if (astronaut.getId().equals(id)) {
                if (astronaut.getCurrentAppliance() != null) {
                    astronaut.getCurrentAppliance().setInUse(false);
                    System.out.println("Astronaut: " + id + " been stop from using Appliance:" + astronaut.getCurrentAppliance().getId());
                }
            }
        }
    }
}

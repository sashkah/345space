import java.util.ArrayList;

public class Room {

    private String name;
    private double volume;
    private String type;
    ArrayList<ResourceUsage> passiveResourceUsages;
    private ArrayList<Appliance> appliances;
    private ArrayList<Astronaut> astronauts;

    public Room() {
    }

    public Room(String nameIn, double volumeIn, String typeIn, ArrayList<ResourceUsage> passiveResourceUsagesIn,
    ArrayList<Appliance> appliancesIn, ArrayList<Astronaut> astronautsIn) {
        this.name = nameIn;
        this.volume = volumeIn;
        this.type = typeIn;
        this.passiveResourceUsages = passiveResourceUsagesIn;
        this.appliances = appliancesIn;
        this.astronauts = astronautsIn;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getVolume() { return volume; }
    public void setVolume(double volume) { this.volume = volume; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public ArrayList<ResourceUsage> getPassiveResourceUsages() { return passiveResourceUsages; }
    public void setPassiveResourceUsages(ArrayList<ResourceUsage> passiveResourceUsages) {
        this.passiveResourceUsages = passiveResourceUsages;
    }

    public ArrayList<Appliance> getAppliances() { return appliances; }
    public void setAppliances(ArrayList<Appliance> appliances) { this.appliances = appliances; }

    public ArrayList<Astronaut> getAstronauts() { return astronauts; }
    public void setAstronauts(ArrayList<Astronaut> astronauts) { this.astronauts = astronauts; }

    public void addAppliance(Appliance applianceToAdd) {
        this.appliances.add(applianceToAdd);
    }
    public void removeAppliance(Appliance applianceToRemove) {
        this.appliances.remove(applianceToRemove);
    }

    public void addAstronaut(Astronaut astronautToAdd) {
        this.astronauts.add(astronautToAdd);
    }
    public void removeAstronaut(Astronaut astronautToRemove) {
        this.astronauts.remove(astronautToRemove);
    }
}

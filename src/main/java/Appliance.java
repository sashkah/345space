public class Appliance {

    public String name;
    String id;
    String resourceUsage;

    public Appliance(String nameIn,String idIn,String resourceUsageIn){
        this.name = nameIn;
        this.id = idIn;
        this.resourceUsage = resourceUsageIn;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getResourceUsage() {
        return resourceUsage;
    }

    public void setResourceUsage(String resourceUsage) {
        this.resourceUsage = resourceUsage;
    }

    public String toString() {
        return name + " " + id + " " + resourceUsage;
    }
}

public class Appliance extends User {

    public String name;
    public String resourceUsage;
    public boolean vitalResource;




    public Appliance(String nameIn, String resourceUsageIn, boolean vitalResourceIn){
        this.name = nameIn;
        this.resourceUsage= resourceUsageIn;
        this.vitalResource=vitalResourceIn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isVitalResource() {
        return vitalResource;
    }

    public void setVitalResource(boolean vitalResource) {
        this.vitalResource = vitalResource;
    }
    public void setResourceUsage(String resourceUsage) {
        this.resourceUsage = resourceUsage;
    }
}

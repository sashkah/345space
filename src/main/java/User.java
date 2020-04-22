import java.util.ArrayList;

public class User {
    private String id;
    private ArrayList<ResourceUsage> resourceUsages;
    private ArrayList<TotalResourceUsage> totalResourceUsages;

    public User() {
    }

    public User(String id){
        this.id = id;
        resourceUsages = new ArrayList<ResourceUsage>();
        totalResourceUsages = new ArrayList<TotalResourceUsage>();
    }

    public User(String id, ArrayList<ResourceUsage> resourceUsages, ArrayList<TotalResourceUsage> totalResourceUsages){
        this.id = id;
        this.resourceUsages = resourceUsages;
        this.totalResourceUsages = totalResourceUsages;
    }

    public String getId(){ return id; }
  
    public void setId(String id) {this.id = id; }

    public ArrayList<ResourceUsage> getResourceUsages() { return resourceUsages; }

    public void setResourceUsages(ArrayList<ResourceUsage> resourceUsages) { this.resourceUsages = resourceUsages; }

    public ArrayList<TotalResourceUsage> getTotalResourceUsages() { return totalResourceUsages; }

    public void setTotalResourceUsages(ArrayList<TotalResourceUsage> totalResourceUsages) { this.totalResourceUsages = totalResourceUsages; }

    public String toString() {
        return id + " " + resourceUsages + " " + totalResourceUsages;
    }

}

import java.util.ArrayList;

public class User {
    private String id;
    private ArrayList<ResourceUsage> resourceUsage;

    public User() {
    }

    public User(String id){
        this.id = id;
        resourceUsage = null;
    }
    
    public User(String id, ArrayList<ResourceUsage> resourceUsage){
        this.id = id;
        this.resourceUsage = resourceUsage;
    }

    public String getId(){
        return id;
    }
  
    public void setId(String id) {this.id = id; }

    public String toString() {
        return id + " " + resourceUsage;
    }

    public ArrayList<ResourceUsage> getResourceUsage() {
        return resourceUsage;
    }
}

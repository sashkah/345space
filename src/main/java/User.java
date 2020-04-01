import java.util.ArrayList;

public class User {
    String id;
    ArrayList<ResourceUsage> resourceUsage;

    public User() {
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
        return id;
    }

public ArrayList getResourceUsage() {
        return resourceUsage;
        }
}

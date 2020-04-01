import java.util.ArrayList;

public class User {
    String id;
    ArrayList<ResourceUsage> resourceUsage;

public User(String id, ArrayList<ResourceUsage> resourceUsage){
        this.id = id;
        this.resourceUsage = resourceUsage;
        }

public String getId(){
        return id;
        }

public ArrayList getResourceUsage() {
        //I think dealing with resource usage is either another card or not in our scope yet... but can be fixed if not true
        return resourceUsage;
        }
}

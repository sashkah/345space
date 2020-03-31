import java.util.Hashtable;

public class User {
    String id;
    //unique numerical ids for hashtable purposes - eg. duplicate names
    Hashtable resourceUsage; //For now this will be formatted like so (nested hashtables): <resourceName, <amount used, how often>>

    public User() {
    }

    public User(String id){
        this.id = id;
    }

    public String getId(){
        return id;
    }

    public void setId(String id) {this.id = id; }

    public Hashtable getResourceUsage() {
        //I think dealing with resource usage is either another card or not in our scope yet... but can be fixed if not true
        return resourceUsage;
    }
}

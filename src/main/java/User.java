import java.awt.*;
import java.util.*;
import java.util.List;

public class User {

    private String id;
    //HashMap<String, HashMap<Double, Integer>> resourceUsage; //For now this will be formatted like so (nested hashtables): <resourceName, <amount used, how often>>
    public HashMap<String, List<Double>> resourceUsage=new LinkedHashMap<>();
    public User(String id){
        this.id = id;
    }

    public String getId(){
        return id;
    }

    public void setResourceUsage(String resource, double amountUsed, double howOftenUsed){
        if(resourceUsage.get(resource)==null){
            resourceUsage.put(resource,Arrays.asList(amountUsed,howOftenUsed));
        }
        else if(amountUsed>100 || amountUsed<0){
            throw new IllegalArgumentException("invalid amount");
        }
        else if(howOftenUsed>10 || howOftenUsed<0){
            throw new IllegalArgumentException("invalid amount");
        }
        else{
            resourceUsage.replace(resource,Arrays.asList(amountUsed,howOftenUsed));
        }//TODO: GET LIST OF RESOURCES
    }

    public HashMap<String, List<Double>> getResourceUsage() {
        //I think dealing with resource usage is either another card or not in our scope yet... but can be fixed if not true
        return resourceUsage;
    }
}

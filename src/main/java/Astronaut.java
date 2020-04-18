import java.util.ArrayList;

public class Astronaut extends User{

    public String name;
    String totalResourceUsage;
    ArrayList<ResourceLimits> restrictedResources;








    //restrict resources, if blocked, limit is 0




    //resourceblocker class with two params, resource name, and amount that can be used per week
    //getters and setters for both of those
    //update astronatu class, whenever they use a reourcse,has to be make sure it's cumulative use for the week does no go past the limit


    public Astronaut(String nameIn, String totalResourceUsageIn){
        this.name = nameIn;
        this.totalResourceUsage = totalResourceUsageIn;
    }

    public void blockedResources(String resourceName){
        //TODO
        //come up with a list that has a resource and a cap each week
        //call a method that will change it
    }




    //totalResourceUsage, methods: blockedResources(resourceName), restrictedResources(resourceName)

}

/*
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
}

 */
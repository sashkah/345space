import java.util.ArrayList;

public class Appliance extends User {

    private boolean inUse;


    public Appliance() {}

    public Appliance(String idIn, ArrayList<ResourceUsage> resourceUsagesIn, ArrayList<TotalResourceUsage> totalResourceUsagesIn) {
        super(idIn, resourceUsagesIn, totalResourceUsagesIn);
        this.inUse = false;
    }

    public boolean getInUse() {
        return this.inUse;

    }
    public void setUsageLimit(){}

    public void setInUse(boolean inUseIn) {
        this.inUse = inUseIn;
        usingResource();
    }

    public void usingResource(){
        for(TotalResourceUsage totalResourceUsage:getTotalResourceUsages()){
            for(ResourceUsage resourceUsage:getResourceUsages()){
                if(totalResourceUsage.getResourceName().equals(resourceUsage.getResourceName())){
                    totalResourceUsage.incrementTotalUsage(resourceUsage.getUsagePerTimeframe());
                }
            }
        }

    }

    public boolean reachedResourceLimit(ArrayList<ResourceLimit> resourceLimits){

        return true;
    }

}

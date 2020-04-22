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
    }

}

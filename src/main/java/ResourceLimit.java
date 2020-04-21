public class ResourceLimit {
    private String resourceName;
    private double limit;


    public ResourceLimit(String resourceNameIn, double limitIn){
        this.resourceName = resourceNameIn;
        this.limit = limitIn;
    }

    public void setLimit(double newLimit){
        limit = newLimit;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getResourceName(){
        return resourceName;
    }

    public double getLimit() {
        return limit;
    }
}


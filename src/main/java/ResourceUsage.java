public class ResourceUsage {
    String resourceName;
    double usagePerTimeframe;
    int timeframe;

    public ResourceUsage(String resourceName, double usagePerTimeframe, int timeframe){
        this.resourceName = resourceName;
        this.usagePerTimeframe = usagePerTimeframe;
        this.timeframe = timeframe;
    }

    public String getResourceName() {
        return resourceName;
    }

    public double getUsagePerTimeframe() {
        return usagePerTimeframe;
    }

    public int getTimeframe() {
        return timeframe;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public void setUsagePerTimeframe(double usagePerTimeframe) {
        this.usagePerTimeframe = usagePerTimeframe;
    }

    public void setTimeframe(int timeframe) {
        this.timeframe = timeframe;
    }
}

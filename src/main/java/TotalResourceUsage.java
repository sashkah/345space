public class TotalResourceUsage {

    private String resourceName;
    private double totalUsage;
    private double totalDailyUsage;

    public TotalResourceUsage() {}

    public TotalResourceUsage(String resourceNameIn) {
        this.resourceName = resourceNameIn;
        this.totalUsage = 0;
        this.totalDailyUsage = 0;
    }

    public String getResourceName() { return resourceName; }

    public void setResourceName(String resourceName) { this.resourceName = resourceName; }


    public double getTotalUsage() { return totalUsage; }

    public void setTotalUsage(double totalUsage) { this.totalUsage = totalUsage; }

    public double getTotalDailyUsage() { return totalDailyUsage; }

    public void setTotalDailyUsage(double totalDailyUsage) { this.totalDailyUsage = totalDailyUsage; }

    public void incrementTotalUsage(double amount) {
        this.totalUsage += amount;
    }

    public void incrementTotalDailyUsage(double amount) {
        this.totalDailyUsage += amount;
    }

    public void resetTotalDailyUsage() {
        this.setTotalDailyUsage(0);
    }

    public String toString() {
        return resourceName + " " + totalUsage + " " + totalDailyUsage;
    }

}

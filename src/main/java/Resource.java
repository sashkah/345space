public class Resource {
    private String name;
    private double amount;

    public Resource() {
    }

    public Resource(String name, double amount){
        this.name = name;
        this.amount = amount;
    }

    public double getAmount() { return amount; }

    public String getName() {
        return name;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void depleteAmount(double amount) {
        this.amount -= amount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addAmount(double amount) {
        this.amount += amount;
    }

    public String toString() {
        return name + " " + amount;
    }
}

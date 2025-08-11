public class Destination {
    private String name;
    private String date;
    private double estimatedCost;

    public Destination(String name, String date, double estimatedCost) {
        this.name = name;
        this.date = date;
        this.estimatedCost = estimatedCost;
    }

    public String getName() { return name; }
    public String getDate() { return date; }
    public double getEstimatedCost() { return estimatedCost; }
}

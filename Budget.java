public class Budget {
    private double transportation;
    private double accommodation;
    private double food;
    private double activities;

    public Budget(double transportation, double accommodation, double food, double activities) {
        this.transportation = transportation;
        this.accommodation = accommodation;
        this.food = food;
        this.activities = activities;
    }

    public double getTotal() {
        return transportation + accommodation + food + activities;
    }
}

public abstract class Vehicle {
    private String model;
    private int year;

    public Vehicle(String model, int year) {
        this.model = model;
        this.year = year;
    }
    
    public abstract double calculateRentalPrice(int days);

    public String getDetails() {
        return "Vehicle: " + model + " (" + year + ")";
    }
}

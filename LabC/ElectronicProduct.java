public class ElectronicProduct implements Product {
    private String brand;
    private String model;
    private double price;

    public ElectronicProduct(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getDetails() {
        return "Product: Electronic - " + brand +" " + model + "\nPrice: $" + getPrice();
    }

}

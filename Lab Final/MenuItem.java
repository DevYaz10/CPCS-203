// Name: Yazeed Taifi
// ID: 2536850
// Section: IS2

public abstract class MenuItem {
    private String itemName;
    private double price;

    public MenuItem(String itemName, double price) {
        this.itemName = itemName;
        this.price = price;
    }

    public abstract double calculateFinalPrice(int quantity);

    public String getDetails() {
        return "Item: " + itemName + " (" + String.format("%.1f", price) + ")";
    }

    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    
}

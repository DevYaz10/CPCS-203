public class Items {
    private String itemName;
    private double unitPrice;
    private int quantity;
    
    public Items() {
    }

    public Items(String itemName, int quantity, double unitPrice) {
        this.itemName = itemName;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return String.format("%-20s %-20.1f %-20d %.1f", getItemName(), getUnitPrice(), getQuantity(), getUnitPrice() * getQuantity());
    }



}

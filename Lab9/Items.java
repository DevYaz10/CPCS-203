import java.util.Locale;

public class Items {
    private String itemName;
    private double unitPrice;
    private int quantity;

    public Items() {
        itemName = "";
        unitPrice = 0;
        quantity = 0;
    }

    public Items(String itemName, double unitPrice, int quantity) {
        this.itemName = itemName;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
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
        return String.format(Locale.US, "%-18s %-15.1f %-15d %-8.1f",
                itemName, unitPrice, quantity, unitPrice * quantity);
    }
}

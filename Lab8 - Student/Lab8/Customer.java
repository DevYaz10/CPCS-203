import java.util.*;

public class Customer {
    private String name = "";
    private double purchasesCost = 0;

    public Customer() {
    }

    public Customer(String name, double purchasesCost) {
        this.name = name;
        this.purchasesCost = purchasesCost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPurchasesCost() {
        return purchasesCost;
    }

    public void setPurchasesCost(double purchasesCost) {
        this.purchasesCost = purchasesCost;
    }
    
    public void ReadCustomerInfo(Scanner in) {
        System.out.println("Enter customer's name:");
        name = in.nextLine();
        System.out.println("Enter customer's Purchases Cost:");
        purchasesCost = in.nextDouble();
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " " + name + ", his/her purchases' Cost: " + purchasesCost;
    }
}

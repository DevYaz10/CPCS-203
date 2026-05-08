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

    public void ReadCustInfo(Scanner in) {
        System.out.print("Enter customer's name:");
        setName(in.nextLine());
        System.out.print("Enter customer's Purchases Cost:");
        setPurchasesCost(in.nextDouble());
        in.nextLine();
    }

    @Override
    public String toString() {
        return "New Customer name:" + getName() + ", his/her purchases' Cost:" + getPurchasesCost();
    }
}

import java.util.*;

public class Customer {
    private String name = "";
    private double purchasesCost;


    public Customer() {}

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
        
    }

    @Override
    public String toString() {
        return "New Customer name:" + getName() + ", his/her purchases's Cost:" + getPurchasesCost();
    }
}

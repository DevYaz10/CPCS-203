public class Regular extends Customer {
    private double discountRate = 0.05;

    public Regular() {}

    public Regular(String name, double purchasesCost) {
        super(name,purchasesCost);
    }
    

    @Override
    public double getPurchasesCost() {
        return super.getPurchasesCost() * (1 - discountRate);
    }
    
    @Override
    public String toString() {
        return "New Customer name:" + getName() + ", his/her purchases's Cost:" + super.getPurchasesCost() + ", cost after discount=" + getPurchasesCost();
    }


}

public class Regular extends Customer{
    private double discountRate = 0.05; 

    public Regular() {
    }

    public Regular(String name, double purchasesCost) {
        super(name, purchasesCost);
    }

    @Override
    public double getPurchasesCost() {
        return super.getPurchasesCost() * discountRate;
    }

    @Override
    public String toString() {
        return super.toString() + ", cost after discount = " + getPurchasesCost();
    }


}

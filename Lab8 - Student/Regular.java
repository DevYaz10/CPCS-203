public class Regular extends Customer {
    private final double discountRate = 0.05;

    public Regular() {
    }

    public Regular(String name, double purchasesCost) {
        super(name, purchasesCost);
    }

    @Override
    public double getPurchasesCost() {
        return super.getPurchasesCost() * (1 - discountRate);
    }

    @Override
    public String toString() {
        return "Regular Customer name:" + getName() + ", his/her purchases' Cost:" + super.getPurchasesCost()
                + ", cost after discount= " + getPurchasesCost();
    }

}

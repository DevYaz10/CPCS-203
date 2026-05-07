public class VIP extends Customer {
    private double discountRate = 0.1;
    private double GiftCertificate = 0;

    public VIP() {}

    public VIP(String name, double purchasesCost) {
        super(name,purchasesCost);
    }

    @Override
    public double getPurchasesCost() {
        return super.getPurchasesCost() * (1 - discountRate);
    }

    public double GiftCertificate() {
        return GiftCertificate;
    }

    @Override
    public String toString() {
        return "New Customer name:" + getName() + ", his/her purchases's Cost:" + super.getPurchasesCost() + ", cost after discount=" + GiftCertificate();
    }

}

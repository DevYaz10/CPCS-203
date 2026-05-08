public class VIP extends Customer {
    private final double discountRate = 0.1;
    private double giftCertificateValue = 0;

    public VIP() {
    }

    public VIP(String name, double purchasesCost) {
        super(name, purchasesCost);
    }

    @Override
    public double getPurchasesCost() {
        return super.getPurchasesCost() * (1 - discountRate);
    }

    public double GiftCertificate() {
        if (super.getPurchasesCost() > 1000) {
            giftCertificateValue = 100;
            System.out.println("Congratulation for the next customer. You Won 100.0 SR. gift certificate");
            return giftCertificateValue;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "VIP Customer name:" + getName() + ", his/her purchases' Cost:" + super.getPurchasesCost()
                + ", cost after discount= " + getPurchasesCost();
    }

}

public class VIP extends Customer {
    private double discountRate = 0.1; 
    private double GiftCertificateValue = 0;

    public VIP() {
    }

    public VIP(String name, double purchasesCost) {
        super(name, purchasesCost);
    }
    
    @Override
    public double getPurchasesCost() {
        return super.getPurchasesCost() * discountRate;
    }

    public double GiftCertificate() {
        if (super.getPurchasesCost() > 1000) {
            GiftCertificateValue = 100;
            return getPurchasesCost() - GiftCertificateValue;
        } else {
            return getPurchasesCost();
        }
    }

    @Override
    public String toString() {
        return "VIP " + super.toString() + ", cost after discount = " + GiftCertificate();
    }


}

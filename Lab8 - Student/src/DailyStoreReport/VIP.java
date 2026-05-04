package DailyStoreReport;

public class VIP extends Customer {

    private static final double discountRate = 0.1;
    private double GiftCertificateValue;

    public VIP()
    {
        super();
        GiftCertificateValue = 0;
    }

    public VIP(String name,double purchasesCost)
    {
        super(name,purchasesCost);
        GiftCertificateValue = 0;
    }



    public double GiftCertificate(){
        if(super.getPurchasesCost()>1000){
            GiftCertificateValue=100;
            System.out.println("Congratulation for the next customer. You Won 100.0 SR. gift certificate");
            return GiftCertificateValue;
        }
        return 0;
    }
    


    public double getPurchasesCost()
    {
        return super.getPurchasesCost()*(1-discountRate);
    }

    public String toString()
    {
        return super.toString().replaceFirst("Customer","VIP Customer")+" , cost after discount= "+getPurchasesCost();
    }
}

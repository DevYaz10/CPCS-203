package DailyStoreReport;


public class Regular extends Customer {
    private static final double discountRate = 0.05;

    public Regular()
    {
        super();
    }

    public Regular(String name,double purchasesCost)
    {
        super(name,purchasesCost);
    }


    public double getPurchasesCost()
    {
        return super.getPurchasesCost()*(1-discountRate);
    }

    public String toString()
    {
        return super.toString().replaceFirst("Customer","Regular Customer")+" , cost after discount= "+getPurchasesCost();
    }
}

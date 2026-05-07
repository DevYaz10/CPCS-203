package DailyStoreReport;


public class New extends Customer {

    public New() {}

    public New(String name,double purchasesCost)
    {
        super(name,purchasesCost);
    }
    public String toString(){
        return super.toString().replaceFirst("Customer","New Customer");
    }
    
}

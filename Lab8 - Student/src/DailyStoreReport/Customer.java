package DailyStoreReport;

import java.util.Scanner;

public class Customer {
    //Initialize the name with empty string  and the purchasesCost with zero
    private String name;
    private double purchasesCost;
    //------------------------------
    public Customer ()
    {
        name="";
        purchasesCost=0;
    }
    //-------------------------------
    public Customer (String name,double purchasesCost)
    {
        this.name=name;
        this.purchasesCost=purchasesCost;
    }
    //--------------------------------
    public String getName()
    {
        return name;
    }
    //--------------------------------
    public void setName(String n)
    {
        name=n;
    }
    //--------------------------------
    public double getPurchasesCost()
    {
        return purchasesCost;
    }
    //--------------------------------
    public void setPurchasesCost(double c)
    {
        purchasesCost=c;
    }
    //--------------------------------
    public void ReadCustInfo(Scanner in){
        name=in.next();
        purchasesCost=in.nextDouble();
    }
    //--------------------------------
    public String toString()
    {
        return "Customer name:"+ name+" , his/her purchases' Cost:"+purchasesCost;
    }        
}

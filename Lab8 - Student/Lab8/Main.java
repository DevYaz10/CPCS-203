import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter number of customers for the current day: ");
        int n = in.nextInt();
        in.nextLine();
        Customer[] customers = new Customer[n];

        System.out.println("--------------------------------------------------------------------");

        for (int i = 0; i < customers.length; i++) {
            Customer temp = new Customer();
            temp.ReadCustomerInfo(in);

            System.out.print("Enter customer's type (V for VIP, R for Regular and N for New):");
            String type = in.nextLine().toLowerCase();
            in.nextLine();


            if (type.equals("v")) {
                customers[i] = new VIP(temp.getName(), temp.getPurchasesCost());
            } else if (type.equals("r")) {
                customers[i] = new Regular(temp.getName(), temp.getPurchasesCost());
            } else {
                customers[i] = new New(temp.getName(), temp.getPurchasesCost());
            }

            System.out.println("--------------------------------------------------------------------");

        }
        
        double total = 0;
        
        for (Customer customer : customers) {
            if (customer instanceof VIP) {
                System.out.println("Congratulation for the next customer. You Won 100.0 SR. gift certificate");
                System.out.println(((VIP) customer).toString());
                total += ((VIP) customer).GiftCertificate();
            } else if (customer instanceof Regular) {
                System.out.println(((Regular) customer).toString());
                total += ((Regular) customer).getPurchasesCost();
            } else {
                System.out.println(((New) customer).toString());
                total += ((New) customer).getPurchasesCost();                
            }

        }
        
        System.out.println("--------------------------------------------------------------------");
        System.out.println("Current day income = " + total + "SR.");
        System.out.println("--------------------------------------------------------------------");
    }
}

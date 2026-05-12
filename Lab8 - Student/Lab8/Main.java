import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter number of customers for the current day: ");
        int n = in.nextInt();
        
        Customer[] customers = new Customer[n];

        System.out.println("--------------------------------------------------------------------");

        for (int i = 0; i < customers.length; i++) {
            Customer temp = new Customer();
            temp.ReadCustomerInfo(in);

            System.out.println("Enter customer's type (V for VIP, R for Regular and N for New):");
            String type = in.nextLine().toLowerCase();

            if (type == "v") {
                customers[i] = new VIP(temp.getName(), temp.getPurchasesCost());
            } else if (type == "r") {
                customers[i] = new Regular(temp.getName(), temp.getPurchasesCost());
            } else {
                customers[i] = new New(temp.getName(), temp.getPurchasesCost());
            } 
            
        }
    }
}

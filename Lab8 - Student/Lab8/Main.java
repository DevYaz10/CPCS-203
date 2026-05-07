import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter number of customers for the current day:");
        int custemrsNum = in.nextInt();
        System.out.println("----------------------------------------------");
        
        ArrayList<Customer> customerList = new ArrayList<>(custemrsNum);
        
        for (Customer customer : customerList) {
            System.out.println("Enter customer's name:");
            String name = in.nextLine();
            System.out.println("Enter customer's Purchases Cost:");
            double purchasesCost = in.nextDouble();
            System.out.println("Enter customer's type (V for VIP, R for Regular and N for New):");
            String type = in.nextLine().trim().toLowerCase();
            System.out.println("----------------------------------------------");


            switch (type) {
                case "v" -> customerList.add(new VIP(name, purchasesCost));
                case "r" -> customerList.add(new Regular(name, purchasesCost));
                default -> customerList.add(new New(name, purchasesCost));
            }

        }

        for(Customer customer: customerList) {
            switch (customer.type) {
                case "v" -> {
                    System.out.println(customer.GiftCertificate());
                    System.out.println(customer.toString());
                } 
                default -> System.out.println(customer.toString());   
            }
            
            
        }
        

    }
}

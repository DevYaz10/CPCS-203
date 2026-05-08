import java.util.*;

public class Main {

    private static final String DASH_LINE = "----------------------------------------------";

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {

            System.out.print("Enter number of customers for the current day:");
            int customersNum = in.nextInt();
            in.nextLine();
            System.out.println(DASH_LINE);

            ArrayList<Customer> customerList = new ArrayList<>(customersNum);

            for (int i = 0; i < customersNum; i++) {
                Customer tempCustomer = new Customer();
                tempCustomer.ReadCustInfo(in);
                System.out.print("Enter customer's type (V for VIP, R for Regular and N for New):");
                String type = in.nextLine().trim().toLowerCase();
                System.out.println(DASH_LINE);

                switch (type) {
                    case "v" -> customerList.add(new VIP(tempCustomer.getName(), tempCustomer.getPurchasesCost()));
                    case "r" -> customerList.add(new Regular(tempCustomer.getName(), tempCustomer.getPurchasesCost()));
                    default -> customerList.add(new New(tempCustomer.getName(), tempCustomer.getPurchasesCost()));
                }

            }
            double totalIncome = 0;
            for (Customer customer : customerList) {
                if (customer instanceof VIP vipCustomer) {
                    vipCustomer.GiftCertificate();
                }
                if (customer != null) {
                    System.out.println(customer);
                    totalIncome += customer.getPurchasesCost();
                }
            }

            System.out.println(DASH_LINE);
            System.out.printf("Current day income = %.1fSR.%n", totalIncome);
            System.out.println(DASH_LINE);
        }
    }
}

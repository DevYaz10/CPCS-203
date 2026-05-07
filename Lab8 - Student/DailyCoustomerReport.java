package DailyStoreReport;

import java.util.Scanner;

public class DailyCoustomerReport {

    private static final String DASH_LINE = "---------------------------------------------------------";

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter number of customers for the current day:");
        System.out.flush();
        int n = input.nextInt();
        System.out.println(DASH_LINE);
        Customer[] customers = new Customer[n];

        for (int i = 0; i < n; i++) {
            Customer temp = new Customer();
            System.out.print("Enter customer's name:");
            System.out.flush();
            temp.setName(input.next());
            System.out.print("Enter customer's Purchases Cost:");
            System.out.flush();
            temp.setPurchasesCost(input.nextDouble());
            System.out.print("Enter customer's type (V for VIP, R for Regular and N for New):");
            System.out.flush();
            String typ = input.next();
            char t = typ.charAt(0);
            Customer c;
            if (t == 'v' || t == 'V')
                c = new VIP(temp.getName(), temp.getPurchasesCost());
            else if (t == 'r' || t == 'R')
                c = new Regular(temp.getName(), temp.getPurchasesCost());
            else
                c = new New(temp.getName(), temp.getPurchasesCost());
            customers[i] = c;
            System.out.println(DASH_LINE);
        }

        double income = 0;
        for (Customer cust : customers) {
            if (cust instanceof VIP)
                ((VIP) cust).GiftCertificate();
            System.out.println(cust);
            income += cust.getPurchasesCost();
        }

        System.out.println(DASH_LINE);
        System.out.println("Current day income = " + income + "SR.");
        System.out.println(DASH_LINE);

        input.close();
    }

}

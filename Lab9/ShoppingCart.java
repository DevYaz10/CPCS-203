import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class ShoppingCart {

    private static final String DASH_ROW = "-".repeat(70);

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Items> cart = new ArrayList<>();

        String cont = "y";
        while (cont.equalsIgnoreCase("y")) {
            System.out.print("Enter the name of the item: ");
            System.out.flush();
            String itemName = input.nextLine();

            System.out.print("Enter the unit price: ");
            System.out.flush();
            double unitPrice = Double.parseDouble(input.nextLine().trim());

            System.out.print("Enter the quantity: ");
            System.out.flush();
            int quantity = Integer.parseInt(input.nextLine().trim());

            cart.add(new Items(itemName.trim(), unitPrice, quantity));

            System.out.print("Continue shopping (y/n)? ");
            System.out.flush();
            cont = input.nextLine().trim();
        }

        System.out.println();
        System.out.println("Final Shopping Cart totals");
        System.out.println(DASH_ROW);
        System.out.printf(Locale.US, "%-18s %-15s %-15s %s%n",
                "ItemName", "Unit price", "Quantity", "price * quantity");
        double totalAmount = 0;
        for (Items item : cart) {
            double linePrice = item.getUnitPrice() * item.getQuantity();
            totalAmount += linePrice;
            System.out.println(item.toString());
        }
        System.out.println("Total amount in the cart " + totalAmount + " SR");

        input.close();
    }
}

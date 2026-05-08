import java.util.*;

public class ShoppingCart {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        ArrayList<Items> cart = new ArrayList<>();

        boolean isContinue = true;
        while (isContinue) {
            System.out.print("Enter the name of the item: ");
            String name = in.nextLine();

            System.out.print("Enter the unit price: ");
            double unitP = in.nextDouble();

            System.out.print("Enter the quantity: ");
            int quantity = in.nextInt();

            cart.add(new Items(name, unitP, quantity));

            System.out.print("Continue shopping? (y/n)? ");
            if (in.next().equalsIgnoreCase("n")) {
                isContinue = false;
            }
            in.nextLine();
        }

        double total = 0;
        for (Items item : cart) {
            total += item.getUnitPrice() * item.getQuantity();
        }

        System.out.printf(
                "%nFinal Shopping Cart Totals%n------------------------------------------------------------------%n");
        System.out.printf("%-15s %-12s %-10s %-18s%n", "ItemName", "Unit price", "Quantity", "price * quantity");
        for (Items items : cart) {
            System.out.print(items.toString());
        }
        System.out.printf("Total amount in the cart %.1f", total);

    }
}

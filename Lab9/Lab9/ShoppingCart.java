import java.util.*;

public class ShoppingCart {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Items> cart = new ArrayList<>();

        boolean c = true;
        while (c) {
            System.out.print(" Enter the name of the item: ");
            String name = in.nextLine();

            System.out.print(" Enter the unit price: ");
            double price = Double.parseDouble(in.nextLine());

            System.out.print(" Enter the quantity: ");
            int quantity = Integer.parseInt(in.nextLine());

            cart.add(new Items(name, quantity, price));

            System.out.print("Continue shopping (y/n)? ");
            if (in.nextLine().trim().equalsIgnoreCase("n")) {
                break;
            }
        }

        System.out.println();
        System.out.println("Final Shopping Cart totals");
        System.out.println("--------------------------------------------------------------------");

        System.out.println("ItemName             Unit Price          Quantity             Price * Quantity");

        double total = 0;
        for (Items item : cart) {
            System.out.println(item.toString());
            total += item.getQuantity() * item.getUnitPrice();
        }

        System.out.println("Total amount in the cart " + total + " SR");

    }
}

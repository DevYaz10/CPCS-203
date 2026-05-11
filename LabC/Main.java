public class Main {
    public static void main(String[] args) {
        Marketplace market = new Marketplace("QuickBuy", "www.quickbuy.com");
        BookProduct b = new BookProduct("Joshua Bloch", 45.99, "Effective Java");
        ElectronicProduct e = new ElectronicProduct("Samsung Galaxy", "S21", 799.99);


        System.out.println(market.displayInfo() + "\n");

        System.out.println(b.getDetails() + "\n");
        System.out.println(e.getDetails() + "\n");

        Product[] products = {b, e};

        double total = 0;

        for (Product p  : products) {
            total += p.getPrice();
        }

        System.out.println("Total Price: $" + total);


    }
}

// Name: Yazeed Taifi
// ID: 2536850
// Section: IS2

public class DrinkItem extends MenuItem implements Orderable {
    private String size;

    public DrinkItem(String itemName, double price, String size) {
        super(itemName, price);
        this.size = size;
    }

    @Override
    public double calculateFinalPrice(int quantity) {
        switch (size) {
            case "Large":
                setPrice((super.getPrice() + 5) * quantity);
                break;
            case "Medium":
                setPrice((super.getPrice() + 3) * quantity);
                break;
            default:
                setPrice(super.getPrice() * quantity);
                break;
        }
        return getPrice();
    }


    @Override
    public void printBill(String customerName, int quantity) {
        System.out.println(
            "Drink Bill" + "\n" + 
            "Customer: " + customerName + "\n" +
            getDetails() + "\n" +
            "Quantity: " + quantity + "\n" +
            "Final Price: " + String.format("%.1f", calculateFinalPrice(quantity))
        );
        
    }

}

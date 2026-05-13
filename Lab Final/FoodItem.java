// Name: Yazeed Taifi
// ID: 2536850
// Section: IS2

public class FoodItem extends MenuItem implements Orderable {
    private boolean isSpicy;

    public FoodItem(String itemName, double price, boolean isSpicy) {
        super(itemName, price);
        this.isSpicy = isSpicy;
    }

    @Override
    public double calculateFinalPrice(int quantity) {
        if (isSpicy) {
            setPrice(super.getPrice() * quantity + 5);
        } else {
            setPrice(super.getPrice() * quantity);
        }
        
        return getPrice();
    }

    @Override
    public void printBill(String customerName, int quantity) {
        System.out.println(
            "Food Bill" + "\n" + 
            "Customer: " + customerName + "\n" +
            getDetails() + "\n" +
            "Quantity: " + quantity + "\n" +
            "Final Price: " + String.format("%.1f", calculateFinalPrice(quantity))
        );
        
    }
    
    

    
    
}

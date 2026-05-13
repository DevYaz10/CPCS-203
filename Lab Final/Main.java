// Name: Yazeed Taifi
// ID: 2536850
// Section: IS2

public class Main {
    public static void main(String[] args) {
        FoodItem food = new FoodItem("Burger", 25, true);
        DrinkItem drink = new DrinkItem("Juice", 10, "Medium");

        food.printBill("Ahmed", 2);
        System.out.println();
        drink.printBill("Sara", 3);
    }
}
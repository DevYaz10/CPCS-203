public class Car extends Vehicle implements Rentable {
    private String name;
    private int age;
    private boolean luxury;

    public Car(int age, boolean luxury, String name, String model, int year) {
        super(model, year);
        this.age = age;
        this.luxury = luxury;
        this.name = name;
    }
    
    @Override
    public double calculateRentalPrice(int days) {
        if (luxury) {
            return days * 100;
        } else {
            return days * 50;
        }
    }

    @Override
    public void printRentalAgreement(String custormerName, int days) {
        System.out.println("Rental Agreement");
        System.out.println("Customer: " + name);
        System.out.println(super.getDetails());
        System.out.println("Rental Price: $" + calculateRentalPrice(days));
    }

    
}

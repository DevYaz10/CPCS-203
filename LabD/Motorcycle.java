public class Motorcycle extends Vehicle implements Rentable {
    private String name;
    private int age;
    private int engineCapacity;

    public Motorcycle(int age, int engineCapacity, String name, String model, int year) {
        super(model, year);
        this.age = age;
        this.engineCapacity = engineCapacity;
        this.name = name;
    }

    @Override
    public double calculateRentalPrice(int days) {
        return 30 * days + engineCapacity * 0.1;
    }

    @Override
    public void printRentalAgreement(String custormerName, int days) {
        System.out.println("Rental Agreement");
        System.out.println("Customer: " + custormerName);
        System.out.println(super.getDetails());
        System.out.println("Rental Price: $" + calculateRentalPrice(days));
    }

}

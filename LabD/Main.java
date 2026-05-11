public class Main {
    public static void main(String[] args) {
        RentalCompany company = new RentalCompany("Downtown", "Speedy Rentals");

        company.displayCompanyInfo();
        System.out.println();

        Car car = new Car(18, true, "Toyota", "Camry", 2020);
        Motorcycle bike = new Motorcycle(18, 3000, "Yamaha", "MT-07", 2022);

        car.printRentalAgreement("John Doe", 3);
        System.out.println();
        bike.printRentalAgreement("Alice Smith", 3);

    }
}

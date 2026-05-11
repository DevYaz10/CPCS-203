public class RentalCompany {
    private String name;
    private String location;

    public RentalCompany(String location, String name) {
        this.location = location;
        this.name = name;
    }

    public void displayCompanyInfo() {
        System.out.println("Company: " + name + "\nLocation: " + location);
    }
}

public class Clerk extends Staff {
    private String officeLocation;

    public Clerk(String officeLocation, String id, String name) {
        super(id, name);
        this.officeLocation = officeLocation;
    }

    public String getOfficeLocation() {
        return officeLocation;
    }

    @Override
    public String work() {
        return "Managing school administration tasks";
    }

}

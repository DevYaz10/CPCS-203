public class Bus extends basicVehicle {
    private String driverName;

    public Bus(int noOfwheels, int noOfSeats, int noOfDoors, String type, String driverName) {
        super(noOfwheels, noOfSeats, noOfDoors, type);
        this.driverName = driverName;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverFname, String driverLname) {
        driverName = driverFname + " " + driverLname;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("%nDriver: %s", getDriverName());
    }
}

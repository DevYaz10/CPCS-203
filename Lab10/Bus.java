public class Bus extends basicVehicle {

    private String driverName;

    public Bus(int noOfWheels, int NoOfSeats, int noOfDoors, String type, String driverFName,
            String driverLName) {
        super(noOfWheels, NoOfSeats, noOfDoors, type);
        setDriverName(driverFName, driverLName);
    }

    private void setDriverName(String driverFName, String driverLName) {
        driverName = driverFName.toUpperCase() + " " + driverLName.substring(0, 1).toUpperCase()
                + driverLName.substring(1).toLowerCase();
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    @Override
    public String toString() {
        return super.toString() + "\nDriver : " + driverName;
    }
}

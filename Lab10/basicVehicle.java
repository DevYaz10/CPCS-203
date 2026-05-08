public abstract class basicVehicle implements Vehicle {
    private int noOfwheels;
    private int noOfSeats;
    private int noOfDoors;
    private String type;

    public basicVehicle(int noOfwheels, int noOfSeats, int noOfDoors, String type) {
        this.noOfwheels = noOfwheels;
        this.noOfSeats = noOfSeats;
        this.noOfDoors = noOfDoors;
        this.type = type;
    }

    public int getNumberOFDoors() {
        return noOfDoors;
    }

    @Override
    public int getNumberOfSeats() {
        return noOfSeats;
    }

    @Override
    public int getNumberOfWheels() {
        return noOfwheels;
    }

    @Override
    public String getVehicleType() {
        return type;
    }

    @Override
    public String toString() {
        return String.format("Type: %s%n # Of Wheels: %d%n # Of Seats: %d%n # Of Doors: %d", getVehicleType(), getNumberOfWheels(), getNumberOfSeats(), getNumberOFDoors());
    }
}

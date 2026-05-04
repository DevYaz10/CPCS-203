public abstract class basicVehicle implements Vehicle {

    private int noOfWheels;
    private int NoOfSeats;
    private int noOfDoors;
    private String type;

    public basicVehicle(int noOfWheels, int NoOfSeats, int noOfDoors, String type) {
        this.noOfWheels = noOfWheels;
        this.NoOfSeats = NoOfSeats;
        this.noOfDoors = noOfDoors;
        this.type = type;
    }

    public int getNumberOfDoors() {
        return noOfDoors;
    }

    @Override
    public int getNumberOfSeats() {
        return NoOfSeats;
    }

    @Override
    public int getNumberOfWheels() {
        return noOfWheels;
    }

    @Override
    public String getVehicleType() {
        return type;
    }

    @Override
    public String toString() {
        return "Type: " + type + "\n"
                + "# Of Wheels : " + noOfWheels + "\n"
                + "# of Seats : " + NoOfSeats + "\n"
                + "# of Doors : " + noOfDoors;
    }
}

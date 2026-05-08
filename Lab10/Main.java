public class Main {
    public static void main(String[] args) {
        basicVehicle[] vehicleList = {
                new Car(4, 5, 2, "Car"),
                new Bus(35, 6, 4, "Bus", "BOB Smith")
        };
        
        for (basicVehicle basicVehicle : vehicleList) {
            System.out.println(basicVehicle.toString());
        }
    }
}

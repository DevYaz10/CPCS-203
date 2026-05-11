public class Main {
    public static void main(String[] args) {
        Zoo zoo = new Zoo("Safari Park", "Nairobi");
        Animal lion = new Lion("Large", 5, "Leo the Lion");
        Animal parrot = new Parrot(true, 2, "Polly the Parrot");

        
        System.out.println(zoo.displaly_info() + "\n");

        System.out.println(lion.getInfo() + "\n");
        System.out.println(parrot.getInfo());
    }
}

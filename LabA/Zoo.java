public class Zoo {
    private String name;
    private String location;

    public Zoo() {
    }
    
    public Zoo(String name, String location) {
        this.name = name;
        this.location = location;
    }

    
    public String displaly_info() {
        return "Zoo Name:" + name + "\nLocation: " + location;
    }


    

}

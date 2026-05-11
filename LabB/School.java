public class School {
    private String name;
    private String city;

    public School(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public String showInfo() {
        return "School: " + name + ", City: " + city;
    }
}

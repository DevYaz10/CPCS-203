package Lab52;

public class Person {

    private String fName;
    private String lName;

    public Person(String fName, String lName) {
        this.fName = fName;
        this.lName = lName;
    }

    // Setters and getters
    public String getFName() {
        return fName;
    }

    public void setFName(String fName) {
        this.fName = fName;
    }

    public String getLName() {
        return lName;
    }

    public void setLName(String lName) {
        this.lName = lName;
    }


    @Override
    public String toString() {
        return fName + " " + lName; // simple one for now
        //TODO: returns a string description for the Person object.
    }
    

}
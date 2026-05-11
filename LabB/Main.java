public class Main {
    public static void main(String[] args) {
        School school = new School("Greenfield High", "Springfield");
        Staff teacher = new Teacher("Mathematics", "T101", "Mr. John");
        Staff clerk = new Clerk("nowhere", "C202", "Ms. Anna");

        System.out.println(school.showInfo() + "\n");

        System.out.println(teacher.getDetails() + "\n");
        System.out.println(clerk.getDetails());
    }
}

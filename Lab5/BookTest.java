import java.util.Scanner;

public class BookTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("the total number of books: " + Book.getCount());
        System.out.println("#################################");

        Book b1 = new Book("java", "Ali", "Ahmed", 2008);

        System.out.println("Enter book title:");
        String title = input.nextLine();

        System.out.println("Enter first and last name of author:");
        String fName = input.next();
        String lName = input.next();

        System.out.println("Enter year:");
        int year = input.nextInt();

        Book b2 = new Book(title, fName, lName, year);

        Person p = new Person("Mohammed", "Ali");
        Book b3 = new Book("java2", p, 2018);

        System.out.println("##########books information##########");
        System.out.println(b1.toString());
        System.out.println(b2.toString());
        System.out.println(b3.toString());
        System.out.println("#################################");

        System.out.println("the total number of books: " + Book.getCount());

        input.close();
    }
}
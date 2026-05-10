

import java.util.*;

public class BookTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("the total number of books: " + Book.getCount());
        System.out.println("##############################################");
        
        
        
        System.out.println("Enter Book Title: ");
        String title = in.nextLine();
        System.out.println("Enter First Name and Last Name of the author: ");
        String fName = in.next();
        String lName = in.nextLine();
        System.out.println("Enter Year: ");
        int year = in.nextInt();
        
        Book[] bookList = {
            new Book("java", "Ali", "Ahmed", 2008),
            new Book(new Person(fName, lName), year, title),
            new Book(new Person("Mohammed", "Ali"), 2018, "java2")
        };
        
        
        System.out.println("################Book Information##############");
        
        for (Book book : bookList) {
            System.out.println(book.toString());
        }
        
        
        System.out.println("##############################################");
        System.out.println("the total number of books: " + Book.getCount());


    }
}

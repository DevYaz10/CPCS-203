package Lab52;
import java.util.*;

public class BookTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("the total number of books: " + Book.getCount());
        System.out.println("##################################");
        
        Book b1 = new Book("java", "Ali", "Ahmed", 2008);
        Book b2 = new Book(in.next(), new Person(in.next(), in.next()), in.nextInt());
        Book b3 = new Book("java2",new Person( "Ali", "Ahmed"), 2008);
        
        
        System.out.println("#########books information########");
        System.out.println(b1.toString());
        System.out.println(b2.toString());
        System.out.println(b3.toString());
        System.out.println("##################################");
        System.out.println("total number of books: " + Book.getCount());
        

    }


}

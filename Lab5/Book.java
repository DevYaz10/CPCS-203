// Book.java
public class Book {
    private String title;
    private Person author;
    private int publishYear;
    private static int count = 0;

    public Book(String title, String fName, String lName, int publishYear) {
        this.title = title;
        this.author = new Person(fName, lName);
        this.publishYear = publishYear;
        count++;
    }

    public Book(String title, Person author, int publishYear) {
        this.title = title;
        this.author = author;
        this.publishYear = publishYear;
        count++;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Person getAuthor() {
        return author;
    }

    public void setAuthor(Person author) {
        this.author = author;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }

    public static int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return title + ", " + author.toString() + ", " + publishYear;
    }
}
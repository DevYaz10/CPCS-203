

public class Book {

    private String title;
    private Person author;
    private int publishYear;
    private static int count = 0;
    
    public Book(Person author, int publishYear, String title) {
        this.author = author;
        this.publishYear = publishYear;
        this.title = title;
        count++;
    }
    
    public Book(String title, String fNanme, String lName, int publishYear) {
        this.title = title;
        this.author = new Person(fNanme, lName);
        this.publishYear = publishYear;
        count++;
    }

    public String getTitle() {
        return title;
    }
    
    public Person getAuthor() {
        return author;
    }
    
    public int getPublishYear() {
        return publishYear;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public void setAuthor(Person author) {
        this.author = author;
    }
    
    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }
    
    
    @Override
    public String toString() {
        return title + ", " + author.toString() + ", " + publishYear;
    }
    
    
    public static int getCount() {
        return count;
    }
    

}

public class BookProduct implements Product {
    private String title;
    private String author;
    private double price;

    public BookProduct(String author, double price, String title) {
        this.author = author;
        this.price = price;
        this.title = title;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getDetails() {
        return "Product: Book - " + title + " by " + author + "\nPrice: $" + getPrice();
    }
}

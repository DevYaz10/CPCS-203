public class Rectangle {
    private double width = 1;
    private double height = 1;

    public Rectangle() {}

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }


    public double getArea() {
        return width * height;
    }

    public double getPerimeter() {
        return 2 * (width + height);
    }

    
    @Override
    public String toString() {
        return String.format("Width = %.1f%nHeight = %.1f%nArea = %.1f%nPerimeter = %.1f", width, height, getArea(), getPerimeter());
    }

}

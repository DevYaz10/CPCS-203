public class Cylinder extends Circle {
    private double height = 1.0;

    public Cylinder() {
    }

    public Cylinder(double radius, double height) {
        super(radius);
        this.height = height;
    }

    public Cylinder(double radius, double height, String color) {
        super(radius, color);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getBaseArea() {
        return super.getArea();
    }

    @Override
    public double getArea() {
        return 2 * (super.getArea()) + 2 * Math.PI * super.getRadius() * height;
    }

    public double getVolume() {
        return getBaseArea() * height;
    }

    @Override
    public String toString() {
        return super.toString() + ", " + height + ", base area=" + super.getArea() +"\n" +  
        "Surface area" + getArea() + ", volume" + getVolume();
    }

    

    

    
}

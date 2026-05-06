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
        return 2 * (super.pie * super.getRadius() * height + getBaseArea());
    }

    public double getVolume() {
        return getBaseArea() * height;
    }

    @Override
    public String toString() {
        return String.format(
            "Base   %s, height=%.1f, base area=%.14f%nSurface area=%.14f, volume=%.14f", 
            super.toString(), getHeight(), getBaseArea(), getArea(), getVolume()
        );
    }

}

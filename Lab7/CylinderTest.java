import java.util.*;
public class CylinderTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);        
        
        System.out.println("***Cylinder***");
        System.out.println("--------------");
        
        
        System.out.print("please enter the cylinder's base radius: ");
        double radius = in.nextDouble();
        System.out.println("--------------");
        
        System.out.print("please enter the cylinder's height");
        double height = in.nextDouble();
        System.out.println("--------------");

        Cylinder c = new Cylinder(radius, height);

        System.out.println("Cylinder information:");
        System.out.println(c.toString());

    }
}

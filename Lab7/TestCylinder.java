import java.util.Scanner;

public class TestCylinder {
   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);

      System.out.println("***Cylinder***");
      System.out.println("----------");
      System.out.print("Please, enter the cylinder's base radius:");
      double radius = input.nextDouble();
      System.out.println("----------");
      System.out.print("Please, enter the cylinder's height:");
      double height = input.nextDouble();
      System.out.println("----------");

      Cylinder cylinder = new Cylinder(radius, height);

      System.out.println("Cylinder information:");
      System.out.println(cylinder);
      System.out.println("Surface area=" + cylinder.getArea() + " , volume=" + cylinder.getVolume());

      input.close();
   }
}

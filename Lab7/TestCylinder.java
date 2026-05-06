import java.util.*;

public class TestCylinder {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Cylinder cy = new Cylinder();


        System.out.printf("***Cylinder***%n--------------%nPlease, enter the cylinder's base radius:");
        cy.setRadius(in.nextDouble());

        System.out.printf("--------------%nPlease, enter the cylinder's height:");
        cy.setHeight(in.nextDouble());
        
        System.out.printf("--------------%nCylinder information:%n%s", cy.toString());

    }
}

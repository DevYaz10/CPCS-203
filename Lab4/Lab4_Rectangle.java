
public class Lab4_Rectangle {

    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(4.0, 40.0);
        Rectangle r2 = new Rectangle(3.5, 35.9);
        
        System.out.println("Rectangle No. 1");
         
        System.out.println(r1.toString());
        System.out.println();
        System.out.println();
        
        System.out.println("Rectangle No. 2");
        System.out.println(r2.toString());
    }

    static class Rectangle {
        Double width = 1.0;
        Double height = 1.0;

        Rectangle() {
            Double rectangle = 1.0;
        }

        Rectangle(Double width, Double height) {
            this.width = width;
            this.height = height;
        }



        // Setters and Getters
        void setHeight(Double n) {
            height = n;
        }

        
        Double getHeight() {
            return height;
        }

        
        void setWidth(Double n) {
            width = n;
        }

        
        Double getWidth() {
            return width;
        }




        Double getArea(Double width, Double height) {
            return width * height;
        }
        
        Double getPerimeter(Double width, Double height) {
            return 2 * (width + height);
        }


        @Override
        public String toString() {
            double area = width * height;
            double perimeter = 2 * (width + height);
            return "width = " + width
                    + "\nHight = " + height
                    + "\nArea = " + area
                    + "\nPerimeter = " + perimeter;
        }

        
    }
}
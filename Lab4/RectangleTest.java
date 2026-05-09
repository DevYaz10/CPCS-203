public class RectangleTest {
    public static void main(String[] args) {
        Rectangle[] rectangleList = {
                new Rectangle(4, 40),
                new Rectangle(3.5, 35.9)
        };

        for (int i = 0; i < rectangleList.length; i++) {
            System.out.println("Rectangle No. " + (i + 1));
            System.out.println(rectangleList[i].toString());
        }
    }
}

public class RationalArray {
    public static void main(String[] args) {
        RationalNumber[] list1 = {
                new RationalNumber(3, 4),
                new RationalNumber(1, 3),
                new RationalNumber(1, 2)
        };

        RationalNumber[] list2 = {
                new RationalNumber(2, 5),
                new RationalNumber(1, 4),
                new RationalNumber(3, 5)
        };

        RationalNumber[] list3 = new RationalNumber[3];
        RationalNumber[] list4 = new RationalNumber[3];

        for (int i = 0; i < list3.length; i++) {
            list3[i] = list1[i].add(list2[i]);
        }

        for (int i = 0; i < list3.length; i++) {
            list4[i] = list1[i].multiply(list2[i]);
        }

        System.out.println("LIST1     LIST2     ADD       MULTIPLY");
        for (int i = 0; i < 3; i++) {
            System.out.printf("%-10s%-10s%-10s%s%n",
                    list1[i], list2[i], list3[i], list4[i]);
        }
    }
}

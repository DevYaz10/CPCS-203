public class RationalArray {

    public static void main(String[] args)
    {
        RationalNumber[] list1 = new RationalNumber[3];
        RationalNumber[] list2 = new RationalNumber[3];
        RationalNumber[] list3 = new RationalNumber[3];
        RationalNumber[] list4 = new RationalNumber[3];

        list1[0] = new RationalNumber(3, 4);
        list1[1] = new RationalNumber(1, 3);
        list1[2] = new RationalNumber(1, 2);

        list2[0] = new RationalNumber(2, 5);
        list2[1] = new RationalNumber(1, 4);
        list2[2] = new RationalNumber(3, 5);

        for (int i = 0; i < 3; i++)
        {
            list3[i] = list1[i].add(list2[i]);
            list4[i] = list1[i].multiply(list2[i]);
        }

        System.out.println("LIST1\tLIST2\tADD\tMULTIPLY");

        for (int i = 0; i < 3; i++)
        {
            System.out.println(list1[i] + "\t" + list2[i] + "\t" + list3[i] + "\t" + list4[i]);
        }
    }
}
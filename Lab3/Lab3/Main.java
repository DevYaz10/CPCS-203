import java.io.*;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        File inputFile = new File("file1.txt");
        File outputFile = new File("file2.txt");
        File inputFile1 = new File("file2.txt");

        try (Scanner in = new Scanner(inputFile); PrintWriter out = new PrintWriter(outputFile);) {
            while (in.hasNext()) {
                String line = in.nextLine().replaceAll("\\D", " ");
                out.println(line);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        try (Scanner in = new Scanner(inputFile1);) {
            while (in.hasNext()) {
                int number = in.nextInt();
                if (isPrime(number)) {
                    System.out.print(number + " ");
                }
            }
        } catch (Exception e) {
            // TODO: handle exception
        }

    }

    public static boolean isPrime(int n) {
        if (n <= 1)
            return false; // 0 and 1 are not prime

        // Loop from 2 up to the square root of n
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false; // Found a divisor, not prime
            }
        }
        return true; // No divisors found, it's prime
    }
}

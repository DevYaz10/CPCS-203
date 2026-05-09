import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File input = new File("file1.txt");
        File output = new File("file2.txt");

        try (Scanner in = new Scanner(input);) {

            PrintWriter out = new PrintWriter(output);

            while (in.hasNextLine()) {
                String line = in.nextLine().replaceAll("\\D", " ");
                out.println(line);
            }
            in.close();
            out.close();

        } catch (Exception e) {
            System.out.println(e);
        }

        try (Scanner in = new Scanner(output)) {
            while (in.hasNext()) {
                int number = in.nextInt();
                if (isPrime(number)) {
                    System.out.print(number + " ");
                }
            }
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }

    }

    // Method to check if a number is prime
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

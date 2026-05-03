import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Lab3 {
    public static void main(String[] args) {
        File inputFile = new File("file1.txt");
        File outputFile = new File("file2.txt");

        if (!inputFile.exists()) {
            System.out.println("input file is non-existant");
            System.exit(0);
        }

        try (Scanner input = new Scanner(inputFile);
                PrintWriter output = new PrintWriter(outputFile)) {

            while (input.hasNextLine()) {
                String line = input.nextLine();
                output.println(line.replaceAll("[^0-9]", " "));
            }

        } catch (FileNotFoundException e) {
            System.out.println("Could not open file: " + e.getMessage());
            return;
        }

        try (Scanner input1 = new Scanner(outputFile)) {
            while (input1.hasNextInt()) {
                int n = input1.nextInt();
                if (isPrime(n)) {
                    System.out.print(n + " ");
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Could not open file: " + e.getMessage());
        }
    }


    public static Boolean isPrime(int num) {
        if (num <= 1)
            return false;

        for (int i = 2; i < num; i++)
            if (num % i == 0)
                return false;

        return true;
    }
}

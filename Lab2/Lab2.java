import java.util.*;

public class Lab2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Course ID Generator:");
        System.out.println("----------------------------------");
        System.out.println("Please Enter Course Information");

        String CC = readCourseCode(in);

        String CN = readValidated(
                in,
                "Course Number (consist only of 3 digits):",
                "\\d{3}",
                "Course Number length was not 3 , Please try again");

        String year = readValidated(in,
                "Year",
                "\\d{4}",
                "Enter a correct year format");

        String semester = readSemester(in);

        String CRN = readValidated(
                in,
                "Course Reference Number:",
                "\\d{5}",
                "Enter a number of 5 digits");

        System.out.println("----------------------------------");
        System.out.println("Genereated Course ID: " + CC + CN + "-" + year + semester + "-" + CRN);

        in.close();

    }

    private static String readValidated(Scanner in, String prompt, String regex, String errorMsg) {
        while (true) {
            System.out.print(prompt);
            String input = in.nextLine().trim();
            if (input.matches(regex)) {
                return input;
            }
            System.out.println(errorMsg);
        }
    }

    private static String readCourseCode(Scanner in) {
        while (true) {
            System.out.print("Course Code (only capital letters with a length between 2 and 4):");
            String input = in.nextLine().trim();
            if (input.length() < 2 || input.length() > 4) {
                System.out.println("Course Code length was not between 2 and 4 , Please try again");
            } else if (!input.matches("[A-Z]+")) {
                System.out.println("Course Code must only have capital letters , Please try again");
            } else {
                return input;
            }
        }
    }

    private static String readSemester(Scanner in) {
        while (true) {
            System.out.print("Semester (Fall=01, Sprint=02, Summer=03):");
            String input = in.nextLine().trim();

            if (input.equals("1"))
                return "01";
            if (input.equals("2"))
                return "02";
            if (input.equals("3"))
                return "03";

            System.out.println("Please enter correct semester code, try again");
        }
    }
}

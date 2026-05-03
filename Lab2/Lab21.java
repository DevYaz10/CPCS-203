import java.util.*;

public class Lab21 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Course ID Generator:");
        System.out.println("----------------------------------");
        System.out.println("Please Enter Course Information");

        System.out.print(
                "Course Code (only capital letters with a length between 2 and 4):");
        String courseCode = "";
        boolean valid1 = false;
        while (!valid1) {
            courseCode = in.nextLine().trim();
            if (courseCode.length() < 2 || courseCode.length() > 4) {
                System.out.printf(
                        "Course Code length was not between 2 and 4 , Please try again%nCourse Code (only capital letters with a length between 2 and 4):");
            } else if (!courseCode.matches("[A-Z]+")) {
                System.out.printf(
                        "Course Code must only have capital letters , Please try again%nCourse Code (only capital letters with a length between 2 and 4):");
            } else {
                valid1 = true;
            }
        }

        System.out.print("Course Number (consist only of 3 digits):");
        String courseNum = "";
        boolean valid2 = false;
        while (!valid2) {
            courseNum = in.nextLine().trim();
            if (!courseNum.matches("\\d{3}")) {
                System.out.printf(
                        "Course Number length was not 3 , Please try again%nCourse Number (consist only of 3 digits):");
            } else {
                valid2 = true;
            }
        }

        System.out.print("Year:");
        String year = "";
        boolean valid3 = false;
        while (!valid3) {
            year = in.nextLine().trim();
            if (!year.matches("\\d{4}")) {
                System.out.printf("Enter a correct year format%nYear:");
            } else {
                valid3 = true;
            }
        }

        System.out.print("Semester (Fall=01, Sprint=02, Summer=03):");
        String semesterInput = "";
        boolean valid4 = false;
        while (!valid4) {
            semesterInput = in.nextLine().trim();
            if (!semesterInput.matches("[1-3]")) {
                System.out.printf(
                        "Please enter correct semester code, try again%nSemester (Fall=01, Sprint=02, Summer=03):");
            } else {
                valid4 = true;
            }
        }

        String semesterDigits = "03";
        if (semesterInput.equals("1")) {
            semesterDigits = "01";
        } else if (semesterInput.equals("2")) {
            semesterDigits = "02";
        }

        System.out.print("Course Reference Number:");
        String crn = "";
        boolean valid5 = false;
        while (!valid5) {
            crn = in.nextLine().trim();
            if (!crn.matches("\\d{5}")) {
                System.out.printf("Enter a number of 5 digits%nCourse Reference Number:");
            } else {
                valid5 = true;
            }
        }

        String courseId = courseCode + courseNum + "-" + year + semesterDigits + "-" + crn;

        System.out.println("----------------------------------");
        System.out.println("Genereated Course ID: " + courseId);

        in.close();
    }
}

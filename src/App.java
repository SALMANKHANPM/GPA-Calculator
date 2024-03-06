import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class App {

    // Function to convert Grades to Points
    public static double gradeToPoints(String grade) {
        Map<String, Double> gradeMap = new HashMap<>();
        gradeMap.put("O", 10.0);
        gradeMap.put("A+", 9.0);
        gradeMap.put("A", 8.0);
        gradeMap.put("B+", 7.0);
        gradeMap.put("B", 6.0);
        gradeMap.put("C", 5.5);
        gradeMap.put("F", 0.0);
        return gradeMap.getOrDefault(grade.toUpperCase(), 0.0);
    }

    // Function to calculate GPA
    public static double calculateGPA(float[] credits, String[] grades) {
        int totalCredits = 0;
        double weightedSum = 0;

        for (int i = 0; i < credits.length; i++) {
            float credit = credits[i];
            double points = gradeToPoints(grades[i]);

            totalCredits += credit;
            weightedSum += credit * points;
        }

        if (totalCredits == 0) {
            return 0.0;
        }

        return weightedSum / totalCredits;
    }

    public static void main(String[] args) {
        System.out.println("Welcome to GPA Calculator!\n################################");
        System.out.println("     ---- Input Method ----\n" +
                           "       Points - Grade" + "\n" +
                            "         10   -   O\n" +
                            "          9   -   A+\n" +
                            "          8   -   A \n" +
                            "          7   -   B+\n" +
                            "          6   -   B \n" +
                            "        5.5   -   C\n" +
                            "         <5   -   F\n");

        System.out.println("###################################");
        System.out.println("Example : Grade = A+, Credits = 3.0");
        System.out.println("###################################\n");
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter the number of Courses: ");
            int numCourses = sc.nextInt();

            float[] credits = new float[numCourses];
            String[] grades = new String[numCourses];

            System.out.println("Enter Credits and select Grade for each Course:");

            for (int i = 0; i < numCourses; i++) {
                System.out.println("Course " + (i + 1) + ":");
                System.out.print("Credits:");
                credits[i] = sc.nextFloat();
                sc.nextLine(); // Consume newline

                System.out.print("Grade:");
                grades[i] = sc.nextLine();
            }

            double gpa = calculateGPA(credits, grades);
            System.out.printf("Your SGPA is %.2f%n", gpa);
        }
    }
}

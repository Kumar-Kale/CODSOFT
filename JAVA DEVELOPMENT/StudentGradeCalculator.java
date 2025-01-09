import java.util.Scanner;

public class StudentGradeCalculator {

    public static void main(String[] args) {
        // Create a Scanner object to take input from the user
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the number of subjects
        System.out.print("Enter the number of subjects: ");
        int numberOfSubjects = scanner.nextInt();

        // Initialize an array to store marks for each subject
        int[] marks = new int[numberOfSubjects];

        // Initialize variables to calculate total marks
        int totalMarks = 0;

        // Input: Take marks for each subject
        for (int i = 0; i < numberOfSubjects; i++) {
            System.out.printf("Enter marks for subject %d (out of 100): ", i + 1);
            marks[i] = scanner.nextInt();
            
            // Add the entered marks to the total marks
            totalMarks += marks[i];
        }

        // Calculate the average percentage
        double averagePercentage = (double) totalMarks / numberOfSubjects;

        // Determine the grade based on the average percentage
        char grade;
        if (averagePercentage >= 90) {
            grade = 'A';
        } else if (averagePercentage >= 80) {
            grade = 'B';
        } else if (averagePercentage >= 70) {
            grade = 'C';
        } else if (averagePercentage >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }

        // Display results to the user
        System.out.println("\n=== Results ===");
        System.out.printf("Total Marks: %d\n", totalMarks);
        System.out.printf("Average Percentage: %.2f%%\n", averagePercentage);
        System.out.printf("Grade: %c\n", grade);

        // Close the scanner
        scanner.close();
    }
}

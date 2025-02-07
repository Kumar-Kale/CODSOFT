import java.util.Scanner;

public class StudentGradeCalculator {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        
        System.out.print("Enter the number of subjects: ");
        int numberOfSubjects = scanner.nextInt();

        
        int[] marks = new int[numberOfSubjects];

        
        int totalMarks = 0;

        
        for (int i = 0; i < numberOfSubjects; i++) {
            System.out.printf("Enter marks for subject %d (out of 100): ", i + 1);
            marks[i] = scanner.nextInt();
            
            
            totalMarks += marks[i];
        }

        
        double averagePercentage = (double) totalMarks / numberOfSubjects;

        
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

        
        System.out.println("\n=== Results ===");
        System.out.printf("Total Marks: %d\n", totalMarks);
        System.out.printf("Average Percentage: %.2f%%\n", averagePercentage);
        System.out.printf("Grade: %c\n", grade);

        
        scanner.close();
    }
}

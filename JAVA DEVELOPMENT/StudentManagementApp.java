import java.io.*;
import java.util.*;

// Step 1: Create a Student class to represent individual students
class Student {
    private String name;
    private int rollNumber;
    private String grade;

    // Constructor to initialize student details
    public Student(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Roll Number: " + rollNumber + ", Name: " + name + ", Grade: " + grade;
    }
}


// Step 2: Implement the StudentManagementSystem class
class StudentManagementSystem {
    private List<Student> students;

    // Constructor
    public StudentManagementSystem() {
        students = new ArrayList<>();
    }

    // Method to add a student
    public void addStudent(Student student) {
        students.add(student);
    }

    // Method to remove a student by roll number
    public boolean removeStudent(int rollNumber) {
        return students.removeIf(student -> student.getRollNumber() == rollNumber);
    }

    // Method to search for a student by roll number
    public Student searchStudent(int rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                return student;
            }
        }
        return null;
    }

    // Method to display all students
    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }

    // Step 4: Read student data from a file
    public void readFromFile(String filename) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] details = line.split(",");
                if (details.length == 3) {
                    String name = details[0].trim();
                    int rollNumber = Integer.parseInt(details[1].trim());
                    String grade = details[2].trim();
                    students.add(new Student(name, rollNumber, grade));
                }
            }
        }
    }

    // Step 4: Write student data to a file
    public void writeToFile(String filename) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            for (Student student : students) {
                bw.write(student.getName() + "," + student.getRollNumber() + "," + student.getGrade());
                bw.newLine();
            }
        }
    }
}

// Step 3 & 5: Design the user interface for interaction
public class StudentManagementApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManagementSystem sms = new StudentManagementSystem();

        try {
            // Load existing students from file
            sms.readFromFile("students.txt");
        } catch (IOException e) {
            System.out.println("Error loading student data: " + e.getMessage());
        }

        boolean exit = false;
        while (!exit) {
            System.out.println("\nStudent Management System:");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter roll number: ");
                    int rollNumber = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    System.out.print("Enter grade: ");
                    String grade = scanner.nextLine();

                    if (!name.isEmpty() && rollNumber > 0 && !grade.isEmpty()) {
                        sms.addStudent(new Student(name, rollNumber, grade));
                        System.out.println("Student added successfully.");
                    } else {
                        System.out.println("Invalid input. Please ensure all fields are filled correctly.");
                    }
                    break;

                case 2:
                    System.out.print("Enter roll number to remove: ");
                    int rollToRemove = scanner.nextInt();
                    if (sms.removeStudent(rollToRemove)) {
                        System.out.println("Student removed successfully.");
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter roll number to search: ");
                    int rollToSearch = scanner.nextInt();
                    Student student = sms.searchStudent(rollToSearch);
                    if (student != null) {
                        System.out.println("Student found: " + student);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 4:
                    System.out.println("\nAll Students:");
                    sms.displayAllStudents();
                    break;

                case 5:
                    System.out.println("Exiting the application...");
                    exit = true;
                    try {
                        sms.writeToFile("students.txt");
                    } catch (IOException e) {
                        System.out.println("Error saving student data: " + e.getMessage());
                    }
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }

        scanner.close();
    }
}

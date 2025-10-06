import java.util.*;

// Parent class for demonstration
class Person {
    protected String name;
}

// Student class inherits from Person
class Student extends Person {
    private int rollNo;
    private String course;
    private double marks;
    private char grade;

    // Empty constructor
    public Student() {}

    // Constructor with parameters
    public Student(int rollNo, String name, String course, double marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.course = course; 
        this.marks = marks;
        evaluateGrade();
    }

    // Input method
    public void readData(Scanner sc) {
        System.out.print("Enter Roll No: ");
        rollNo = sc.nextInt();
        sc.nextLine(); // consume newline

        System.out.print("Enter Full Name: ");
        name = sc.nextLine();

        System.out.print("Enter Course Name: ");
        course = sc.nextLine();

        while (true) {
            System.out.print("Enter Marks (0-100): ");
            marks = sc.nextDouble();
            if (marks >= 0 &&  marks <= 100) break;
            System.out.println(" Invalid! Please enter between 0 and 100.");
        }

        evaluateGrade();
    }

    // Grade calculation logic
    private void evaluateGrade() {
        if (marks >= 90) grade = 'A';
        else if (marks >= 70) grade = 'B';
        else if (marks >= 50) grade = 'C';
        else grade = 'D';
    }

    // Display details
    public void display() {
        System.out.println("\n");
        System.out.println("Roll Number : " + rollNo);
        System.out.println("Name        : " + name);
        System.out.println("Course      : " + course);
        System.out.println("Marks       : " + marks);
        System.out.println("Grade       : " + grade);
    }
}

// Main driver class
public class StudentPortal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> records = new ArrayList<>();
        int choice; 

        do {
            System.out.println("\nStudent Record System");
            System.out.println("1. Register Student");
            System.out.println("2. View All Students");
            System.out.println("3. Quit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1: 
                    Student s = new Student();
                    s.readData(sc); //input function call kra
                    records.add(s); // array m add krdia 
                    System.out.println(" Student added successfully!");
                    break;

                case 2:
                    if (records.isEmpty()) {
                        System.out.println(" No student data available.");
                    } else {
                        System.out.println("\n Student Records");
                        for (Student stu : records) {
                            stu.display();
                        }
                    }
                    break;

                case 3:
                    System.out.println("Exiting code");
                    break;

                default:
                    System.out.println("Please select a valid option.");
            }
        } while (choice != 3);

        sc.close();
    }
}
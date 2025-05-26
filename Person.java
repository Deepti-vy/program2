import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Person {
    protected String name;
    protected LocalDate dob;

    public Person(String name, String dobString) {
        this.name = name;
        this.dob = parseDate(dobString);
    }

    public void displayPersonName() {
        System.out.println("Name: " + name);
    }

    public void displayAge() {
        int age = Period.between(dob, LocalDate.now()).getYears();
        System.out.println("Age: " + age + " years");
    }

    private LocalDate parseDate(String dobString) {
        DateTimeFormatter formatter;
        if (dobString.matches("\\d{2}-\\d{2}-\\d{4}")) {
            formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        } else if (dobString.matches("\\d{4}-\\d{2}-\\d{2}")) {
            formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        } else {
            throw new IllegalArgumentException("Date must be in DD-MM-YYYY or YYYY-MM-DD format.");
        }
        return LocalDate.parse(dobString, formatter);
    }
}
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Person {
    protected String name;
    protected LocalDate dob;

    public Person(String name, String dobString) {
        this.name = name;
        this.dob = parseDate(dobString);
    }

    public void displayPersonName() {
        System.out.println("Name: " + name);
    }

    public void displayAge() {
        int age = Period.between(dob, LocalDate.now()).getYears();
        System.out.println("Age: " + age + " years");
    }

    private LocalDate parseDate(String dobString) {
        DateTimeFormatter formatter;
        if (dobString.matches("\\d{2}-\\d{2}-\\d{4}")) {
            formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        } else if (dobString.matches("\\d{4}-\\d{2}-\\d{2}")) {
            formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        } else {
            throw new IllegalArgumentException("Date must be in DD-MM-YYYY or YYYY-MM-DD format.");
        }
        return LocalDate.parse(dobString, formatter);
    }
}
✅ StudentApp.java (can be on main branch)
java
Copy
Edit
import java.util.Scanner;

class Student extends Person {
    public Student(String name, String dobString) {
        super(name, dobString);
    }

    public void displayInfo() {
        displayPersonName();
        displayAge();
    }
}

public class StudentApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Date of Birth (DD-MM-YYYY or YYYY-MM-DD): ");
        String dob = sc.nextLine();

        Student student = new Student(name, dob);
        System.out.println("\n--- Student Info ---");
        student.displayInfo();

        sc.close();
    }
}
import java.util.Scanner;

class Employee extends Person {
    private int empId;
    private double salary;

    public Employee(String name, String dobString, int empId, double salary) {
        super(name, dobString);
        this.empId = empId;
        this.salary = salary;
    }

    public void displayEmployeeInfo() {
        displayPersonName();
        System.out.println("Employee ID: " + empId);
        System.out.println("Salary: $" + salary);
        displayAge();
    }
}

public class EmployeeApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Employee Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Date of Birth (DD-MM-YYYY or YYYY-MM-DD): ");
        String dob = sc.nextLine();

        System.out.print("Enter Employee ID: ");
        int empId = sc.nextInt();

        System.out.print("Enter Salary: ");
        double salary = sc.nextDouble();

        Employee employee = new Employee(name, dob, empId, salary);
        System.out.println("\n--- Employee Info ---");
        employee.displayEmployeeInfo();

        sc.close();
    }
}
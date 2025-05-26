import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class student {
    private String name;
    private LocalDate dob;

    public student(String name, String dobString) {
        this.name = name;
        this.dob = parseDate(dobString);
    }

    private LocalDate parseDate(String dobString) {
        try {
            DateTimeFormatter formatter;
            if (dobString.matches("\\d{2}-\\d{2}-\\d{4}")) {
                formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            } else if (dobString.matches("\\d{4}-\\d{2}-\\d{2}")) {
                formatter = DateTimeFormatter.ISO_LOCAL_DATE;
            } else {
                throw new IllegalArgumentException("Invalid date format.");
            }
            return LocalDate.parse(dobString, formatter);
        } catch (Exception e) {
            throw new IllegalArgumentException("Date must be in DD-MM-YYYY or YYYY-MM-DD format.");
        }
    }

    public void displayInfo() {
        int age = Period.between(dob, LocalDate.now()).getYears();
        System.out.println("\nStudent Name: " + name);
        System.out.println("Age: " + age);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Date of Birth (DD-MM-YYYY or YYYY-MM-DD): ");
        String dob = sc.nextLine();

        student student = new student(name, dob);
        student.displayInfo();

        sc.close();
    }
}

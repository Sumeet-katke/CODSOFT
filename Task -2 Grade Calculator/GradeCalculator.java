import java.util.Scanner;

public class GradeCalculator {
    private int sub;
    private int totalmarks;
    private Scanner input = new Scanner(System.in);

    public void inputmarks(int subjects) {
        totalmarks = 0;
        sub = subjects;

        for (int i = 1; i <= sub; i++) {
            System.out.print("Enter the marks obtained in subject - " + i + ": ");
            int marks = input.nextInt();

            if (marks < 0 || marks > 100) {
                System.out.println("Please enter marks within the range 0 to 100");
                i--;
            } else {
                totalmarks += marks;
            }
        }
    }

    public double percent() {
        return (double) totalmarks / sub;
    }

    public String Grade() {
        String grade;
        double percent = percent();

        if (percent <= 25) {
            grade = "F";
        } else if (percent <= 35) {
            grade = "E";
        } else if (percent <= 55) {
            grade = "C";
        } else if (percent <= 65) {
            grade = "B";
        } else if (percent <= 75) {
            grade = "B+";
        } else if (percent <= 85) {
            grade = "A";
        } else if (percent <= 95) {
            grade = "A+";
        } else {
            grade = "O";
        }

        return grade;
    }

    public void showresult() {
        System.out.print("\nGrade obtained: " + Grade() +
                "\nTotal marks: " + totalmarks +
                "\nPercentage obtained: " + percent() + "%");
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int students;
        System.out.print("Enter the total Number of students: ");
        students = input.nextInt();
        
        int subjects;
        System.out.print("Enter the total Number of subjects: ");
        subjects = input.nextInt();

        GradeCalculator[] student = new GradeCalculator[students];
        for (int i = 0; i < students; i++) {
            student[i] = new GradeCalculator();
            System.out.print("\n\nStudent " + (i + 1) + "\n");
            student[i].inputmarks(subjects); // Pass the total subjects as an argument
            student[i].showresult();
        }
        input.close();
    }
}

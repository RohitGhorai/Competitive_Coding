package tcs_ipa.IPA42;

import java.util.*;

public class IPA42 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Student[] students = new Student[2];
        Faculty[] faculties = new Faculty[2];
        for (int i = 0; i < 2; i++){
            String a = sc.nextLine();
            String b = sc.nextLine();
            int c = sc.nextInt(); sc.nextLine();
            char d = sc.nextLine().charAt(0);
            String e = sc.nextLine();
            String f = sc.nextLine();
            int g = sc.nextInt(); sc.nextLine();
            double h = sc.nextDouble(); sc.nextLine();
            students[i] = new Student(a, b, c, d, e, f, g, h);
        }
        for (int i = 0; i < 2; i++){
            String a = sc.nextLine();
            String b = sc.nextLine();
            int c = sc.nextInt(); sc.nextLine();
            char d = sc.nextLine().charAt(0);
            String e = sc.nextLine();
            String f = sc.nextLine();
            String g = sc.nextLine();
            double h = sc.nextDouble(); sc.nextLine();
            faculties[i] = new Faculty(a, b, c, d, e, f, g, h);
        }
        Student s1 = findHighestGPAStudent(students);
        if (s1 == null) System.out.println("Sorry - No student is available");
        else System.out.println(s1.getRollNo() + "\n" + s1.getCourse() + "\n" + s1.getGPA());
        Faculty f1 = findHighestPaidFaculty(faculties);
        if (f1 == null) System.out.println("Sorry - No faculty is available");
        else System.out.println(f1.getEmployeeId() + "\n" + f1.getDepartment() + "\n" + f1.getSalary());
    }
    static Student findHighestGPAStudent(Student[] students){
        if (students.length == 0) return null;
        double max = Double.MIN_VALUE;
        for (Student s : students) max = Math.max(max, s.getGPA());
        for (Student s : students) if (max == s.getGPA()) return s;
        return null;
    }
    static Faculty findHighestPaidFaculty(Faculty[] faculties){
        if (faculties.length == 0) return null;
        double max = Double.MIN_VALUE;
        for (Faculty f : faculties) max = Math.max(max, f.getSalary());
        for (Faculty f : faculties) if (max == f.getSalary()) return f;
        return null;
    }
}
class Person {
    private String firstName, lastName;
    private int age;
    private char gender;
    public Person(String fName, String lName, int age, char gender){
        this.firstName = fName;
        this.lastName = lName;
        this.age = age;
        this.gender = gender;
    }
}
class Student extends Person {
    private String rollNo, course;
    private int semester;
    private double gpa;
    public Student(String fName, String lName, int age, char gender, String rollNo, String course, int semester, double gpa){
        super(fName, lName, age, gender);
        this.rollNo = rollNo;
        this.course = course;
        this.semester = semester;
        this.gpa = gpa;
    }
    public String getRollNo(){
        return this.rollNo;
    }
    public String getCourse(){
        return this.course;
    }
    public double getGPA(){
        return this.gpa;
    }
}
class Faculty extends Person {
    private String employeeId, department, designation;
    private double salary;
    public Faculty(String fName, String lName, int age, char gender, String id, String department, String designation, double salary){
        super(fName, lName, age, gender);
        this.employeeId = id;
        this.department = department;
        this.designation = designation;
        this.salary = salary;
    }
    public String getEmployeeId(){
        return this.employeeId;
    }
    public String getDepartment(){
        return this.department;
    }
    public double getSalary(){
        return this.salary;
    }
}

package tcs_ipa.IPA43;

import java.util.*;

public class IPA43 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Student[] students = new Student[4];
        for (int i = 0; i < 4; i++){
            String a = sc.nextLine();
            String b = sc.nextLine();
            int c = sc.nextInt(); sc.nextLine();
            char d = sc.nextLine().charAt(0);
            String e = sc.nextLine();
            int f = sc.nextInt(); sc.nextLine();
            double g = sc.nextDouble(); sc.nextLine();
            students[i] = new Student(a, b, c, d, e, f, g);
        }
        String course = sc.nextLine();
        String avg = calculateAverageGPA(students);
        if (avg == "") System.out.println("Sorry - No students are available");
        else System.out.println(avg);
        ArrayList<Student> list = getStudentByCourse(students, course);
        if (list == null) System.out.println("Sorry - No students are available for the given course");
        else for (Student s : students) System.out.println(s.getName() + "\n" + s.getRollNo() + "\n" + s.getGPA());
    }
    static String calculateAverageGPA(Student[] students){
        if (students.length == 0) return "";
        double total = 0;
        for (Student s : students) total += s.getGPA();
        return String.format("%.1f", total / students.length);
    }
    static ArrayList<Student> getStudentByCourse(Student[] students, String course){
        ArrayList<Student> list = new ArrayList<>();
        for (Student s : students) if (s.getCourse().equalsIgnoreCase(course)) list.add(s);
        return list.size() == 0 ? null : list;
    }
}
class Student {
    private String name, rollNo, course;
    private int age, semester;
    private char gender;
    private double gpa;
    public Student(String name, String rollNo, int age, char gender, String course, int semester, double gpa){
        this.name = name;
        this.rollNo = rollNo;
        this.age = age;
        this.gender = gender;
        this.course = course;
        this.semester = semester;
        this.gpa = gpa;
    }
    public String getName(){
        return this.name;
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

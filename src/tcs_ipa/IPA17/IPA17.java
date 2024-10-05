package tcs_ipa.IPA17;

import java.util.*;

public class IPA17 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Student[] students = new Student[4];
        for (int i = 0; i < 4; i++){
            int a = sc.nextInt(); sc.nextLine();
            String b = sc.nextLine();
            String c = sc.nextLine();
            char d = sc.nextLine().charAt(0);
            String e = sc.nextLine();
            students[i] = new Student(a, b, c, d, e);
        }
        char grade = sc.nextLine().charAt(0);
        int month = sc.nextInt();
        ArrayList<Student> list = findStudentByGradeAndMonth(students, grade, month);
        if (list == null) System.out.println("No student found");
        else for (Student res : list) System.out.println(res.getName() + "\n" + res.getSubject());
        if (list != null) System.out.println(list.size());
    }
    static int getMonth(String date){
        String[] str = date.split("/");
        return Integer.parseInt(str[1]);
    }
    static ArrayList<Student> findStudentByGradeAndMonth(Student[] students, char grade, int month){
        ArrayList<Student> list = new ArrayList<>();
        for (Student s : students) if (s.getGrade() == grade && getMonth(s.getDate()) == month) list.add(s);
        return list.size() == 0 ? null : list;
    }
}
class Student {
    private int rollNo;
    private String name, subject, date;
    private char grade;
    public Student(int rollNo, String name, String sub, char grade, String date){
        this.rollNo = rollNo;
        this.name = name;
        this.subject = sub;
        this.grade = grade;
        this.date = date;
    }
    public String getName(){
        return this.name;
    }
    public String getSubject(){
        return this.subject;
    }
    public char getGrade(){
        return this.grade;
    }
    public String getDate(){
        return this.date;
    }
}
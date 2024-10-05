package tcs_ipa.IPA3;

import java.util.*;

public class IPA3 {
    public static void main(String[] args) {
        Student[] students = new Student[4];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 4; i++){
            int a = sc.nextInt(); sc.nextLine();
            String b = sc.nextLine();
            String c = sc.nextLine();
            double d = sc.nextDouble(); sc.nextLine();
            boolean e = sc.nextBoolean(); sc.nextLine();
            students[i] = new Student(a, b, c, d, e);
        }
        int ans = findCountOfDayScholarStudents(students);
        if (ans == 0) System.out.println("There are no such day scholar students");
        else System.out.println(ans);
        Student res = findStudentWithSecondHighestScore(students);
        if (res == null) System.out.println("There are no student from non day scholar");
        else System.out.println(res.getRollNo() + "#" + res.getName() + "#" + res.getScore());
    }
    static int findCountOfDayScholarStudents(Student[] students){
        int count = 0;
        for (Student s : students) if (s.getScore() > 80 && s.isDayScholar()) count++;
        return count;
    }
    static Student findStudentWithSecondHighestScore(Student[] students){
        List<Student> list = new ArrayList<>();
        for (Student s : students) if (!s.isDayScholar()) list.add(s);
        Collections.sort(list, Comparator.comparingDouble(Student::getScore));
        return list.size() <= 1 ? null : list.get(list.size() - 2);
    }
}
class Student {
    private int rollNo;
    private String name, branch;
    private double score;
    private boolean dayScholar;
    public Student(int rollNo, String name, String branch, double score, boolean dayScholar){
        this.rollNo = rollNo;
        this.name = name;
        this.branch = branch;
        this.score = score;
        this.dayScholar = dayScholar;
    }
    public int getRollNo(){
        return this.rollNo;
    }
    public void setRollNo(int roll){
        this.rollNo = roll;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getBranch(){
        return this.branch;
    }
    public void setBranch(String branch){
        this.branch = branch;
    }
    public double getScore(){
        return this.score;
    }
    public void setScore(int s){
        this.score = s;
    }
    public boolean isDayScholar(){
        return this.dayScholar;
    }
    public void setDayScholar(boolean ds){
        this.dayScholar = ds;
    }
}

package tcs_ipa.IPA52;

import java.util.*;

public class IPA52 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Course[] courses = new Course[4];
        for (int i = 0; i < 4; i++){
            String a = sc.nextLine();
            int b = sc.nextInt(); sc.nextLine();
            String c = sc.nextLine();
            boolean d = sc.nextBoolean(); sc.nextLine();
            courses[i] = new Course(a, b, c, d);
        }
        String name = sc.nextLine();
        String res = findCourseStatus(courses, name);
        if (!res.equals("")) System.out.println(res);
        else System.out.println("No course found");
    }
    static String findCourseStatus(Course[] courses, String name){
        for (Course c : courses) {
            if (c.getName().equalsIgnoreCase(name))
                if (c.getCourseNumber() >= 1000) return "High";
                else if (c.getCourseNumber() < 1000 && c.getCourseNumber() >= 500) return "Medium";
                else return "Low";
        }
        return "";
    }
}
class Course {
    private String name, mode;
    private int courseNumber;
    private boolean sharedata;
    public Course(String name, int courseNumber, String mode, boolean sharedata){
        this.name = name;
        this.courseNumber = courseNumber;
        this.mode = mode;
        this.sharedata = sharedata;
    }
    public String getName(){
        return this.name;
    }
    public int getCourseNumber(){
        return this.courseNumber;
    }
}

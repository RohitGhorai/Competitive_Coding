package tcs_ipa.IPA1;

import java.util.*;

public class CourseProgram {
    public static void main(String[] args){
        Course[] courses = new Course[4];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 4; i++){
            int cId = sc.nextInt(); sc.nextLine();
            String cName = sc.nextLine();
            String cAdmin = sc.nextLine();
            int q = sc.nextInt(); sc.nextLine();
            int h = sc.nextInt(); sc.nextLine();
            Course course = new Course(cId, cName, cAdmin, q, h);
            courses[i] = course;
        }
        String admin = sc.nextLine();
        int h = sc.nextInt();
        int ans = findAvgOfQuizByAdmin(courses, admin);
        if (ans == 0) System.out.println("No course found.");
        else System.out.println(ans);
        Course[] res = sortCourseByHandsOn(courses, h);
        if (res == null) System.out.println("No course found with mentioned attribute.");
        else {
            for (Course c : res) System.out.println(c.getCourseName());
        }
    }
    static int findAvgOfQuizByAdmin(Course[] course, String adminName){
        int avg = 0, count = 0;
        for (Course c : course){
            if (c.getCourseAdmin().equals(adminName)) {
                avg += c.getQuiz();
                count++;
            }
        }
        return avg == 0 ? 0 : avg/count;
    }
    static Course[] sortCourseByHandsOn(Course[] course, int handson){
        List<Course> list = new ArrayList<>();
        for (Course c : course){
            if (c.getHandson() < handson) list.add(c);
        }
        Collections.sort(list, Comparator.comparingInt(Course::getHandson));
        return list.size() == 0 ? null : list.toArray(new Course[0]);
    }
}
class Course {
    private int courseId;
    private String courseName;
    private String courseAdmin;
    private int quiz;
    private int handson;
    public Course(int courseId, String courseName, String courseAdmin, int quiz, int handson){
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseAdmin = courseAdmin;
        this.quiz = quiz;
        this.handson = handson;
    }
    public int getCourseId(){
        return this.courseId;
    }
    public void setCourseId(int id){
        this.courseId = id;
    }
    public String getCourseName(){
        return this.courseName;
    }
    public void setCourseName(String cName){
        this.courseName = cName;
    }
    public String getCourseAdmin(){
        return this.courseAdmin;
    }
    public void setCourseAdmin(String cAdmin){
        this.courseAdmin = cAdmin;
    }
    public int getQuiz(){
        return this.quiz;
    }
    public void setQuiz(int q){
        this.quiz = q;
    }
    public int getHandson(){
        return this.handson;
    }
    public void setHandson(int h){
        this.handson = h;
    }
}

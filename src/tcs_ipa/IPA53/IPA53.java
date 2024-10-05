package tcs_ipa.IPA53;

import java.util.*;

public class IPA53 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Course[] courses = new Course[4];
        for (int i = 0; i < 4; i++){
            int a = sc.nextInt(); sc.nextLine();
            String b = sc.nextLine();
            double c = sc.nextDouble(); sc.nextLine();
            String d = sc.nextLine();
            boolean e = sc.nextBoolean(); sc.nextLine();
            courses[i] = new Course(a, b, c, d, e);
        }
        double rating = sc.nextDouble();sc.nextLine();
        String mode = sc.nextLine();
        int count = countCourse(courses, mode, rating);
        if (count != 0) System.out.println(count);
        else System.out.println("No course found");
    }
    static int countCourse(Course[] courses, String mode, double rating){
        int count = 0;
        for (Course c : courses) if (c.getMode().equalsIgnoreCase(mode) && c.haveCertificate() && c.getRating() >= rating) count++;
        return count;
    }
}
class Course {
    private int id;
    private String name, mode;
    private double rating;
    private boolean haveCertificate;
    public Course(int id, String name, double rating, String mode, boolean haveCertificate){
        this.id = id;
        this.name = name;
        this.rating = rating;
        this.mode = mode;
        this.haveCertificate = haveCertificate;
    }
    public String getName(){
        return this.name;
    }
    public String getMode(){
        return this.mode;
    }
    public double getRating(){
        return this.rating;
    }
    public boolean haveCertificate(){
        return this.haveCertificate;
    }
}

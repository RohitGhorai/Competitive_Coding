package tcs_ipa.IPA23;

import java.util.*;

public class IPA23 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Institution[] institutions = new Institution[4];
        for (int i = 0; i < 4; i++){
            int a = sc.nextInt(); sc.nextLine();
            String b = sc.nextLine();
            int c = sc.nextInt();
            int d = sc.nextInt(); sc.nextLine();
            String e = sc.nextLine();
            institutions[i] = new Institution(a, b, c, d, e, "");
        }
        String location = sc.nextLine();
        String name = sc.nextLine();
        int ans = findNumClearancedByLoc(institutions, location);
        if (ans == 0) System.out.println("There are no cleared students in this particular location");
        else System.out.println(ans);
        Institution res = updateInstitutionGrade(institutions, name);
        if (res == null) System.out.println("No Institute is available with the specified name");
        else System.out.println(res.getName() + "::" + res.getGrade());
    }
    static int findNumClearancedByLoc(Institution[] institutions, String location){
        int sum = 0;
        for (Institution i : institutions) if (i.getLocation().equalsIgnoreCase(location)) sum += i.getNoOfStudentsCleared();
        return sum;
    }
    static Institution updateInstitutionGrade(Institution[] institutions, String name){
        for (Institution i : institutions)
            if (i.getName().equalsIgnoreCase(name)){
                int rating = (i.getNoOfStudentsPlaced() * 100) / i.getNoOfStudentsCleared();
                if (rating >= 80) i.setGrade("A");
                else i.setGrade("B");
                return i;
            }
        return null;
    }
}
class Institution {
    private int id, noOfStudentsPlaced, noOfStudentsCleared;
    private String name, location, grade;
    public Institution(int id, String name, int noOfStudentsPlaced, int noOfStudentsCleared, String location, String grade){
        this.id = id;
        this.name = name;
        this.noOfStudentsPlaced = noOfStudentsPlaced;
        this.noOfStudentsCleared = noOfStudentsCleared;
        this.location = location;
        this.grade = grade;
    }
    public String getName(){
        return this.name;
    }
    public String getLocation(){
        return this.location;
    }
    public int getNoOfStudentsCleared(){
        return this.noOfStudentsCleared;
    }
    public int getNoOfStudentsPlaced(){
        return this.noOfStudentsPlaced;
    }
    public String getGrade(){
        return this.grade;
    }
    public void setGrade(String g){
        this.grade = g;
    }
}

package tcs_ipa.IPA22;

import java.util.*;

public class IPA22 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Associate[] associates = new Associate[5];
        for (int i = 0; i < 5; i++){
            int a = sc.nextInt(); sc.nextLine();
            String b = sc.nextLine();
            String c = sc.nextLine();
            int d = sc.nextInt(); sc.nextLine();
            associates[i] = new Associate(a, b, c, d);
        }
        String tech = sc.nextLine();
        ArrayList<Associate> list = associatesForGivenTechnology(associates, tech);
        for (Associate a : list) System.out.println(a.getId());
    }
    static ArrayList<Associate> associatesForGivenTechnology(Associate[] associates, String tech){
        ArrayList<Associate> list = new ArrayList<>();
        for (Associate a : associates) if (a.getTechnology().equalsIgnoreCase(tech) && a.getExp() % 5 == 0) list.add(a);
        return list;
    }
}
class Associate {
    private int id, exp;
    private String name, technology;
    public Associate(int id, String name, String tech, int exp){
        this.id = id;
        this.name = name;
        this.technology = tech;
        this.exp = exp;
    }
    public int getId(){
        return this.id;
    }
    public int getExp(){
        return this.exp;
    }
    public String getTechnology(){
        return this.technology;
    }
}

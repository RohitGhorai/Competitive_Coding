package tcs_ipa.IPA27;

import java.util.*;

public class IPA27 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Sim[] sims = new Sim[4];
        for (int i = 0; i < 4; i++){
            int a = sc.nextInt(); sc.nextLine();
            String b = sc.nextLine();
            int c = sc.nextInt(); sc.nextLine();
            double d = sc.nextDouble(); sc.nextLine();
            String e = sc.nextLine();
            sims[i] = new Sim(a, b, c, d, e);
        }
        String circle = sc.nextLine();
        double ratePerSecond = sc.nextDouble();
        ArrayList<Sim> list = matchAndSort(sims, circle, ratePerSecond);
        for (Sim s : list) System.out.println(s.getId());
    }
    static ArrayList<Sim> matchAndSort(Sim[] sims, String circle, double ratePerSecond){
        ArrayList<Sim> list = new ArrayList<>();
        for (Sim s : sims) if (s.getCircle().equalsIgnoreCase(circle) && s.getRatePerSecond() < ratePerSecond) list.add(s);
        Collections.sort(list, Comparator.comparingInt(Sim::getBalance).reversed());
        return list;
    }
}
class Sim {
    private int id, balance;
    private String company, circle;
    private double ratePerSecond;
    public Sim(int id, String company, int balance, double ratePerSecond, String circle){
        this.id = id;
        this.company = company;
        this.balance = balance;
        this.ratePerSecond = ratePerSecond;
        this.circle = circle;
    }
    public int getId(){
        return this.id;
    }
    public int getBalance(){
        return this.balance;
    }
    public double getRatePerSecond(){
        return this.ratePerSecond;
    }
    public String getCircle(){
        return this.circle;
    }
}

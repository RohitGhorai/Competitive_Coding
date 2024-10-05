package tcs_ipa.IPA7;

import java.util.*;

public class IPA7 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Sim[] sims = new Sim[5];
        for (int i = 0; i < 5; i++){
            int a = sc.nextInt(); sc.nextLine();
            String b = sc.nextLine();
            double c = sc.nextDouble();
            double d = sc.nextDouble(); sc.nextLine();
            String e = sc.nextLine();
            sims[i] = new Sim(a, b, c, d, e);
        }
        String circle1 = sc.nextLine();
        String circle2 = sc.nextLine();
        Sim[] res = transferCustomerCircle(sims, circle1, circle2);
        if (res == null) System.out.println("No transferred occurred");
        else for (Sim sim : res) System.out.println(sim.getSimId() + " " + sim.getCustomerName() + " " + sim.getCircle() + " " + sim.getRatePerSecond());
    }
    static Sim[] transferCustomerCircle(Sim[] sims, String circle1, String circle2){
        List<Sim> list = new ArrayList<>();
        for (Sim s : sims)
            if (s.getCircle().equals(circle1)){
                s.setCircle(circle2);
                list.add(s);
            }
        Collections.sort(list, Comparator.comparingDouble(Sim::getRatePerSecond).reversed());
        //Collections.reverse(list);
        return list.size() == 0 ? null : list.toArray(new Sim[0]);
    }
}
class Sim {
    private int simId;
    private String customerName;
    private double balance, ratePerSecond;
    private String circle;
    public Sim(int id, String cName, double balance, double rate, String circle){
        this.simId = id;
        this.customerName = cName;
        this.balance = balance;
        this.ratePerSecond = rate;
        this.circle = circle;
    }
    public int getSimId(){
        return this.simId;
    }
    public String getCustomerName(){
        return this.customerName;
    }
    public double getRatePerSecond(){
        return this.ratePerSecond;
    }
    public String getCircle(){
        return this.circle;
    }
    public void setCircle(String val){
        this.circle = val;
    }
}

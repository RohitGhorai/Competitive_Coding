package tcs_ipa.IPA24;

import java.util.*;

public class IPA24 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Inventory[] inventories = new Inventory[4];
        for (int i = 0; i < 4; i++){
            String a = sc.nextLine();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int d = sc.nextInt(); sc.nextLine();
            inventories[i] = new Inventory(a, b, c, d);
        }
        int limit = sc.nextInt();
        ArrayList<Inventory> list = Replenish(inventories, limit);
        for (Inventory i : list) {
            String id = i.getId();
            int threshold = i.getThreshold();
            if (threshold > 75) System.out.println(id + " Critical Filling");
            else if (threshold < 75 && threshold > 50) System.out.println(id + " Moderate Filling");
            else System.out.println(id + " Non-Critical Filling");
        }
    }
    static ArrayList<Inventory> Replenish(Inventory[] inventories, int limit){
        ArrayList<Inventory> list = new ArrayList<>();
        for (Inventory i : inventories)
            if (limit >= i.getThreshold()) list.add(i);
        return list;
    }
}
class Inventory {
    private String id;
    private int maxQuantity, currQuantity, threshold;
    public Inventory(String id, int maxQuant, int currQuant, int threshold){
        this.id = id;
        this.maxQuantity = maxQuant;
        this.currQuantity = currQuant;
        this.threshold = threshold;
    }
    public String getId(){
        return this.id;
    }
    public int getThreshold(){
        return this.threshold;
    }
}

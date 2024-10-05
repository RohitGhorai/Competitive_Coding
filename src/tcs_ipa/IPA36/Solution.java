package tcs_ipa.IPA36;

import java.util.*;

public class Solution {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Mobile[] mobiles = new Mobile[5];
        for (int i = 0; i < 5; i++){
            int a = sc.nextInt();
            int b = sc.nextInt(); sc.nextLine();
            String c = sc.nextLine();
            boolean d = sc.nextBoolean(); sc.nextLine();
            mobiles[i] = new Mobile(a, b, c, d);
        }
        String brand = sc.nextLine();
        int ans = getTotalPrice(mobiles, brand);
        if (ans == 0) System.out.println("There are no mobile with given brand");
        else System.out.println(ans);
        ArrayList<Mobile> list = getSecondMin(mobiles);
        for (Mobile m : list) System.out.println(m.getBrand() + " : " + m.getPrice());
    }
    static int getTotalPrice(Mobile[] mobiles, String brand){
        int total = 0;
        for (Mobile m : mobiles) if (m.getBrand().equalsIgnoreCase(brand)) total += m.getPrice();
        return total;
    }
    static ArrayList<Mobile> getSecondMin(Mobile[] mobiles){
        ArrayList<Mobile> list = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for (Mobile m : mobiles) min = Math.min(min, m.getPrice());
        int secMin = Integer.MAX_VALUE;
        for (Mobile m : mobiles) if (m.getPrice() != min) secMin = Math.min(secMin, m.getPrice());
        for (Mobile m : mobiles) if (m.getPrice() == secMin) list.add(m);
        return list;
    }
}
class Mobile {
    private int id, price;
    private String brand;
    private boolean isFlagShip;
    public Mobile(int id, int price, String brand, boolean isFlagShip){
        this.id = id;
        this.price = price;
        this.brand = brand;
        this.isFlagShip = isFlagShip;
    }
    public int getPrice(){
        return this.price;
    }
    public String getBrand(){
        return this.brand;
    }
}

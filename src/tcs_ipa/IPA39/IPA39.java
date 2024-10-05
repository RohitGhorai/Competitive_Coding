package tcs_ipa.IPA39;

import java.util.*;

public class IPA39 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Vegetable[] vegetables = new Vegetable[4];
        for (int i = 0; i < 4; i++){
            int a = sc.nextInt(); sc.nextLine();
            String b = sc.nextLine();
            int c = sc.nextInt();
            int d = sc.nextInt();
            vegetables[i] = new Vegetable(a, b, c, d);
        }
        int rating = sc.nextInt();
        Vegetable res = findMinimumPriceByRating(vegetables, rating);
        if (res == null) System.out.println("No such Vegetables");
        else System.out.println(res.getId());
    }
    static Vegetable findMinimumPriceByRating(Vegetable[] vegetables, int rating){
        int min = Integer.MAX_VALUE;
        for (Vegetable v : vegetables) if (v.getRating() > rating) min = Math.min(min, v.getPrice());
        if (min == Integer.MAX_VALUE) return null;
        for (Vegetable v : vegetables) if (v.getPrice() == min) return v;
        return null;
    }
}
class Vegetable {
    private int id, price, rating;
    private String name;
    public Vegetable(int id, String name, int price, int rating){
        this.id = id;
        this.name = name;
        this.price = price;
        this.rating = rating;
    }
    public int getId(){
        return this.id;
    }
    public int getPrice(){
        return this.price;
    }
    public int getRating(){
        return this.rating;
    }
}

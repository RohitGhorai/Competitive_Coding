package tcs_ipa.IPA21;

import java.util.*;

public class IPA21 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Fruit[] fruits = new Fruit[4];
        for (int i = 0; i < 4; i++){
            int a = sc.nextInt(); sc.nextLine();
            String b = sc.nextLine();
            int c = sc.nextInt();
            int d = sc.nextInt();
            fruits[i] = new Fruit(a, b, c, d);
        }
        int rating = sc.nextInt();
        Fruit res = findMaximumPriceByRating(fruits, rating);
        if (res == null) System.out.println("No such Fruit");
        else System.out.println(res.getId());
    }
    static Fruit findMaximumPriceByRating(Fruit[] fruits, int rating){
        int r = Integer.MIN_VALUE;
        Fruit res = null;
        for (Fruit f : fruits)
            if (f.getRating() > rating && r < f.getPrice()){
                r = f.getPrice();
                res = f;
            }
        return res;
    }
}
class Fruit {
    private int id, price, rating;
    private String name;
    public Fruit(int id, String name, int price, int rating){
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
    public String getName(){
        return this.name;
    }
}

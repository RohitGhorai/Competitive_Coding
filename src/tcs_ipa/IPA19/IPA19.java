package tcs_ipa.IPA19;

import java.util.*;

public class IPA19 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Flower[] flowers = new Flower[4];
        for (int i = 0; i < 4; i++){
            int a = sc.nextInt(); sc.nextLine();
            String b = sc.nextLine();
            int c = sc.nextInt();
            int d = sc.nextInt(); sc.nextLine();
            String e = sc.nextLine();
            flowers[i] = new Flower(a, b, c, d, e);
        }
        String type = sc.nextLine();
        int ans = findMinPriceByType(flowers, type);
        if (ans == 0) System.out.println("There is no flower with given type");
        else System.out.println(ans);
    }
    static int findMinPriceByType(Flower[] flowers, String type){
        int min = Integer.MAX_VALUE, id = 0;
        for (Flower f : flowers)
            if (f.getType().equalsIgnoreCase(type)) {
                if (min > f.getPrice()) {
                    min = f.getPrice();
                    id = f.getId();
                }
            }
        return id;
    }
}
class Flower {
    private int id, price, rating;
    private String name, type;
    public Flower(int id, String name, int price, int rating, String type){
        this.id = id;
        this.name = name;
        this.price = price;
        this.rating = rating;;
        this.type = type;
    }
    public int getId(){
        return this.id;
    }
    public int getPrice(){
        return this.price;
    }
    public String getType(){
        return this.type;
    }
}

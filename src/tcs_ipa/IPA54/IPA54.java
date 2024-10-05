package tcs_ipa.IPA54;

import java.util.*;

public class IPA54 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Resort[] resorts = new Resort[4];
        for (int i = 0; i < 4; i++){
            int a = sc.nextInt(); sc.nextLine();
            String b = sc.nextLine();
            String c = sc.nextLine();
            double d = sc.nextDouble();
            double e = sc.nextDouble(); sc.nextLine();
            resorts[i] = new Resort(a, b, c, d, e);
        }
        String category = sc.nextLine();
        int price = findAvgPrice(resorts, category);
        if (price == 0) System.out.println("No such Resort found");
        else System.out.println("The average price of " + category + ":" + price);
    }
    static int findAvgPrice(Resort[] resorts, String category){
        double sum = 0;
        int count = 0;
        for (Resort r : resorts)
            if (r.getCategory().equalsIgnoreCase(category) && r.getRating() > 4){
                sum += r.getPrice();
                count++;
            }
        return sum == 0 ? 0 : (int)(sum / count);
    }
}
class Resort {
    private int id;
    private String name, category;
    private double price, rating;
    public Resort(int id, String name, String category, double price, double rating){
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.rating = rating;
    }
    public String getCategory(){
        return this.category;
    }
    public double getPrice(){
        return this.price;
    }
    public double getRating(){
        return this.rating;
    }
}

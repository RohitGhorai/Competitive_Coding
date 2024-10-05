package tcs_ipa.IPA50;

import java.util.*;

public class IPA50 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Beach[] beaches = new Beach[4];
        for (int i = 0; i < 4; i++){
            int a = sc.nextInt(); sc.nextLine();
            String b = sc.nextLine();
            int c = sc.nextInt();
            int d = sc.nextInt(); sc.nextLine();
            beaches[i] = new Beach(a, b, c, d);
        }
        String name = sc.nextLine();
        int cost = sc.nextInt();
        int ans = findLeastRatingWithName(beaches, name, cost);
        if (ans == 0) System.out.println("No beach found");
        else System.out.println(ans);
    }
    static int findLeastRatingWithName(Beach[] beaches, String name, int cost){
        int min = Integer.MAX_VALUE;
        for (Beach b : beaches) if (b.getName().equalsIgnoreCase(name) && cost < b.getCost()) min = Math.min(min, b.getRating());
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
class Beach {
    private int id, rating, cost;
    private String name;
    public Beach(int id, String name, int rating, int cost){
        this.id = id;
        this.name = name;
        this.rating = rating;
        this.cost = cost;
    }
    public String getName(){
        return this.name;
    }
    public int getRating(){
        return this.rating;
    }
    public int getCost(){
        return this.cost;
    }
}

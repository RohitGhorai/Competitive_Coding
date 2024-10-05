package tcs_ipa.IPA2;

import java.util.*;

public class IPA2 {
    public static void main(String[] args){
        Footwear[] footwears = new Footwear[5];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 5; i++){
            int id = sc.nextInt(); sc.nextLine();
            String fName = sc.nextLine();
            String fType = sc.nextLine();
            int price = sc.nextInt(); sc.nextLine();
            footwears[i] = new Footwear(id, fName, fType, price);
        }
        String fType = sc.nextLine();
        String fName = sc.nextLine();
        int ans = getCountByType(footwears, fType);
        if (ans == 0) System.out.println("Footwear not available");
        else System.out.println(ans);
        Footwear res = getSecondHighestPriceByBrand(footwears, fName);
        if (res == null) System.out.println("Brand not available");
        else {
            System.out.println(res.getFootwearId());
            System.out.println(fName);
            System.out.println(res.getPrice());
        }
    }
    static int getCountByType(Footwear[] footwears, String fType){
        int count = 0;
        for (Footwear f : footwears) if (f.getFootwearType().equals(fType)) count++;
        return count;
    }
    static Footwear getSecondHighestPriceByBrand(Footwear[] footwears, String fName){
        List<Footwear> list = new ArrayList<>();
        for (Footwear f : footwears) if (f.getFootwearName().equals(fName)) list.add(f);
        Collections.sort(list, Comparator.comparingInt(Footwear::getPrice));
        return list.size() <= 1 ? null : list.get(list.size() - 2);
    }
}
class Footwear {
    private int footwearId, price;
    private String footwearName, footwearType;
    public Footwear(int fId, String fName, String fType, int price){
        this.footwearId = fId;
        this.footwearName = fName;
        this.footwearType = fType;
        this.price = price;
    }
    public int getFootwearId(){
        return this.footwearId;
    }
    public void setFootwearId(int id){
        this.footwearId = id;
    }
    public String getFootwearName(){
        return this.footwearName;
    }
    public void setFootwearName(String fName){
        this.footwearName = fName;
    }
    public String getFootwearType(){
        return this.footwearType;
    }
    public void setFootwearType(String fType){
        this.footwearType = fType;
    }
    public int getPrice(){
        return this.price;
    }
}

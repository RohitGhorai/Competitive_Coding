package tcs_ipa.IPA38;

import java.util.*;

public class IPA38 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        HeadSet[] headSets = new HeadSet[4];
        for (int i = 0; i < 4; i++){
            String a = sc.nextLine();
            String b = sc.nextLine();
            int c = sc.nextInt(); sc.nextLine();
            boolean d = sc.nextBoolean(); sc.nextLine();
            headSets[i] = new HeadSet(a, b, c, d);
        }
        String brand = sc.nextLine();
        int ans = findTotalPriceForGivenBrand(headSets, brand);
        if (ans == 0) System.out.println("No Headsets available with the given brand");
        else System.out.println(ans);
        HeadSet res = findAvailableHeadsetWithSecondMinPrice(headSets);
        if (res == null) System.out.println("No Headsets available");
        else System.out.println(res.getName() + "\n" + res.getPrice());
    }
    static int findTotalPriceForGivenBrand(HeadSet[] headsets, String brand){
        int total = 0;
        for (HeadSet h : headsets) if (h.getBrand().equalsIgnoreCase(brand)) total += h.getPrice();
        return total;
    }
    static HeadSet findAvailableHeadsetWithSecondMinPrice(HeadSet[] headsets){
        ArrayList<HeadSet> list = new ArrayList<>();
        for (HeadSet h : headsets) if (h.isAvailable()) list.add(h);
        list.sort(Comparator.comparingInt(HeadSet::getPrice));
        return list.size() <= 1 ? null : list.get(1);
    }
}
class HeadSet {
    private String name, brand;
    private int price;
    private boolean available;
    public HeadSet(String name, String brand, int price, boolean available){
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.available = available;
    }
    public String getName(){
        return this.name;
    }
    public String getBrand(){
        return this.brand;
    }
    public int getPrice(){
        return this.price;
    }
    public boolean isAvailable(){
        return this.available;
    }
}

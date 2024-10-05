package tcs_ipa.IPA15;

import java.util.*;

public class IPA15 {
    public static void main(String[] args){
        Phone[] phones = new Phone[4];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 4; i++){
            int a = sc.nextInt(); sc.nextLine();
            String b = sc.nextLine();
            String c = sc.nextLine();
            int d = sc.nextInt(); sc.nextLine();
            phones[i] = new Phone(a, b, c, d);
        }
        String brand = sc.nextLine();
        String os = sc.nextLine();
        int price = findPriceForGivenBrand(phones, brand);
        if (price == 0) System.out.println("The given brand is not available");
        else System.out.println(price);
        Phone res = getPhoneIdBasedOnOs(phones, os);
        if (res == null) System.out.println("No phones available with specified os and price range");
        else System.out.println(res.getPhoneId());
    }
    static int findPriceForGivenBrand(Phone[] phones, String brand){
        for (Phone p : phones) if (p.getBrand().equalsIgnoreCase(brand)) return p.getPrice();
        return 0;
    }
    static Phone getPhoneIdBasedOnOs(Phone[] phones, String os){
        for (Phone p : phones) if (p.getOs().equalsIgnoreCase(os) && p.getPrice() >= 50000) return p;
        return null;
    }
}
class Phone {
    private int id, price;
    private String os, brand;
    public Phone(int id, String os, String brand, int price){
        this.id = id;
        this.os = os;
        this.brand = brand;
        this.price = price;
    }
    public int getPhoneId(){
        return this.id;
    }
    public int getPrice(){
        return this.price;
    }
    public String getBrand(){
        return this.brand;
    }
    public String getOs(){
        return this.os;
    }
}

package tcs_ipa.IPA33;

import java.util.*;

public class IPA33 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Newspaper[] newspapers = new Newspaper[4];
        for (int i = 0; i < 4; i++){
            int a = sc.nextInt(); sc.nextLine();
            String b = sc.nextLine();
            int c = sc.nextInt();
            int d = sc.nextInt();
            newspapers[i] = new Newspaper(a, b, c, d);
        }
        int year = sc.nextInt(); sc.nextLine();
        String name = sc.nextLine();
        int totalPrice = findTotalPriceByPublicationYear(newspapers, year);
        if (totalPrice == 0) System.out.println("No Newspaper found with the mentioned attribute");
        else System.out.println(totalPrice);
        Newspaper res = searchNewspaperByName(newspapers, name);
        if (res == null) System.out.println("No Newspaper found with the given name");
        else System.out.println("regNo-" + res.getRegNo() + "\n" + "name-" + res.getName() + "\n" + "publicationYear-" + res.getPublicationYear() + "\n" + "price-" + res.getPrice());
    }
    static int findTotalPriceByPublicationYear(Newspaper[] newspapers, int year){
        int total = 0;
        for (Newspaper n : newspapers) if (n.getPublicationYear() == year) total += n.getPrice();
        return total;
    }
    static Newspaper searchNewspaperByName(Newspaper[] newspapers, String name){
        for (Newspaper n : newspapers) if (n.getName().equalsIgnoreCase(name)) return n;
        return null;
    }
}
class Newspaper {
    private int regNo, publicationYear, price;
    private String name;
    public Newspaper(int regNo, String name, int publicationYear, int price){
        this.regNo = regNo;
        this.name = name;
        this.publicationYear = publicationYear;
        this.price = price;
    }
    public int getRegNo(){
        return this.regNo;
    }
    public String getName(){
        return this.name;
    }
    public int getPublicationYear(){
        return this.publicationYear;
    }
    public int getPrice(){
        return this.price;
    }
}

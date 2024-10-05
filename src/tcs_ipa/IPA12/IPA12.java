package tcs_ipa.IPA12;

import java.util.*;

public class IPA12 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Medicine[] medicines = new Medicine[4];
        for (int i = 0; i < 4; i++) {
            String a = sc.nextLine();
            String b = sc.nextLine();
            String c = sc.nextLine();
            int d = sc.nextInt(); sc.nextLine();
            medicines[i] = new Medicine(a, b, c, d);
        }
        String disease = sc.nextLine();
        ArrayList<Integer> prices = getPriceByDisease(medicines, disease);
        for (int i : prices) System.out.println(i);
    }
    static ArrayList<Integer> getPriceByDisease(Medicine[] medicines, String disease){
        ArrayList<Integer> list = new ArrayList<>();
        for (Medicine m : medicines) if (m.getDisease().equalsIgnoreCase(disease)) list.add(m.getPrice());
        Collections.sort(list);
        return list;
    }
}
class Medicine {
    private String name, batch, disease;
    private int price;
    public Medicine(String name, String batch, String disease, int price){
        this.name = name;
        this.batch = batch;
        this.disease = disease;
        this.price = price;
    }
    public String getDisease(){
        return this.disease;
    }
    public int getPrice(){
        return this.price;
    }
}

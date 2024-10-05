package tcs_ipa.IPA48;

import java.util.*;

public class IPA48 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Bill[] bills = new Bill[n];
        for (int i = 0; i < n; i++){
            int a = sc.nextInt(); sc.nextLine();
            String b = sc.nextLine();
            String c = sc.nextLine();
            double d = sc.nextDouble(); sc.nextLine();
            boolean e = sc.nextBoolean(); sc.nextLine();
            bills[i] = new Bill(a, b, c, d, e);
        }
        boolean status = sc.nextBoolean(); sc.nextLine();
        String typeOfConnection = sc.nextLine();
        Bill res = findBillWithAmountBasedOnStatus(bills, status);
        if (res == null) System.out.println("There are no bill with the given status");
        else System.out.println(res.getBillNo() + "#" + res.getName());
        int ans = getCountWithTypeOfConnection(bills, typeOfConnection);
        if (ans == 0) System.out.println("There are no bills with given type of connection");
        else System.out.println(ans);
    }
    static Bill findBillWithAmountBasedOnStatus(Bill[] bills, boolean status){
        double maxBill = Double.MIN_VALUE;
        for (Bill b : bills) if (b.getStatus() == status) maxBill = Math.max(maxBill, b.getBillAmount());
        if (maxBill == Double.MIN_VALUE) return null;
        for (Bill b : bills) if (b.getBillAmount() == maxBill) return b;
        return null;
    }
    static int getCountWithTypeOfConnection(Bill[] bills, String typeOfConnection){
        int count = 0;
        for (Bill b : bills) if (b.getTypeOfConnection().equalsIgnoreCase(typeOfConnection)) count++;
        return count;
    }
}
class Bill {
    private int billNo;
    private String name, typeOfConnection;
    private double billAmount;
    private boolean status;
    public Bill(int billNo, String name, String typeOfConnection, double billAmount, boolean status){
        this.billNo = billNo;
        this.name = name;
        this.typeOfConnection = typeOfConnection;
        this.billAmount = billAmount;
        this.status = status;
    }
    public int getBillNo(){
        return this.billNo;
    }
    public String getName(){
        return this.name;
    }
    public double getBillAmount(){
        return this.billAmount;
    }
    public boolean getStatus(){
        return this.status;
    }
    public String getTypeOfConnection(){
        return this.typeOfConnection;
    }
}

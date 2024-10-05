package tcs_ipa.IPA5;

import java.util.*;

public class IPA5 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Motel[] motels = new Motel[4];
        for (int i = 0; i < 4; i++){
            int a = sc.nextInt(); sc.nextLine();
            String b = sc.nextLine();
            String c = sc.nextLine();
            int d = sc.nextInt(); sc.nextLine();
            String e = sc.nextLine();
            double f = sc.nextDouble(); sc.nextLine();
            motels[i] = new Motel(a, b, c, d, e, f);
        }
        String isFacility = sc.nextLine();
        int ans = totalNumberOfRoomBooked(motels, isFacility);
        if (ans == 0) System.out.println("No such rooms booked");
        else System.out.println(ans);
    }
    static int totalNumberOfRoomBooked(Motel[] motels, String cabFacility){
        int total = 0;
        for (Motel m : motels) if (m.getCabFacility().equals(cabFacility) && m.getNoOfBooked() > 5) total += m.getNoOfBooked();
        return total;
    }
}
class Motel {
    private int id, booked;
    private String name, date, cabFacility;
    private double totalBill;
    public Motel(int id, String name, String date, int booked, String cabFacility, double bill){
        this.id = id;
        this.name = name;
        this.date = date;
        this.booked = booked;
        this.cabFacility = cabFacility;
        this.totalBill = bill;
    }
    public int getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public String getDateOfBooking(){
        return this.date;
    }
    public int getNoOfBooked(){
        return this.booked;
    }
    public String getCabFacility(){
        return this.cabFacility;
    }
    public double getTotalBill(){
        return this.totalBill;
    }
}

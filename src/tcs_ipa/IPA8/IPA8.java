package tcs_ipa.IPA8;

import java.util.*;

public class IPA8 {
    public static void main(String[] args){
        Hotel[] hotels = new Hotel[4];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 4; i++) {
            int a = sc.nextInt(); sc.nextLine();
            String b = sc.nextLine();
            String c = sc.nextLine();
            int d = sc.nextInt(); sc.nextLine();
            String e = sc.nextLine();
            double f = sc.nextDouble(); sc.nextLine();
            hotels[i] = new Hotel(a, b, c, d, e, f);
        }
        String month = sc.nextLine();
        String wifiFacility = sc.nextLine();
        int ans = noOfRoomsBookedInGivenMonth(hotels, month);
        if (ans == 0) System.out.println("No rooms booked in the given month");
        else System.out.println(ans);
        Hotel res = searchHotelByWifiOption(hotels, wifiFacility);
        if (res == null) System.out.println("No such option available");
        else System.out.println(res.getId());
    }
    static String getMonthFromDate(String date){
        String[] str = date.split("-");
        return str[1].toLowerCase();
    }
    static int noOfRoomsBookedInGivenMonth(Hotel[] hotels, String month){
        int noOfRooms = 0;
        for (Hotel h : hotels) if (getMonthFromDate(h.getDateOfBooking()).equals(month.toLowerCase())) noOfRooms += h.getNoOfRoomsBooked();
        return noOfRooms;
    }
    static Hotel searchHotelByWifiOption(Hotel[] hotels, String wifiFacility){
        List<Hotel> list = new ArrayList<>();
        for (Hotel h : hotels) if (h.getWifiFacility().equals(wifiFacility)) list.add(h);
        Collections.sort(list, Comparator.comparingDouble(Hotel::getTotalBill));
        return list.size() <= 1 ? null : list.get(list.size() - 2);
    }
}
class Hotel {
    private int id, noOfRoomsBooked;
    private String name, dateOfBooking, wifiFacility;
    private double totalBill;
    public Hotel(int id, String name, String booking, int noOfBooked, String wifiFacility, double bill){
        this.id = id;
        this.name = name;
        this.dateOfBooking = booking;
        this.noOfRoomsBooked = noOfBooked;
        this.wifiFacility = wifiFacility;
    }
    public int getId(){
        return this.id;
    }
    public String getDateOfBooking(){
        return this.dateOfBooking;
    }
    public int getNoOfRoomsBooked(){
        return this.noOfRoomsBooked;
    }
    public double getTotalBill(){
        return this.totalBill;
    }
    public String getWifiFacility(){
        return this.wifiFacility;
    }
}

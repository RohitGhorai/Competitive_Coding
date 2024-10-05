package tcs_ipa.IPA32;

import java.util.*;

public class IPA32 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        TravelAgency[] agencies = new TravelAgency[4];
        for (int i = 0; i < 4; i++){
            int a = sc.nextInt(); sc.nextLine();
            String b = sc.nextLine();
            String c = sc.nextLine();
            int d = sc.nextInt(); sc.nextLine();
            boolean e = sc.nextBoolean(); sc.nextLine();
            agencies[i] = new TravelAgency(a, b, c, d, e);
        }
        int regNo = sc.nextInt(); sc.nextLine();
        String type = sc.nextLine();
        int maxPrice = findAgencyWithHighestPackagePrice(agencies);
        System.out.println(maxPrice);
        TravelAgency res = agencyDetailsForGivenIdAndType(agencies, regNo, type);
        if (res != null) System.out.println(res.getAgencyName() + ":" + res.getPrice());
    }
    static int findAgencyWithHighestPackagePrice(TravelAgency[] agencies){
        int max = Integer.MIN_VALUE;
        for (TravelAgency agency : agencies) max = Math.max(max, agency.getPrice());
        return max;
    }
    static TravelAgency agencyDetailsForGivenIdAndType(TravelAgency[] agencies, int regNo, String packageType){
        for (TravelAgency agency : agencies) if (agency.getRegNo() == regNo && agency.getPackageType().equalsIgnoreCase(packageType)) return agency;
        return null;
    }
}
class TravelAgency {
    private int regNo, price;
    private String agencyName, packageType;
    private boolean flightFacility;
    public TravelAgency(int regNo, String name, String type, int price, boolean facility){
        this.regNo = regNo;
        this.agencyName = name;
        this.packageType = type;
        this.price = price;
        this.flightFacility = facility;
    }
    public int getRegNo(){
        return this.regNo;
    }
    public String getAgencyName(){
        return this.agencyName;
    }
    public int getPrice(){
        return this.price;
    }
    public String getPackageType(){
        return this.packageType;
    }
}

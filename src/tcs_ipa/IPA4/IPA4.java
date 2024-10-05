package tcs_ipa.IPA4;

import java.util.*;

public class IPA4 {
    public static void main(String[] arrgs){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        College[] colleges = new College[n];
        for (int i = 0; i < 4; i++){
            int a = sc.nextInt(); sc.nextLine();
            String b = sc.nextLine();
            int c = sc.nextInt(); sc.nextLine();
            String d = sc.nextLine();
            int e = sc.nextInt(); sc.nextLine();
            colleges[i] = new College(a, b, c, d, e);
        }
        String search = sc.nextLine();
        College res1 = findCollegeWithMaximumPincode(colleges);
        if (res1 == null) System.out.println("No college found with mentioned attribute");
        else {
            System.out.println("id-" + res1.getId());
            System.out.println("name-" + res1.getName());
            System.out.println("contactNo-" + res1.getContactNo());
            System.out.println("address-" + res1.getAddress());
            System.out.println("pincode-" + res1.getPinCode());
        }
        College res2 = searchCollegeByAddress(colleges, search);
        if (res2 == null) System.out.println("No college found with mentioned attribute");
        else {
            System.out.println("id-" + res2.getId());
            System.out.println("name-" + res2.getName());
            System.out.println("contactNo-" + res2.getContactNo());
            System.out.println("address-" + res2.getAddress());
            System.out.println("pincode-" + res2.getPinCode());
        }
    }
    static College findCollegeWithMaximumPincode(College[] colleges){
        int max = Integer.MIN_VALUE;
        College res = null;
        for (College c : colleges)
            if (max < c.getPinCode()) {
                max = c.getPinCode();
                res = c;
        }
        return res;
    }
    static College searchCollegeByAddress(College[] colleges, String searchCollege){
        for (College c : colleges) if (c.getAddress().equals(searchCollege)) return c;
        return null;
    }
}
class College {
    private int id, contactNo, pinCode;
    private String name, address;
    public College(int id, String name, int contactNo, String address, int pin){
        this.id = id;
        this.name = name;
        this.contactNo = contactNo;
        this.address = address;
        this.pinCode = pin;
    }
    public int getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public int getContactNo(){
        return this.contactNo;
    }
    public String getAddress(){
        return this.address;
    }
    public int getPinCode(){
        return this.pinCode;
    }
}


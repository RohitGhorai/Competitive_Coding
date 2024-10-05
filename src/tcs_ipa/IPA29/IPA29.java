package tcs_ipa.IPA29;

import java.util.*;

public class IPA29 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Account[] accounts = new Account[4];
        for (int i = 0; i < 4; i++){
            int a = sc.nextInt(); sc.nextLine();
            double b = sc.nextDouble();
            double c = sc.nextDouble(); sc.nextLine();
            accounts[i] = new Account(a, b, c);
        }
        int time = sc.nextInt();
        //Map<Integer, Double> map = findInterest(accounts, time);
        //for (int a : map.keySet()) System.out.println(map.get(a) + " " + map.get(a));
    }
    /*static Map<Integer, Double> findInterest(Account[] accounts, int time){
        Map<Integer, Double> map = new HashMap<>();
        for (Account a : accounts) map.put(a.getId(), ((a.getInterestRate() * 100) / time) + a.getInterestRate());
        return map;
    }*/
}
class Account {
    private int id;
    private double balance, interestRate;
    public Account(int id, double balance, double interestRate){
        this.id = id;
        this.balance = balance;
        this.interestRate = interestRate;
    }
    public int getId(){
        return this.id;
    }
    public double getBalance(){
        return this.balance;
    }
    public double getInterestRate(){
        return this.interestRate;
    }
}

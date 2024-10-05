package tcs_ipa.IPA41;

import java.util.*;

public class IPA41 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Account[] accounts = new Account[3];
        for (int i = 0; i < 3; i++){
            int a = sc.nextInt(); sc.nextLine();
            String b = sc.nextLine();
            double c = sc.nextDouble(); sc.nextLine();
            accounts[i] = new Account(a, b, c);
        }
        int withdrawAccount = sc.nextInt(); sc.nextLine();
        double withdrawAmount = sc.nextDouble();
        int depositAccount = sc.nextInt(); sc.nextLine();
        double depositAmount = sc.nextDouble();
        double balance = withdraw(accounts, withdrawAccount, withdrawAmount);
        if (balance == -1) System.out.println("Sorry - Insufficient balance");
        else if (balance == -2) System.out.println("Sorry - Account not found");
        else System.out.println(balance);
        balance = deposit(accounts, depositAccount, depositAmount);
        if (balance == -1) System.out.println("Sorry - Account not found");
        else System.out.println(balance);
    }
    static double withdraw(Account[] accounts, int account, double amount){
        for (Account ac : accounts)
            if (ac.getAccountNumber() == account){
                double updatedBalance = ac.getBalance() - amount;
                if (updatedBalance >= 0) {
                    ac.setBalance(updatedBalance);
                    return updatedBalance;
                }
                else return -1;
            }
        return -2;
    }
    static double deposit(Account[] accounts, int account, double amount){
        for (Account ac : accounts)
            if (ac.getAccountNumber() == account) {
                double updatedBalance = ac.getBalance() + amount;
                if (updatedBalance >= 0) {
                    ac.setBalance(updatedBalance);
                    return updatedBalance;
                }
            }
        return -1;
    }
}
class Account {
    private int accountNumber;
    private String accountHolderName;
    private double balance;
    public Account(int accountNumber, String accountHolderName, double balance){
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }
    public int getAccountNumber(){
        return this.accountNumber;
    }
    public double getBalance(){
        return this.balance;
    }
    public void setBalance(double balance){
        this.balance = balance;
    }
}
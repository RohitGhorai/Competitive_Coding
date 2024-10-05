package tcs_ipa.IPA49;

import java.sql.*;
import java.text.*;
import java.util.*;

public class IPA49 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Account[] accounts = new Account[2];
        for (int i = 0; i < 2; i++){
            System.out.println("Account " + (i + 1) + ":");
            System.out.print("Account Number: ");
            String a = sc.nextLine();
            System.out.print("Account Holder Name: ");
            String b = sc.nextLine();
            System.out.print("Balance: ");
            double c = sc.nextDouble(); sc.nextLine();
            accounts[i] = new Account(a, b, c);
            System.out.println();
        }
        System.out.println("Transfer Details:");
        System.out.print("Amount: ");
        double amount = sc.nextDouble(); sc.nextLine();
        System.out.print("Transaction Code: ");
        String transactionCode = sc.nextLine();
        System.out.println();
        System.out.println("Before Transfer:" + "\n" + "Account 1: " + accounts[0].getAccountHolderName() + " - " + accounts[0].getAccountNumber() + " - " + accounts[0].getBalance());
        System.out.println("Account 2: " + accounts[1].getAccountHolderName() + " - " + accounts[1].getAccountNumber() + " - " + accounts[1].getBalance());
        System.out.println();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Transaction transaction = transferFunds(accounts[0], accounts[1], amount, transactionCode, sdf.format(timestamp));
        if (transaction != null) {
            System.out.println("After Transfer:" + "\n" + "Account 1: " + accounts[0].getAccountHolderName() + " - " + accounts[0].getAccountNumber() + " - " + accounts[0].getBalance());
            System.out.println("Account 2: " + accounts[1].getAccountHolderName() + " - " + accounts[1].getAccountNumber() + " - " + accounts[1].getBalance());
            System.out.println("Transaction Details:" + "\n" + "Transaction Code: " + transaction.getTransactionCode() + "\n" + "Amount Transferred: " + transaction.getAmount() + "\n" + "Timestamp: " + transaction.getTimestamp());
        }
        else System.out.println("Insufficient Balance in Account 1" + "\n" + transactionCode + "\n" + sdf.format(timestamp));

    }
    static Transaction transferFunds(Account fromAccount, Account toAccount, double amount, String transactionCode, String timestamp){
        double newBalance = fromAccount.getBalance() - amount;
        if (newBalance >= 0) {
            fromAccount.setBalance(newBalance);
            toAccount.setBalance(toAccount.getBalance() + amount);
            Transaction trans = new Transaction(transactionCode, amount, timestamp);
            return trans;
        }
        return null;
    }
}
class Transaction {
    private String transactionCode, timestamp;
    private double amount;
    public Transaction(String transactionCode, double amount, String timestamp){
        this.transactionCode = transactionCode;
        this.amount = amount;
        this.timestamp = timestamp;
    }
    public String getTransactionCode(){
        return this.transactionCode;
    }
    public double getAmount(){
        return this.amount;
    }
    public String getTimestamp(){
        return this.timestamp;
    }
}
class Account {
    private String accountNumber, accountHolderName;
    private double balance;
    public Account(String accountNumber, String accountHolderName, double balance){
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }
    public String getAccountNumber(){
        return this.accountNumber;
    }
    public String getAccountHolderName(){
        return this.accountHolderName;
    }
    public double getBalance(){
        return this.balance;
    }
    public void setBalance(double updatedBalance){
        this.balance = updatedBalance;
    }
}

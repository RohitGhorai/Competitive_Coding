package tcs_ipa.IPA45;

import java.util.*;

public class IPA45 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        int b = sc.nextInt(); sc.nextLine();
        double c = sc.nextDouble(); sc.nextLine();
        Employee employee = new Employee(a, b, c);
        double yearlySalary = employee.getSalary()*12;
        System.out.println("Yearly salary of " + employee.getName() + ": " + yearlySalary);
        double tax = calculateTax(yearlySalary);
        System.out.println("Tax to be paid by " + employee.getName() + ": " + tax);
    }
    static double calculateTax(double yearlySalary){
        if (yearlySalary <= 50000) return yearlySalary * 0.1;
        else if (yearlySalary > 50000 && yearlySalary <= 100000) return (yearlySalary - 50000) * 0.2 + 50000 * 0.1;
        else return (yearlySalary - 100000) * 0.3 + 50000 * 0.2 + 50000 * 0.1;
    }
}
class Employee {
    private String name;
    private int age;
    private double salary;
    public Employee(String name, int age, double salary){
        this.name = name;
        this.age = age;
        this.salary = salary;
    }
    public String getName(){
        return this.name;
    }
    public double getSalary(){
        return this.salary;
    }
}
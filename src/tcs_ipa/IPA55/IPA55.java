package tcs_ipa.IPA55;

import java.util.*;

public class IPA55 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Employee[] employees = new Employee[n];
        for (int i = 0; i < n; i++){
            int a = sc.nextInt(); sc.nextLine();
            String b = sc.nextLine();
            int c = sc.nextInt(); sc.nextLine();
            char d = sc.nextLine().charAt(0);
            double e = sc.nextDouble(); sc.nextLine();
            employees[i] = new Employee(a, b, c, d, e);
        }
        int age = sc.nextInt();
        Employee res = getEmployeeWithSecondLowestSalary(employees);
        if (res == null) System.out.println("Null");
        else System.out.println(res.getId() + "#" + res.getName());
        int count = countEmployeeBasedOnAge(employees, age);
        if (count == 0) System.out.println("No employee found for the given age");
        else System.out.println(count);
    }
    static Employee getEmployeeWithSecondLowestSalary(Employee[] employees){
        if (employees.length < 2) return null;
        double min = Double.MAX_VALUE;
        for (Employee e : employees) min = Math.min(min, e.getSalary());
        double secMin = Double.MAX_VALUE;
        Employee res = null;
        for (Employee e : employees){
            if (e.getSalary() > min && secMin > e.getSalary()){
                secMin = e.getSalary();
                res = e;
            }
        }
        return res;
    }
    static int countEmployeeBasedOnAge(Employee[] employees, int age){
        int count = 0;
        for (Employee e : employees) if (e.getAge() == age) count++;
        return count;
    }
}
class Employee {
    private int id, age;
    private String name;
    private char gender;
    private double salary;
    public Employee(int id, String name, int age, char gender, double salary){
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.salary = salary;
    }
    public int getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public double getSalary(){
        return this.salary;
    }
    public int getAge(){
        return this.age;
    }
}

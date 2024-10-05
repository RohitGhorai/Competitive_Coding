package tcs_ipa.IPA56;

import java.util.*;

public class IPA56 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter company name: ");
        String a = sc.nextLine();
        System.out.print("Enter number of employees: ");
        int n = sc.nextInt();
        System.out.println("Enter employee details:");
        Employee[] employees = new Employee[n];
        for (int j = 0; j < n; j++){
            System.out.println("Employee " + (j + 1) + ":");
            System.out.print("Enter id: ");
            int id = sc.nextInt(); sc.nextLine();
            System.out.print("Enter name: ");
            String name = sc.nextLine();
            System.out.print("Enter designation: ");
            String designation = sc.nextLine();
            System.out.print("Enter salary: ");
            double salary = sc.nextDouble(); sc.nextLine();
            employees[j] = new Employee(id, name, designation, salary);
        }
        Company company = new Company(a, employees, n);
        double averageSalary = company.getAverageSalary();
        double maxSalary = company.getMaxSalary();
        System.out.println("Average salary: " + averageSalary);
        System.out.println("Max salary: " + maxSalary);
        System.out.print("Employees with designation: ");
        String designation = sc.nextLine();
        ArrayList<Employee> list = company.getEmployeesByDesignation(designation);
        if (list != null)
            for (Employee e : list) {
                System.out.println("ID: " + e.getId() + ", Name: " + e.getName() + ", Designation: " + e.getDesignation() + ", Salary: " + e.getSalary());
            }
        else System.out.println("There is no employee with given this \"" + designation +"\" designation");
    }
}
class Company {
    private String name;
    private Employee[] employees;
    private int numEmployees;
    public Company(String name, Employee[] employees, int numEmployees){
        this.name = name;
        this.employees = employees;
        this.numEmployees = numEmployees;
    }
    public double getAverageSalary(){
        double totalSalary = 0;
        for (Employee e : this.employees) totalSalary += e.getSalary();
        return totalSalary == 0 ? 0 : (double)(totalSalary/this.employees.length);
    }
    public double getMaxSalary(){
        double max = 0;
        for (Employee e : this.employees) max = Math.max(max, e.getSalary());
        return max;
    }
    public ArrayList<Employee> getEmployeesByDesignation(String designation){
        ArrayList<Employee> list = new ArrayList<>();
        for (Employee e : employees) if (e.getDesignation().equalsIgnoreCase(designation)) list.add(e);
        return list.isEmpty() ? null : list;
    }
}
class Employee {
    private int id;
    private String name, designation;
    private double salary;
    public Employee(int id, String name, String designation, double salary){
        this.id = id;
        this.name = name;
        this.designation = designation;
        this.salary = salary;
    }
    public int getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public String getDesignation(){
        return this.designation;
    }
    public double getSalary(){
        return this.salary;
    }
}

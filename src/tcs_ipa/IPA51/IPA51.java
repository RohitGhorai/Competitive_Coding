package tcs_ipa.IPA51;

import java.util.*;

public class IPA51 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Employee[] employees = new Employee[5];
        for (int i = 0; i < 5; i++){
            int a = sc.nextInt(); sc.nextLine();
            String b = sc.nextLine();
            String c = sc.nextLine();
            int d = sc.nextInt();
            int e = sc.nextInt();
            employees[i] = new Employee(a, b, c, d, e);
        }
        int salary = sc.nextInt(); sc.nextLine();
        String dept = sc.nextLine();
        ArrayList<Employee> list = findDept(employees, salary);
        if (list == null) System.out.println("No Department found");
        else for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i).getDept());
            if (list.size() - 1 > i) System.out.print(", ");
        }
        System.out.println();
        int ans = findSecondHighestSalary(employees, dept);
        if (ans == 0) System.out.println("No data found");
        else System.out.println(ans);
    }
    static ArrayList<Employee> findDept(Employee[] employees, int salary){
        ArrayList<Employee> list = new ArrayList<>();
        for (Employee e : employees) if (e.getSalary() == salary && e.getRating() >= 3) list.add(e);
        return list.isEmpty() ? null : list;
    }
    static int findSecondHighestSalary(Employee[] employees, String dept){
        int max = Integer.MIN_VALUE;
        for (Employee e : employees) if (e.getDept().equalsIgnoreCase(dept)) max = Math.max(max, e.getSalary());
        if (max == Integer.MIN_VALUE) return 0;
        int secMax = Integer.MIN_VALUE;
        for (Employee e : employees) if (e.getDept().equalsIgnoreCase(dept) && max > e.getSalary()) secMax = Math.max(secMax, e.getSalary());
        return secMax;
    }
}
class Employee {
    private int id, rating, salary;
    private String name, dept;
    public Employee(int id, String name, String dept, int rating, int salary){
        this.id = id;
        this.name = name;
        this.dept = dept;
        this.rating = rating;
        this.salary = salary;
    }
    public String getDept(){
        return this.dept;
    }
    public int getSalary(){
        return this.salary;
    }
    public int getRating(){
        return this.rating;
    }
}

package tcs_ipa.IPA10;

import java.util.*;

public class IPA10 {
    public static void main(String[] args){
        Employee[] employees = new Employee[4];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 4; i++){
            int a = sc.nextInt(); sc.nextLine();
            String b = sc.nextLine();
            String c = sc.nextLine();
            double d = sc.nextDouble(); sc.nextLine();
            boolean e = sc.nextBoolean(); sc.nextLine();
            employees[i] = new Employee(a, b, c, d, e);
        }
        String branch = sc.nextLine();
        int ans = findCountOfEmployeesUsingCompanyTransport(employees, branch);
        if (ans == 0) System.out.println("No such Employees");
        else System.out.println(ans);
        Employee res = findEmployeeWithSecondHighestRating(employees);
        if (res == null) System.out.println("All Employees using company transport");
        else System.out.println(res.getId() + "\n" + res.getName());
    }
    static int findCountOfEmployeesUsingCompanyTransport(Employee[] employees, String branch){
        int count = 0;
        for (Employee e : employees) if (e.getBranch().equals(branch) && e.getCompanyTransport()) count++;
        return count;
    }
    static Employee findEmployeeWithSecondHighestRating(Employee[] employees){
        List<Employee> list = new ArrayList<>();
        for (Employee e : employees) if (!e.getCompanyTransport()) list.add(e);
        Collections.sort(list, Comparator.comparingDouble(Employee::getRating));
        return list.size() <= 1 ? null : list.get(list.size() - 2);
    }
}
class Employee {
    private int employeeId;
    private String name, branch;
    private double rating;
    private boolean companyTransport;
    public Employee(int id, String name, String branch, double rating, boolean transport){
        this.employeeId = id;
        this.name = name;
        this.branch = branch;
        this.rating = rating;
        this.companyTransport = transport;
    }
    public int getId(){
        return this.employeeId;
    }
    public String getName(){
        return this.name;
    }
    public String getBranch(){
        return this.branch;
    }
    public double getRating(){
        return this.rating;
    }
    public boolean getCompanyTransport(){
        return this.companyTransport;
    }
}

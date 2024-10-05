package tcs_ipa.IPA13;

import java.util.*;

public class IPA13 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        AutonomousCar[] cars = new AutonomousCar[4];
        for (int i = 0; i < 4; i++){
            int a = sc.nextInt(); sc.nextLine();
            String b = sc.nextLine();
            int c = sc.nextInt();
            int d = sc.nextInt(); sc.nextLine();
            String e = sc.nextLine();
            cars[i] = new AutonomousCar(a, b, c, d, e);
        }
        String env = sc.nextLine();
        String brand = sc.nextLine();
        int ans = findTestPassedByEnv(cars, env);
        if (ans == 0) System.out.println("There are no tests passed in this particular environment");
        else System.out.println(ans);
        AutonomousCar res = updateCarGrade(cars, brand);
        if (res == null) System.out.println("No car is available with the specified brand");
        else System.out.println(res.getBrand());
    }
    static int findTestPassedByEnv(AutonomousCar[] cars, String env){
        int sum = 0;
        for (AutonomousCar a : cars) if (a.getEnvironment().equalsIgnoreCase(env)) sum += a.getNoOfTestsPassed();
        return sum;
    }
    static AutonomousCar updateCarGrade(AutonomousCar[] cars, String brand){
        for (AutonomousCar a : cars) {
            if (a.getBrand().equalsIgnoreCase(brand)){
                int rating = (a.getNoOfTestsPassed() * 100)/a.getNoOfTestsConducted();
                if (rating >= 80) a.setBrand(a.getBrand() + "::A1");
                else a.setBrand(a.getBrand() + "::B2");
                return a;
            }
        }
        return null;
    }
}
class AutonomousCar {
    private int carId, noOfTestsConducted, noOfTestsPassed;
    private String brand, environment;
    public AutonomousCar(int id, String brand, int noOfTestsConducted, int noOfTestsPassed, String environment){
        this.carId = id;
        this.brand = brand;
        this.noOfTestsConducted = noOfTestsConducted;
        this.noOfTestsPassed = noOfTestsPassed;
        this.environment = environment;
    }
    public int getNoOfTestsConducted(){
        return this.noOfTestsConducted;
    }
    public int getNoOfTestsPassed(){
        return this.noOfTestsPassed;
    }
    public String getBrand(){
        return this.brand;
    }
    public void setBrand(String b){
        this.brand = b;
    }
    public String getEnvironment(){
        return this.environment;
    }
}

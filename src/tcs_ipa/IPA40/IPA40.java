package tcs_ipa.IPA40;

import java.util.*;

public class IPA40 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Car[] cars = new Car[4];
        for (int i = 0; i < 4; i++){
            String a = sc.nextLine();
            String b = sc.nextLine();
            int c = sc.nextInt(); sc.nextLine();
            double d = sc.nextDouble(); sc.nextLine();
            cars[i] = new Car(a, b, c, d);
        }
        String make = sc.nextLine();
        String model = sc.nextLine();
        Car res = findMostExpensiveCar(cars);
        if (res == null) System.out.println("Sorry - No car is available");
        else System.out.println(res.getMake() + "\n" + res.getModel() + "\n" + res.getYear() + "\n" + res.getPrice());
        res = getCarByMakeAndModel(cars, make, model);
        if (res == null) System.out.println("Sorry - No car is available");
        else System.out.println(res.getYear() + "\n" + res.getPrice());
    }
    static Car findMostExpensiveCar(Car[] cars){
        /*
        ArrayList<Car> list = new ArrayList<>(Arrays.asList(cars));
        list.sort(Comparator.comparingDouble(Car::getPrice));
        return list.size() == 0 ? null : list.get(list.size() - 1);
         */
        double max = Double.MIN_VALUE;
        for (Car c : cars) max = Math.max(max, c.getPrice());
        if (max == Double.MIN_VALUE) return null;
        for (Car c : cars) if (max == c.getPrice()) return c;
        return null;
    }
    static Car getCarByMakeAndModel(Car[] cars, String make, String model){
        for (Car c : cars) if (c.getMake().equalsIgnoreCase(make) && c.getModel().equalsIgnoreCase(model)) return c;
        return null;
    }
}
class Car {
    private String make, model;
    private int year;
    private double price;
    public Car(String make, String model, int year, double price){
        this.make = make;
        this.model = model;
        this.year = year;
        this.price = price;
    }
    public String getMake(){
        return this.make;
    }
    public int getYear(){
        return this.year;
    }
    public String getModel(){
        return this.model;
    }
    public double getPrice(){
        return this.price;
    }
}

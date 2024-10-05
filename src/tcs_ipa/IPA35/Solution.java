package tcs_ipa.IPA35;

import java.util.*;

public class Solution {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Car[] cars = new Car[5];
        for (int i = 0; i < 5; i++){
            int a = sc.nextInt(); sc.nextLine();
            String b = sc.nextLine();
            String c = sc.nextLine();
            cars[i] = new Car(a, b, c);
        }
        int removeId = sc.nextInt();
        ArrayList<Car> rearrangeCars = removeAndRearrange(cars, removeId);
        if (rearrangeCars != null) for (Car c : rearrangeCars) System.out.println(c.getId() + " : " + c.getName());
        else System.out.println("There are no car with given id");
    }
    static ArrayList<Car> removeAndRearrange(Car[] cars, int removeId){
        ArrayList<Car> list = new ArrayList<>();
        int prevId = removeId;
        int i = 0;
        for (Car c : cars) {
            if (c.getId() == removeId) {
                i++;
                break;
            }
            else {
                list.add(c);
                i++;
            }
        }
        if (list.size() == cars.length) return null;
        for (int k = i; k < cars.length; k++){
            list.add(new Car(prevId, cars[k].getName(), cars[k].getFuelType()));
            prevId = cars[k].getId();
        }
        return list;
    }
}
class Car {
    private int id;
    private String name, fuelType;
    public Car(int id, String name, String fuelType){
        this.id = id;
        this.name = name;
        this.fuelType = fuelType;
    }
    public int getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public String getFuelType(){
        return this.fuelType;
    }
}

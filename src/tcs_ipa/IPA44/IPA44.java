package tcs_ipa.IPA44;

import java.util.*;

public class IPA44 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Rectangle[] rectangles = new Rectangle[2];
        for (int i = 0; i < 2; i++){
            double a = sc.nextDouble();
            double b = sc.nextDouble();
            rectangles[i] = new Rectangle(a, b);
        }
        for (Rectangle r : rectangles) {
            System.out.println(calculateArea(r));
            System.out.println(calculatePerimeter(r));
        }
    }
    static double calculateArea(Rectangle r){
        return r.getLength()*r.getBreadth();
    }
    static double calculatePerimeter(Rectangle r){
        return 2*(r.getLength() + r.getBreadth());
    }
}
class Rectangle {
    private double length, breadth;
    public Rectangle(double length, double breadth){
        this.length = length;
        this.breadth = breadth;
    }
    public double getLength(){
        return this.length;
    }
    public double getBreadth(){
        return this.breadth;
    }
}

package tcs_ipa.IPA20;

import java.util.*;

public class IPA20 {
    public static void main(String[] args){
        Engine[] engines = new Engine[4];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 4; i++){
            int a = sc.nextInt(); sc.nextLine();
            String b = sc.nextLine();
            String c = sc.nextLine();
            double d = sc.nextDouble(); sc.nextLine();
            engines[i] = new Engine(a, b, c, d);
        }
        String type = sc.nextLine();
        String name = sc.nextLine();
        int ans = findAvgEnginePriceByType(engines, type);
        if (ans == 0) System.out.println("There are no engine with given type");
        else System.out.println(ans);
        ArrayList<Engine> list = searchEngineByName(engines, name);
        if (list == null) System.out.println("There are no engine with the given name");
        else for (Engine res : list) System.out.println(res.getId());
    }
    static int findAvgEnginePriceByType(Engine[] engines, String type){
        int sum = 0, count = 0;
        for (Engine e : engines)
            if (e.getType().equalsIgnoreCase(type)) {
                sum += e.getPrice();
                count++;
            }
        return sum == 0 ? 0 : sum / count;
    }
    static ArrayList<Engine> searchEngineByName(Engine[] engines, String name){
        ArrayList<Engine> list = new ArrayList<>();
        for (Engine e : engines) if (e.getName().equalsIgnoreCase(name)) list.add(e);
        return list.size() == 0 ? null : list;
    }
}
class Engine {
    private int id;
    private String name, type;
    private double price;
    public Engine(int id, String name, String type, double price){
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
    }
    public int getId(){
        return this.id;
    }
    public String getType(){
        return this.type;
    }
    public String getName(){
        return this.name;
    }
    public double getPrice(){
        return this.price;
    }
}

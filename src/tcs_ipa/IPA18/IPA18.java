package tcs_ipa.IPA18;

import java.util.*;

public class IPA18 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Antenna[] antennas = new Antenna[4];
        for (int i = 0; i < 4; i++){
            int a = sc.nextInt(); sc.nextLine();
            String b = sc.nextLine();
            String c = sc.nextLine();
            double d = sc.nextDouble(); sc.nextLine();
            antennas[i] = new Antenna(a, b, c, d);
        }
        String name = sc.nextLine();
        double vswr = sc.nextDouble();
        int ans = searchAntennaByName(antennas, name);
        if (ans == 0) System.out.println("There is no antenna with the given parameter");
        else System.out.println(ans);
        ArrayList<Antenna> list = sortAntennaByVswr(antennas, vswr);
        if (list == null) System.out.println("No Antenna found");
        else for (Antenna a : list) System.out.println(a.getProjectLead());
    }
    static int searchAntennaByName(Antenna[] antennas, String name){
        for (Antenna a : antennas) if (a.getName().equals(name)) return a.getId();
        return 0;
    }
    static ArrayList<Antenna> sortAntennaByVswr(Antenna[] antennas, double vswr){
        ArrayList<Antenna> list = new ArrayList<>();
        for (Antenna a : antennas) if (a.getVswr() < vswr) list.add(a);
        Collections.sort(list, Comparator.comparingDouble(Antenna::getVswr));
        return list.size() == 0 ? null : list;
    }
}
class Antenna {
    private int id;
    private String name, projectLead;
    private double vswr;
    public Antenna(int id, String name, String lead, double vswr){
        this.id = id;
        this.name = name;
        this.projectLead = lead;
        this.vswr = vswr;
    }
    public int getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public String getProjectLead(){
        return this.projectLead;
    }
    public double getVswr(){
        return this.vswr;
    }
}

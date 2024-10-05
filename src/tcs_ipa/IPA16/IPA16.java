package tcs_ipa.IPA16;

import java.util.*;

public class IPA16 {
    public static void main(String[] args){
        NavalVessel[] navals = new NavalVessel[4];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 4; i++){
            int a = sc.nextInt(); sc.nextLine();
            String b = sc.nextLine();
            int c = sc.nextInt();
            int d = sc.nextInt(); sc.nextLine();
            String e = sc.nextLine();
            navals[i] = new NavalVessel(a, b, c, d, e);
        }
        int percentage = sc.nextInt(); sc.nextLine();
        String purpose = sc.nextLine();
        int ans = findAvgVoyagesByPct(navals, percentage);
        System.out.println(ans);
        NavalVessel res = findVesselByGrade(navals, purpose);
        if (res != null) System.out.println(res.getVesselName());
        else System.out.println("No Naval Vessel is available with the specified purpose");
    }
    static int findAvgVoyagesByPct(NavalVessel[] navals, int percentage){
        int sum = 0, count = 0;
        for (NavalVessel n : navals) {
            int p = (n.getNoOfVoyagesCompleted() * 100) / n.getNoOfVoyagesPlanned();
            if (p >= percentage) {
                sum += n.getNoOfVoyagesCompleted();
                count++;
            }
        }
        return sum == 0 ? 0 : sum / count;
    }
    static NavalVessel findVesselByGrade(NavalVessel[] navals, String purpose){
        for (NavalVessel n : navals) {
            if (n.getPurpose().equalsIgnoreCase(purpose)) {
                int p = (n.getNoOfVoyagesCompleted() * 100) / n.getNoOfVoyagesPlanned();
                String name = n.getVesselName();
                if (p == 100) n.setVesselName(name + "%Star");
                else if (p < 99 && p > 80) n.setVesselName(name + "%Leader");
                else if (p < 79 && p > 55) n.setVesselName(name + "%Inspirer");
                else n.setVesselName(name + "%Striver");
                return n;
            }
        }
        return null;
    }
}
class NavalVessel {
    private int vesselId, noOfVoyagesPlanned, noOfVoyagesCompleted;
    private String vesselName, purpose;
    public NavalVessel(int id, String name, int noOfVoyagesPlanned, int noOfVoyagesCompleted, String purpose){
        this.vesselId = id;
        this.vesselName = name;
        this.noOfVoyagesPlanned = noOfVoyagesPlanned;
        this.noOfVoyagesCompleted = noOfVoyagesCompleted;
        this.purpose = purpose;
    }
    public String getPurpose(){
        return this.purpose;
    }
    public int getNoOfVoyagesPlanned(){
        return this.noOfVoyagesPlanned;
    }
    public int getNoOfVoyagesCompleted(){
        return this.noOfVoyagesCompleted;
    }
    public String getVesselName(){
        return this.vesselName;
    }
    public void setVesselName(String name){
        this.vesselName = name;
    }
}

package tcs_ipa.IPA28;

import java.util.*;

public class IPA28 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Team[] teams = new Team[n];
        for (int i = 0; i < n; i++){
            int a = sc.nextInt(); sc.nextLine();
            String b = sc.nextLine();
            String c = sc.nextLine();
            int d = sc.nextInt();
            teams[i] = new Team(a, b, c, d);
        }
        int run = sc.nextInt(); sc.nextLine();
        String country = sc.nextLine();
        Team team = findPlayer(teams, run, country);
        if (team == null) System.out.println("No team is found from the given country and run");
        else System.out.println(team.getId() + "\n" + team.getName() + "\n" + team.getCountry() + "\n" + team.getRun());
    }
    static Team findPlayer(Team[] teams, int run, String country){
        for (Team t : teams) if (t.getCountry().equalsIgnoreCase(country) && t.getRun() > run) return t;
        return null;
    }
}
class Team {
    private int id, run;
    private String name, country;
    public Team(int id, String name, String country, int run){
        this.id = id;
        this.name = name;
        this.country = country;
        this.run = run;
    }
    public int getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public String getCountry(){
        return this.country;
    }
    public int getRun(){
        return this.run;
    }
}

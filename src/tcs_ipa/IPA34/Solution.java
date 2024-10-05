package tcs_ipa.IPA34;

import java.util.*;

public class Solution {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Player[] players = new Player[n];
        for (int i = 0; i < n; i++){
            int a = sc.nextInt(); sc.nextLine();
            String b = sc.nextLine();
            String c = sc.nextLine();
            int d = sc.nextInt();
            int e = sc.nextInt(); sc.nextLine();
            players[i] = new Player(a, b, c, d, e);
        }
        String country = sc.nextLine();
        int run = sc.nextInt();
        ArrayList<Player> list = findPlayerName(players, country, run);
        if (list == null) System.out.println("No player found");
        else for (Player p : list) System.out.println(p.getId() + " : " + p.getName());
    }
    static ArrayList<Player> findPlayerName(Player[] players, String country, int run){
        ArrayList<Player> list = new ArrayList<>();
        for (Player p : players) if (p.getCountry().equalsIgnoreCase(country) && p.getRunsScored() > run) list.add(p);
        if (list.size() != 0) Collections.sort(list, Comparator.comparing(Player::getName));
        return list.size() == 0 ? null : list;
    }
}
class Player {
    private int id, matchesPlayed, runsScored;
    private String name, country;
    public Player(int id, String name, String country, int matchesPlayed, int runsScored){
        this.id = id;
        this.name = name;
        this.country = country;
        this.matchesPlayed = matchesPlayed;
        this.runsScored = runsScored;
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
    public int getRunsScored(){
        return this.runsScored;
    }
}

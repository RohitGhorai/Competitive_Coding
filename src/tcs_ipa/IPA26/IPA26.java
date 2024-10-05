package tcs_ipa.IPA26;

import java.util.*;

public class IPA26 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Player[] players = new Player[4];
        for (int i = 0; i < 4; i++){
            int a = sc.nextInt(); sc.nextLine();
            String b = sc.nextLine();
            int c = sc.nextInt();
            int d = sc.nextInt();
            int e = sc.nextInt();
            players[i] = new Player(a, b, c, d, e);
        }
        int target = sc.nextInt();
        ArrayList<Integer> list = findAverageOfRuns(players, target);
        for (int i : list) {
            if (i < 100 && i > 80) System.out.println("Grade A");
            else if (i < 79 && i > 50) System.out.println("Grade B");
            else System.out.println("Grade C");
        }
    }
    static ArrayList<Integer> findAverageOfRuns(Player[] players, int target){
        ArrayList<Integer> list = new ArrayList<>();
        for (Player p : players) if (p.getMatchesPlayed() >= target) list.add(p.getRuns()/p.getMatchesPlayed());
        return list;
    }
}
class Player {
    private int id, iccRank, matchesPlayed, runScored;
    private String name;
    public Player(int id, String name, int iccRank, int matchesPlayed, int runScored){
        this.id = id;
        this.name = name;
        this.iccRank = iccRank;
        this.matchesPlayed = matchesPlayed;
        this.runScored = runScored;
    }
    public int getRuns(){
        return this.runScored;
    }
    public int getMatchesPlayed(){
        return this.matchesPlayed;
    }
}

package tcs_ipa.IPA11;

import java.util.*;

public class IPA11 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Player[] players = new Player[4];
        for (int i = 0; i < 4; i++){
            int a = sc.nextInt(); sc.nextLine();
            String b = sc.nextLine();
            String c = sc.nextLine();
            int d = sc.nextInt(); sc.nextLine();
            players[i] = new Player(a, b, c, d);
        }
        String skill = sc.nextLine();
        String level = sc.nextLine();
        int ans = findPointsForGivenSkill(players, skill);
        if (ans == 0) System.out.println("The given Skill is not available");
        else System.out.println(ans);
        Player res = getPlayerBasedOnLevel(players, skill, level);
        if (res == null) System.out.println("No player is available with specified level, skill ans eligibility points");
        else System.out.println(res.getPlayerId());
    }
    static int findPointsForGivenSkill(Player[] players, String skill){
        int sum = 0;
        for (Player p : players) if (p.getSkill().toLowerCase().equals(skill.toLowerCase())) sum += p.getPoints();
        return sum;
    }
    static Player getPlayerBasedOnLevel(Player[] players, String skill, String level){
        for (Player p : players) if (p.getSkill().equalsIgnoreCase(skill) && p.getLevel().equalsIgnoreCase(level) && p.getPoints() >= 20) return p;
        return null;
    }
}
class Player {
    private int playerId, points;
    private String skill, level;
    public Player(int id, String skill, String level, int points){
        this.playerId = id;
        this.skill = skill;
        this.level = level;
        this.points = points;
    }
    public int getPlayerId(){
        return this.playerId;
    }
    public String getSkill(){
        return this.skill;
    }
    public int getPoints(){
        return this.points;
    }
    public String getLevel(){
        return this.level;
    }
}

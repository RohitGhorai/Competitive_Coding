package tcs_ipa.IPA46;

import java.util.*;

public class IPA46 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Player[] players = new Player[4];
        for (int i = 0; i < 4; i++){
            int a = sc.nextInt(); sc.nextLine();
            String b = sc.nextLine();
            String c = sc.nextLine();
            double d = sc.nextDouble(); sc.nextLine();
            players[i] = new Player(a, b, c, d);
        }
        String searchPlayer = sc.nextLine();
        ArrayList<Player> list = searchPlayerForMatch(players, searchPlayer);
        if (list != null) for (Player p : list) System.out.println(p.getId());
    }
    static ArrayList<Player> searchPlayerForMatch(Player[] players, String player){
        ArrayList<Player> list = new ArrayList<>();
        for (Player p : players) if (p.getSide().equalsIgnoreCase(player)) list.add(p);
        return list.isEmpty() ? null : list;
    }
}
class Player {
    private int id;
    private String country, side;
    private double price;
    public Player(int id, String country, String side, double price){
        this.id = id;
        this.country = country;
        this.side = side;
        this.price = price;
    }
    public int getId(){
        return this.id;
    }
    public String getSide(){
        return this.side;
    }
}

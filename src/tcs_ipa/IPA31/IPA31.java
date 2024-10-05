package tcs_ipa.IPA31;

import java.util.*;

public class IPA31 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Music[] musics = new Music[4];
        for (int i = 0; i < 4; i++){
            int a = sc.nextInt(); sc.nextLine();
            String b = sc.nextLine();
            int c = sc.nextInt(); sc.nextLine();
            double d = sc.nextDouble(); sc.nextLine();
            musics[i] = new Music(a, b, c, d);
        }
        int count = sc.nextInt();
        int duration = sc.nextInt();
        int ans = findAvgOfCount(musics, count);
        if (ans == 0) System.out.println("No playlist found");
        else System.out.println(ans);
        ArrayList<Music> list = sortTypeByDuration(musics, duration);
        if (list == null) System.out.println("No playlist found with mentioned attribute");
        else for (Music m : list) System.out.println(m.getType());
    }
    static int findAvgOfCount(Music[] musics, int count){
        int sum = 0, c = 0;
        for (Music m : musics)
            if (m.getCount() > count) {
                sum += m.getCount();
                c++;
            }
        return sum == 0 ? 0 : sum / c;
    }
    static ArrayList<Music> sortTypeByDuration(Music[] musics, int duration){
        ArrayList<Music> list = new ArrayList<>();
        for (Music m : musics) if (m.getDuration() > duration) list.add(m);
        Collections.sort(list, Comparator.comparingDouble(Music::getDuration));
        return list.size() == 0 ? null : list;
    }
}
class Music {
    private int playListNo, count;
    private String type;
    private double duration;
    public Music(int playListNo, String type, int count, double duration){
        this.playListNo = playListNo;
        this.type = type;
        this.count = count;
        this.duration = duration;
    }
    public int getCount(){
        return this.count;
    }
    public String getType(){
        return this.type;
    }
    public double getDuration(){
        return this.duration;
    }
}

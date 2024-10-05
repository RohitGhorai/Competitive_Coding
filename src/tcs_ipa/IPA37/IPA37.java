package tcs_ipa.IPA37;

import java.util.*;

public class IPA37 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Song[] songs = new Song[5];
        for (int i = 0; i < 5; i++){
            int a = sc.nextInt(); sc.nextLine();
            String b = sc.nextLine();
            String c = sc.nextLine();
            double d = sc.nextDouble(); sc.nextLine();
            songs[i] = new Song(a, b, c, d);
        }
        String artist1 = sc.nextLine();
        String artist2 = sc.nextLine();
        double ans = findSongsDurationForArtist(songs, artist1);
        if (ans == 0) System.out.println("There are no songs with given artist");
        else System.out.println(ans);
        ArrayList<Song> list = getSongsInAscendingOrder(songs, artist2);
        if (list == null) System.out.println("There are no songs with given artist");
        else for (Song s : list) System.out.println(s.getId() + "\n" + s.getTitle());
    }
    static double findSongsDurationForArtist(Song[] songs, String artist){
        double ans = 0;
        for (Song s : songs) if (s.getArtist().equalsIgnoreCase(artist)) ans += s.getDuration();
        return ans;
    }
    static ArrayList<Song> getSongsInAscendingOrder(Song[] songs, String artist){
        ArrayList<Song> list = new ArrayList<>();
        for (Song s : songs) if (s.getArtist().equalsIgnoreCase(artist)) list.add(s);
        if (list.size() == 0) return null;
        list.sort(Comparator.comparingDouble(Song::getDuration));
        return list;
    }
}
class Song {
    private int id;
    private String title, artist;
    private double duration;
    public Song(int id, String title, String artist, double duration){
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.duration = duration;
    }
    public int getId(){
        return this.id;
    }
    public String getTitle(){
        return this.title;
    }
    public double getDuration(){
        return this.duration;
    }
    public String getArtist(){
        return  this.artist;
    }
}

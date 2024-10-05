package tcs_ipa.IPA14;

import java.util.*;

public class IPA14 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Movie[] movies = new Movie[4];
        for (int i = 0; i < 4; i++){
            String a = sc.nextLine();
            String b = sc.nextLine();
            String c = sc.nextLine();
            int d = sc.nextInt(); sc.nextLine();
            movies[i] = new Movie(a, b, c, d);
        }
        String genre = sc.nextLine();
        ArrayList<String> list = getMovieByGenre(movies, genre);
        for (String s : list) System.out.println(s);
    }
    static ArrayList<String> getMovieByGenre(Movie[] movies, String genre){
        ArrayList<String> list = new ArrayList<>();
        for (Movie m : movies)
            if (m.getGenre().equalsIgnoreCase(genre)) {
                if (m.getBudget() > 80000000) list.add("High Budget Movie");
                else list.add("Low Budget Movie");
            }
        return list;
    }
}
class Movie {
    private String name, company, genre;
    private int budget;
    public Movie(String name, String company, String genre, int budget){
        this.name = name;
        this.company = company;
        this.genre = genre;
        this.budget = budget;
    }
    public String getGenre(){
        return this.genre;
    }
    public int getBudget(){
        return this.budget;
    }
}

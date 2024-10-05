package tcs_ipa.IPA25;

import java.util.*;

public class IPA25 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Cinema[] cinemas = new Cinema[4];
        for (int i = 0; i < 4; i++){
            int a = sc.nextInt(); sc.nextLine();
            String b = sc.nextLine();
            int c = sc.nextInt();
            int d = sc.nextInt(); sc.nextLine();
            cinemas[i] = new Cinema(a, b, c, d);
        }
        String director = sc.nextLine();
        int rating = sc.nextInt();
        int budget = sc.nextInt();
        int avg = findAvgBudgetByDirector(cinemas, director);
        if (avg == 0) System.out.println("Sorry - The given director has not yet directed any movie");
        else System.out.println(avg);
        Cinema res = getMovieByRatingBudget(cinemas, rating, budget);
        if (res == null) System.out.println("Sorry - No movie is available with the specified rating and budget requirement");
        else System.out.println(res.getId());
    }
    static int findAvgBudgetByDirector(Cinema[] cinemas, String director){
        int sum = 0, count = 0;
        for (Cinema c : cinemas)
            if (c.getDirector().equalsIgnoreCase(director)) {
                sum += c.getBudget();
                count++;
            }
        return sum == 0 ? 0 : sum / count;
    }
    static Cinema getMovieByRatingBudget(Cinema[] cinemas, int rating, int budget){
        for (Cinema c : cinemas) if (c.getRating() == rating && c.getBudget() == budget) return c;
        return null;
    }
}
class Cinema {
    private int id, rating, budget;
    private String director;
    public Cinema(int id, String director, int rating, int budget){
        this.id = id;
        this.director = director;
        this.rating = rating;
        this.budget = budget;
    }
    public int getId(){
        return this.id;
    }
    public String getDirector(){
        return this.director;
    }
    public int getRating(){
        return this.rating;
    }
    public int getBudget(){
        return this.budget;
    }
}

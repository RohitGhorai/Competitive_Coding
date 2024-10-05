package tcs_ipa.IPA9;

import java.util.*;

public class IPA9 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Book[] books = new Book[4];
        for (int i = 0; i < 4; i++){
            int a = sc.nextInt();
            int b = sc.nextInt(); sc.nextLine();
            String c = sc.nextLine();
            String d = sc.nextLine();
            double e = sc.nextDouble(); sc.nextLine();
            books[i] = new Book(a, b, c, d, e);
        }
        String title = sc.nextLine();
        Book[] res = findBookWithMaximumPrice(books);
        if (res == null) System.out.println("No book found with mentioned attribute");
        else for (Book b : res) System.out.println(b.getId() + " " + b.getTitle());
        Book res2 = searchBookByTitle(books, title);
        if (res2 == null) System.out.println("No book found with mentioned attribute");
        else System.out.println(res2.getId() + "\n" + res2.getPages());
    }
    static Book[] findBookWithMaximumPrice(Book[] books){
        double max = Integer.MIN_VALUE;
        for (Book book : books) max = Math.max(max, book.getPrice());
        List<Book> list = new ArrayList<>();
        for (Book book : books) if (book.getPrice() == max) list.add(book);
        return list.size() == 0 ? null : list.toArray(new Book[0]);
    }
    static Book searchBookByTitle(Book[] books, String title){
        for (Book b : books) if (b.getTitle().equals(title)) return b;
        return null;
    }
}
class Book {
    private int id, pages;
    private String title, author;
    private double price;
    public Book(int id, int pages, String title, String author, double price){
        this.id = id;
        this.pages = pages;
        this.title = title;
        this.author = author;
        this.price = price;
    }
    public int getId(){
        return this.id;
    }
    public int getPages(){
        return this.pages;
    }
    public String getTitle(){
        return this.title;
    }
    public double getPrice(){
        return this.price;
    }
}

package tcs_ipa.IPA30;

import java.util.*;

public class DocsWithOddPagesByAssId {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Document[] documents = new Document[4];
        for (int i = 0; i < 4; i++){
            int a = sc.nextInt(); sc.nextLine();
            String b = sc.nextLine();
            String c = sc.nextLine();
            int d = sc.nextInt();
            documents[i] = new Document(a, b, c, d);
        }
        ArrayList<Document> list = docsWithOddPages(documents);
        for (Document d : list) System.out.println(d.getId() + " " + d.getTitle() + " " + d.getFolderName() + " " + d.getPages());
    }
    static ArrayList<Document> docsWithOddPages(Document[] documents){
        ArrayList<Document> list = new ArrayList<>();
        for (Document d : documents) if (d.getPages() % 2 == 1) list.add(d);
        return list;
    }
}
class Document {
    private int id, pages;
    private String title, folderName;
    public Document(int id, String title, String folderName, int pages){
        this.id = id;
        this.title = title;
        this.folderName = folderName;
        this.pages = pages;
    }
    public int getId(){
        return this.id;
    }
    public String getTitle(){
        return this.title;
    }
    public String getFolderName(){
        return this.folderName;
    }
    public int getPages(){
        return this.pages;
    }
}

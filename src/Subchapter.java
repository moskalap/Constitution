import java.util.LinkedList;
import java.util.List;

/**
 * Created by przemek on 01.12.16.
 */
public class Subchapter {

    private String subchapterTitle;
    private List<Article> articles = new LinkedList<>();

    public void addArticle(Article article){
        this.articles.add(article);
    }


    Subchapter(String title){
        this.subchapterTitle=title;
    }


    public String toString(){
        String res=subchapterTitle+"\n";
        for (Article article:articles){
            res+=article.toString();
        }
        return res;
    }
    public String getSuchapterTitle(){
        return "Podrozdział"+this.subchapterTitle;
    }


}

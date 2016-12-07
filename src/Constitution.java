import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by przemek on 02.12.16.
 */
public class Constitution implements Document {
    private String title;
    private String preambule;
    private List<Chapter> chapters=new ArrayList<>();
    private ArrayList<Article> articles=new ArrayList<>();
    Constitution(String title){
    this.title=title;
}
    public String getTitle(){
        return this.title;
    }
    public String getAuthor(){
        return "";
    };
    public Chapter[] getChapters(int startIndex, int endIndex) throws ArrayIndexOutOfBoundsException, IllegalArgumentException{
        if (startIndex>endIndex) throw new IllegalArgumentException("błędny zakres rodziałów!");
        if (endIndex>chapters.size()) throw new ArrayIndexOutOfBoundsException("Document posiada "+chapters.size()+" rozdziałów");
        Chapter[] res=new Chapter[endIndex-startIndex+1];

        for(int i =0; i<endIndex-startIndex+1; i++){
            res[i]=chapters.get(i+startIndex-1);
        }
        return res;
    }
    public Article[] getArticles(int startIndex, int endIndex) throws ArrayIndexOutOfBoundsException, IllegalArgumentException {
        if (startIndex>endIndex) throw new IllegalArgumentException("błędny zakres artykułów!");
        if (endIndex>articles.size()) throw new ArrayIndexOutOfBoundsException("Document posiada "+chapters.size()+" artykułów");
        Article[] res=new Article[endIndex-startIndex+1];
        for (int i =0; i<endIndex-startIndex+1; i++){
            res[i]=articles.get(startIndex+i-1);
        }
        return res;
    }
    public void addChapter(Chapter chapter){
        chapters.add(chapter);
    }
    public String toString(){
        String res=getTitle();
        for(Chapter chapter:chapters)
            res+=chapter.toString();
        return res;
    }
    public void addArticle(Article article){
        articles.add(article);
    }
    public void addPreambule(String preambule) {
        this.preambule=preambule;
    }
}

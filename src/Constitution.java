import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by przemek on 02.12.16.
 */
public class Constitution implements Document {
    private String title;
    private List<Chapter> chapters=new ArrayList<>();
    private HashMap<Integer, Article> articles=new HashMap<>();
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
        Chapter[] res=new Chapter[endIndex-startIndex];

        for(int i =startIndex; i<endIndex; i++){
            res[i]=chapters.get(i-1);
        }
        return res;
    }

    public Article[] getArticles(int startIndex, int endIndex) throws ArrayIndexOutOfBoundsException, IllegalArgumentException {
        if (startIndex>endIndex) throw new IllegalArgumentException("błędny zakres artykułów!");
        if (endIndex>articles.size()) throw new ArrayIndexOutOfBoundsException("Document posiada "+chapters.size()+" artykułów");
        Article[] res=new Article[articles.size()];
        for (int i =0; i<endIndex-startIndex; i++){
            res[i]=articles.get(startIndex+i);
        }
        return res;
    }
    public void addChapter(Chapter chapter){
        chapters.add(chapter);
    }
    public String toString(){
        String res="";
        for(Chapter chapter:chapters)
            res+=chapter.toString();
        return res;
    }
}

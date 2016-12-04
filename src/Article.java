import java.util.LinkedList;
import java.util.List;

/**
 * Created by przemek on 01.12.16.
 */
public class Article {
    private int articleNo;
    private List<Paragraph> paragraphs=new LinkedList<>();

    Article(int no){
        this.articleNo=no;
    }

    public void addParagraphs(List<Paragraph> paragraphs){
        for(Paragraph paragraph:paragraphs) {
            this.paragraphs.add(paragraph);
        }
    }

    public String toString(){
        String res="Art. "+articleNo+". \n";
        for (Paragraph paragraph:paragraphs){
            res+=paragraph.toString();
        }

    return res;
    }


    public int getArticleNo() {
        return articleNo;
    }

    public void addParagraph(Paragraph paragraph) {
        paragraphs.add(paragraph);
    }
}

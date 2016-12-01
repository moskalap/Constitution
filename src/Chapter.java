import java.util.LinkedList;
import java.util.List;

/**
 * Created by przemek on 01.12.16.
 */
public class Chapter {
    private final int chapterNo;
    private final String chapterName;
    private List<Subchapter> subChapters=new LinkedList<>();


    public Chapter(int chapterNo) {
        this.chapterNo = chapterNo;
        this.chapterName="";
    }

    public Chapter(int chapterNo, String chapterName) {

        this.chapterNo = chapterNo;
        this.chapterName = chapterName;
    }

    public int getChapterNo() {
        return this.chapterNo;
    }

    public String getChapterName() {
        return this.chapterName;
    }
    public void addSubchapter(Subchapter subchapter){
        subChapters.add(subchapter);
    }
    public Subchapter getSubchapter(int index){
        return subChapters.get(index);

    }

}

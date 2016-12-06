import java.util.LinkedList;

/**
 * Created by przemek on 04.12.16.
 */
public class ConstitutionBuilder {
    private LinkedList<String> words;
    private LinkedList<Chapter> chapters=new LinkedList<>();
    private LinkedList<Article> articles=new LinkedList<>();
    private Chapter actualChapter;
    private Subchapter actualSubchapter;
    private Article actualArticle;
    private Paragraph actualParagraph;
    ConstitutionBuilder(LinkedList<String> words){
        this.words=words;
    }

   public Constitution build(){
       Constitution constitution=new Constitution(getTitle());
       constitution.addPreambule(getPreambule());
       createObjects(constitution);
       return constitution;

   }

    private void createObjects(Constitution c) {
        for(int i=0; i<words.size(); i++){
            switch(words.get(i)){

                case "<CHAPTER>":
                        i++;
                        actualChapter=new Chapter(getNofromLine(words.get(i)) ,words.get(i));
                        chapters.add(actualChapter);
                        c.addChapter(actualChapter);
                        System.out.println("dodałem chapter: "+actualChapter.getChapterName());
                        actualSubchapter=null;
                        actualArticle=null;
                        actualParagraph=null;
                        break;

                case "<SUBCHAPTER>":
                    i++;
                    actualSubchapter=new Subchapter(getSubchapterTitle(i));
                    actualChapter.addSubchapter((actualSubchapter));
                    System.out.println("dodałem subchater"+actualSubchapter.getSuchapterTitle());
                    actualArticle=null;
                    actualParagraph=null;
                    break;
                case "<Article>":
                    i++;
                    actualArticle=new Article(getArticleNo(words.get(i)));
                    actualSubchapter.addArticle(actualArticle);
                    c.addArticle(actualArticle);
                    System.out.println("dodałem artykuł "+ actualArticle.getArticleNo()+ "do "+actualSubchapter.getSuchapterTitle());
                    actualParagraph=null;
                    break;
                case "<SINGLEPARAGRAPH>":
                    i++;
                    actualParagraph=new Paragraph(getParagraphTitle(i));
                    actualArticle.addParagraph(actualParagraph);
                    System.out.println("dodałem pojedynczy paragraf do art"+actualArticle.getArticleNo());
                    break;

                case "<NUMPARAGRAPH>":
                    i++;
                    actualParagraph=new Paragraph(getParagraphNo(i), getParagraphTitle(i));
                    actualArticle.addParagraph(actualParagraph);
                    System.out.println("dodałem numerowany paragraf do art"+actualArticle.getArticleNo());
                    break;
                default:
                    break;

            }
        }
    }

    private int getParagraphNo(int i) {
        return Integer.parseInt(words.get(i).split("\\s+")[0].substring(0,words.get(i).split("\\s+")[0].length()-1));
    }

    private String getParagraphTitle(int i) {

        String res=words.get(i);
        i++;
        while(i<words.size() && !words.get(i).equals("<Article>") && !words.get(i).equals("<CHAPTER>") && !words.get(i).equals("<NUMPARAGRAPH>") && !words.get(i).equals("<SUBCHAPTER>")){
            res+="\n"+words.get(i);
            i++;
        }
        return res;
    }

    private int getArticleNo(String line) {
        String[] arg=line.split("\\s+");
        return Integer.parseInt(arg[1].substring(0, arg[1].length()-1));
    }

    private String getSubchapterTitle(int i) {
        String res=words.get(i);
        i++;
        while(!words.get(i).equals("<Article>")) {
            res += "\n" + words.get(i);
            i++;
        }
        return res;
    }

    private int getNofromLine(String line) {
        String[] words = line.split("\\s+");
        return RomanToDecimal.romanToDecimal(words[1]);

    }

    private String getTitle() {

        int from=0;
        int to=0;
        for(int i=0; i<words.size(); i++){
            if(words.get(i).equals("<TITLE>")) from=i;
            if(words.get(i).equals("</TITLE>")) to=i;
        }
        return getString(from, to);
    }
    private String getPreambule(){
        int from=0;
        int to=0;
        for(int i=0; i<words.size(); i++){
            if(words.get(i).equals("<PREAMBULE>")) from=i;
            if(words.get(i).equals("</PREAMBULE>")) to=i;
        }
        return getString(from, to);

    }

    private String getString(int from, int to) {
        String res="";
        for(int i=from+1; i<to-1; i++)
            res+=words.get(i)+"\n";
        return res+=words.get(to-1);
    }
}

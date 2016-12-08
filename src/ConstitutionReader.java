import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by przemek on 08.12.16.
 */
public class ConstitutionReader {
    private ArgumentsParser parser;
    private Constitution constitution;
    String[] args;

    ConstitutionReader(String[] args) {
        this.args = args;

    }

    public void read() throws IOException {
            parser = new ArgumentsParser(args);
            this.constitution = new ConstitutionBuilder(new ConstitutionParser(parser.filePath).parse()).build();
            if (parser.wantArticle) {
                readArticles(parser.articleStart, parser.articleEnd);
                if(parser.articleEnd==parser.articleStart) scanInput();

            }


            if (parser.wantChapters) readChapters(parser.chapterStart,parser.chapterEnd);


            if (parser.wantsParagraph) readParagraph(parser.paragraph);




    }

    private void readParagraph(int paragraph) {
        this.clear();
        Article[] articles = constitution.getArticles(parser.articleStart, parser.articleEnd);
        System.out.println(articles[0].getParagraph(paragraph).toString());
    }

    private void scanInput() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String x = scanner.nextLine();
            if (x.equals("n")) {

                parser.articleStart++;
                parser.articleEnd++;
                readArticles(parser.articleStart, parser.articleEnd);
            }
            if (x.equals("p")) {
                parser.articleStart--;
                parser.articleEnd--;
                readArticles(parser.articleStart, parser.articleEnd);


            }
        }
    }

    private void readChapters(int chapterStart, int chapterEnd) {
        this.clear();

        Chapter[] chapters=constitution.getChapters(chapterStart,chapterEnd);
        for(Chapter chapter:chapters)
           System.out.println( chapter.toString());

    }

    private void readArticles(int articleStart, int articleEnd) {

        this.clear();
        Article[] articles = constitution.getArticles(articleStart, articleEnd);
        for (Article article : articles)
            System.out.println(article.toString());

    }

    public void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }


}


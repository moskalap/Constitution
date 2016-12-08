import java.io.FileNotFoundException;

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

    public void read() {

        try {
            parser = new ArgumentsParser(args);

            this.constitution = new ConstitutionBuilder(new ConstitutionParser(parser.filePath).parse()).build();
            if (parser.wantArticle) {
                Article[] articles = constitution.getArticles(parser.articleStart, parser.articleEnd);
                for (Article article : articles)
                    System.out.println(article.toString());
            }


            if (parser.wantChapters) {
                Chapter[] chapters = constitution.getChapters(parser.chapterStart, parser.chapterEnd);
                for (Chapter chapter : chapters) {
                    System.out.println(chapter.toString());
                }
            }

            if (parser.wantsParagraph) {
                Article[] articles = constitution.getArticles(parser.articleStart, parser.articleEnd);
                System.out.println(articles[0].getParagraph(parser.paragraph).toString());

            }


        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.toString());
        } catch (IllegalArgumentException e) {
            System.out.println(e.toString());
        } catch (FileNotFoundException e) {
            System.out.println(" Plik nie istnieje");
        }

    }


}


/**
 * Created by przemek on 01.12.16.
 */
public class ArgumentsParser {
    public int paragraph;
    public String filePath;
    public int chapterStart;
    public int chapterEnd;
    public int articleStart;
    public int articleEnd;
    public boolean wantArticle = false;
    public boolean wantChapters = false;
    public boolean wantsParagraph = false;


    ArgumentsParser(String[] args) throws IllegalArgumentException {
        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case ("-p"):
                case ("-P"):
                    i++;
                    filePath = args[i];
                    break;
                case ("-c"):
                case ("-C"):
                    try {
                        i++;
                        if (wantArticle || wantsParagraph) throw new IllegalArgumentException("Za dużo opcji!");
                        wantChapters = true;
                        chapterStart = Integer.parseInt(args[i]);
                    } catch (NumberFormatException e) {

                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                        System.out.println("Błąd w składni.\nPrawidłowa składnia:\n-p lub -P lokalizacjapliku\n" +
                                "-c lub -C od do -> wypisanie rozdziału od do\n" +
                                "-par lub -PAR numer_artykułu paragraf -> wypisz paragraf z artykułu\n");
                    }

                    try {
                        chapterEnd = Integer.parseInt(args[i + 1]);
                        i++;
                    } catch (ArrayIndexOutOfBoundsException es) {
                        chapterEnd = chapterStart;
                    } catch (NumberFormatException e) {
                        chapterEnd = chapterStart;

                    }

                    break;
                case ("-a"):
                case ("-A"):
                    if (wantChapters || wantsParagraph) throw new IllegalArgumentException("Za dużo opcji!");
                    else
                        wantArticle = true;
                    i++;
                    articleStart = Integer.parseInt(args[i]);
                    try {
                        articleEnd = Integer.parseInt(args[i + 1]);
                        i++;
                    } catch (ArrayIndexOutOfBoundsException es) {
                        articleEnd = articleStart;

                    } catch (NumberFormatException e) {
                        articleEnd = articleStart;

                    }
                    break;
                case ("-PAR"):
                case ("-par"):
                    if (wantArticle || wantChapters) throw new IllegalArgumentException("Za dużo opcji!");
                    i++;
                    wantsParagraph = true;
                    try {
                        articleStart = Integer.parseInt(args[i]);
                        articleEnd = articleStart;
                        paragraph = Integer.parseInt(args[i + 1]);
                        i++;
                        break;
                    } catch (NumberFormatException e) {
                        System.out.print("\033[H\033[2J");
                        System.out.flush();

                        System.out.println("Błąd w składni.\nPrawidłowa składnia:\n-p lub -P lokalizacjapliku\n" +
                                "Dodatkowo jedna z opcji:\n" +
                                "-c lub -C od do -> wypisanie rozdziału od do\n" +
                                "-a lub -A od do -> wypsanie artykułów od do\n" +
                                "-par lub -PAR numer_artykułu paragraf -> wypisz paragraf z artykułu\n");
                        System.exit(0);
                    }

                default:
                    throw new IllegalArgumentException("Błąd w składni.\nPrawidłowa składnia:\n-p lub -P lokalizacjapliku\n" +
                            "Dodatkowo jedna z opcji:\n" +
                            "-c lub -C od do -> wypisanie rozdziału od do\n" +
                            "-a lub -A od do -> wypsanie artykułów od do\n" +
                            "-par lub -PAR numer_artykułu paragraf -> wypisz paragraf z artykułu\n");


            }


        }

    }


}

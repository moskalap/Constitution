import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by przemek on 02.12.16.
 */
public class ConstitutionParser {
    private String path;
    private LinkedList<String> words = new LinkedList<>();
    FileReader fileReader;
    private WordsMatcher matcher = new WordsMatcher();

    ConstitutionParser(String path) throws FileNotFoundException {
        this.path = path;
       // System.out.println(path);
        fileReader = new FileReader(path);
    }

    public LinkedList<String> parse() {
        this.buildListOfWords();
        this.deleteGarbages();
        this.repairSeparatedWords();
        this.markTitle();
        this.markPreambule();
        this.markChapters();
        this.markArticles();
        this.markParagraphs();
        this.markSubchapters();
        return words;
    }

    private void markSubchapters() {
        for (int i = 5; i < words.size(); i++)
            if (matcher.whatItIs(words.get(i)).equals(Patterns.UpperLetters)) {
                words.add(i++, "<SUBCHAPTER>");
                i = i + 2;
            }
    }

    private void markParagraphs() {
        for (int i = 2; i < words.size(); i++) {
            if (matcher.whatItIs(words.get(i)).equals(Patterns.Paragraph) && words.get(i - 2).equals("<Article>"))
                words.add(i++, "<SINGLEPARAGRAPH>");
            if (matcher.whatItIs(words.get(i)).equals(Patterns.ParagraphNo))
                words.add(i++, "<NUMPARAGRAPH>");
        }
    }

    private void markArticles() {
        for (int i = 0; i < words.size(); i++) {
            if (matcher.whatItIs(words.get(i)).equals(Patterns.Article))
                words.add(i++, "<Article>");

        }
    }

    private void markChapters() {
        for (int i = 0; i < words.size(); i++) {
            if (matcher.whatItIs(words.get(i)).equals(Patterns.Chapter))
                words.add(i++, "<CHAPTER>");

        }
    }


    private void markPreambule() {
        int i = 1;
        while (!matcher.whatItIs(words.get(i)).equals(Patterns.Chapter)) i++;

        words.add(i, "</PREAMBULE>");

    }

    private void markTitle() {
        int i = 1;
        words.add(0, "<TITLE>");

        ;
        while (matcher.whatItIs(words.get(i)).equals(Patterns.UpperLetters)) {
            i++;

        }
        words.add(i + 1, "</TITLE>");
        words.add(i + 2, "<PREAMBULE>");
    }

    private void repairSeparatedWords() {
        for (int i = 0; i < words.size(); i++) {
            if (matcher.whatItIs(words.get(i)).equals(Patterns.Cutted)) {
                linkSeparatedWords(words, i);
                i = i - 2;

            }
            if (words.get(i).equals("")) words.remove(i);
        }


    }

    private void linkSeparatedWords(LinkedList<String> words, int i) {
        String[] leftWord = words.get(i).split("\\s+");
        String[] rightWord = words.get(i + 1).split("\\s+");
        String res1 = "";
        String res2 = "";

        String repair = this.merge(leftWord[leftWord.length - 1], rightWord[0]);
        for (int j = 0; j < leftWord.length - 1; j++) {
            res1 += leftWord[j] + " ";
        }
        res1 += repair;
        words.set(i, res1);
        if (rightWord.length > 1) {
            for (int k = 1; k < rightWord.length - 1; k++) {
                res2 += rightWord[k] + " ";
            }
            words.set(i + 1, res2 + rightWord[rightWord.length - 1]);
        } else
            words.remove(i + 1);


    }

    private String merge(String s, String s1) {
        return s.substring(0, s.length() - 1) + s1;
    }

    private void deleteGarbages() {
        for (int i = 0; i < words.size(); i++) {
            if (matcher.whatItIs(words.get(i)).equals(Patterns.Garbage)) {
                words.remove(i);
                i--;
            }
        }
    }


    private void readListOfWords() {
        for (String word : words) {
            System.out.println(word);
        }
    }

    private void buildListOfWords() {
        Scanner bfr = new Scanner(fileReader);

        while (bfr.hasNextLine()) {
            words.add(bfr.nextLine());
        }
    }


}

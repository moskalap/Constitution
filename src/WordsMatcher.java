import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by przemek on 03.12.16.
 */
public class WordsMatcher {
    static Pattern datePattern = Pattern.compile("[0-9]{4}+.+[0-9]{2}");
    static Pattern chapterPattern = Pattern.compile("Rozdział.[A-Z]+");
    static Pattern upperCasePattern = Pattern.compile("[A-Z ŻĆŹÓĘĄŁ]{4,}.+");
    static Pattern articlePattern = Pattern.compile("Art. [0-9]+.");
    static Pattern cuttedPattern = Pattern.compile(".+[-]$");
    static Pattern paragraphPatternNo = Pattern.compile("[0-9]{1,3}[.].+");
    static Pattern paragraphSingle = Pattern.compile("[A-Z][a-ząęóćł żź].{12,}");
    static Pattern trashPattern = Pattern.compile("[A-Za-z0-9]");
    static Pattern titlePattern = Pattern.compile("KONSTYTUCJA");
    static Pattern exceptionPattern = Pattern.compile("Tracą moc:");
    static Pattern trashPattern2 = Pattern.compile("[©].+");
    static Matcher matcher;

    WordsMatcher() {
    }

    public static Patterns whatItIs(String line) {

        if (line.split("\\s+")[0].equals("Rozdział"))
            return Patterns.Chapter;
        matcher = cuttedPattern.matcher(line);
        if (matcher.matches()) return Patterns.Cutted;

        matcher = upperCasePattern.matcher(line);
        if (matcher.matches()) return Patterns.UpperLetters;

        matcher = datePattern.matcher(line);
        if (matcher.matches())
            return Patterns.Garbage;
        matcher = chapterPattern.matcher(line);
        if (matcher.matches())
            return Patterns.Chapter;

        matcher = articlePattern.matcher(line);
        if (matcher.matches())
            return Patterns.Article;

        matcher = paragraphPatternNo.matcher(line);
        if (matcher.matches())
            return Patterns.ParagraphNo;
        matcher = trashPattern.matcher(line);
        if (matcher.matches())
            return Patterns.Garbage;
        matcher = trashPattern2.matcher(line);
        if (matcher.matches())
            return Patterns.Garbage;
        matcher = exceptionPattern.matcher(line);
        if (matcher.matches()) return Patterns.Paragraph;

        matcher = paragraphSingle.matcher(line);
        if (matcher.matches()) return Patterns.Paragraph;

        return Patterns.Default;

    }
}

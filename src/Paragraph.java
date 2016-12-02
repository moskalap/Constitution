/**
 * Created by przemek on 01.12.16.
 */
public class Paragraph {
    private int paragraphNo;
    private String paragraph;

    Paragraph(int n, String paragraph){
        this.paragraph=paragraph;
        this.paragraphNo=n;

    }
    public String toString(){
        return paragraphNo+". "+paragraph+"\n";
    }

}

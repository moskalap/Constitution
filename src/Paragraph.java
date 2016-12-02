/**
 * Created by przemek on 01.12.16.
 */
public class Paragraph {
    private final int paragraphNo;
    private final String paragraph;

    Paragraph(int n, String paragraph){
        this.paragraph=paragraph;
        this.paragraphNo=n;

    }

    Paragraph(String paragraph){
        this.paragraph=paragraph;
        this.paragraphNo=0;
    }
    public String toString(){

        if (this.paragraphNo==0)
            return this.paragraph+"\n";
            return paragraphNo+". "+paragraph+"\n";
    }

}

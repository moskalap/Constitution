import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by przemek on 01.12.16.
 */
public class Main {
    public static void main(String[] args) throws IOException {
    ConstitutionParser cr=new ConstitutionParser("/home/przemek/Dokumenty/JavaWorkspace/oopp/Constitution/res/konstytucja.txt");
    ConstitutionBuilder C=new ConstitutionBuilder(cr.parse());
        C.build();



      //  System.out.println(l.get(0));
    }
}

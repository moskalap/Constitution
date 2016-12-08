
import java.io.IOException;

/**
 * Created by przemek on 01.12.16.
 */
public class Main {
    public static void main(String[] args) throws IOException {
    ConstitutionReader constitutionReader=new ConstitutionReader(args);
    constitutionReader.read();
    }
}

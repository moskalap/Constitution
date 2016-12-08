
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by przemek on 01.12.16.
 */
public class Main {


    public static void main(String[] args) throws IOException {
        try{
    ConstitutionReader constitutionReader=new ConstitutionReader(args);
    constitutionReader.read();

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println(e.getMessage());
        }catch(IndexOutOfBoundsException e){
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println(e.getMessage());
        }
        catch (IllegalArgumentException e) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println(e.getMessage());
        } catch (FileNotFoundException e) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println(" Plik nie istnieje");
        }




    }
}

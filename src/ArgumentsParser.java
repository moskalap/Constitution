/**
 * Created by przemek on 01.12.16.
 */
public class ArgumentsParser {
    public String filePath;
    public int chapterStart;
    public int chapterEnd;
    public int articleStart;
    public int articleEnd;
    public boolean wantArticle=false;
    public boolean wantChapters=false;


    ArgumentsParser(String[] args) throws IllegalArgumentException {
        for(int i=0; i<args.length ;i++){
            switch (args[i]) {
                case ("-p"):
                case ("-P"):
                    i++;
                    filePath = args[i];
                    break;
                case ("-c"):
                case ("-C"):
                    i++;
                    wantChapters=true;
                    chapterStart=Integer.parseInt(args[i]);
                    try{
                        chapterEnd=Integer.parseInt(args[i+1]);
                        i++;
                    } catch (ArrayIndexOutOfBoundsException es){
                        chapterEnd=chapterStart;
                    }

                    catch( NumberFormatException e)
                    {
                        chapterEnd=chapterStart;

                    }

                    break;
                case ("-a"):
                case ("-A"):
                    wantArticle=true;
                    i++;
                    articleStart=Integer.parseInt(args[i]);
                    try{
                        articleEnd=Integer.parseInt(args[i+1]);
                        i++;
                    }catch(ArrayIndexOutOfBoundsException es){
                        articleEnd=articleStart;

                    }
                    catch( NumberFormatException e){
                        articleEnd=articleStart;

                    }
                    break;
                default:
                    break;


            }



        }

    }
}

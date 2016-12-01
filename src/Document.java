/**
 * Created by przemek on 01.12.16.
 *
 *
 * Interface resposible for interacting with a document.
 *
 */
public interface Document {
    /**
     *
     * @return title of Document

     */
    public String getTitle();

    /**
     *
     * @return author of Document
     *
     */
    public String getAuthor();

    /**
     * returns a chapters
     * @param startIndex
     *      index of starting chapter
     * @param endIndex
            index of ending chapter
     *
     * @return Array of Chapters
     *
     */
    public Chapter[] getChapter(int startIndex, int endIndex)

        

}

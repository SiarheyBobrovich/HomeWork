package home_work_5.api;

public interface ISearchEngine {

    /**
     * Method which will find count of word in a text file
     * @param text - File
     * @param word - what we'll find
     * @return count of word
     */
    long search(String text, String word);
}

package home_work_5.api;

import java.io.IOException;

public interface IWordFileReader {

    /**
     * Read the file
     * @return - if file has a word - true
     *         - else false
     *         - reader ended its work - false
     * @throws IOException when the file failed
     */
    boolean hasNext() throws IOException;

    /**
     * Get next word
     * @return - word
     * @throws IllegalStateException if hasNext method hasn't yet been called
     * or hasNext method has been ignored
     */
    String next() throws IllegalStateException;

}

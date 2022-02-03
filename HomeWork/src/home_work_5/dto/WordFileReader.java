package home_work_5.dto;

import home_work_5.api.IWordFileReader;

import java.io.IOException;
import java.io.Reader;
import java.util.HashSet;
import java.util.Set;


public class WordFileReader implements IWordFileReader {

    private final Reader reader;
    private final Set<Character> delimiters;

    private String word;
    private boolean isNext;
    private boolean isException = true;

    public WordFileReader(Reader reader) {
        this(reader, " ,.?!:;()\"");
    }

    public WordFileReader(Reader reader, String delimiters) {
         this.reader = reader;
         this.delimiters = new HashSet<>();

         for (char ch : delimiters.toCharArray()) {
             this.delimiters.add(ch);
         }
    }

    /**Method which is read word from file till buffer
     * If file failed
     */
    private void readWord() throws IOException {
        isNext = false;
        StringBuilder wordBuilder = new StringBuilder();

        while (reader.ready()) {
            char charFromFile = (char) reader.read();

            if (!delimiters.contains(charFromFile) && !Character.isWhitespace(charFromFile)) {
                if (charFromFile == '-' && wordBuilder.length() == 0) {
                    continue;
                }
                wordBuilder.append(charFromFile);
            }
            else if (wordBuilder.length() > 0) {
                break;
            }
        }

        if (wordBuilder.length() > 0) {
            this.word = wordBuilder.toString();
            isNext = true;
        }
    }


    @Override
    public boolean hasNext() throws IOException{
        isException = false;
        readWord();
        return isNext;
    }

    @Override
    public String next() throws IllegalStateException {
        if (isException || !isNext) {
            throw new IllegalStateException("Не вызван или проигнорирован метод hasNext()");
        }
        isNext = false;
        return word;
    }
}

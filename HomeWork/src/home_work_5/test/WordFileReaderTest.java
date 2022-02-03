package home_work_5.test;

import home_work_5.dto.WordFileReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

class WordFileReaderTest {

    private WordFileReader fileReader;

    private void initialize(){
        try {
            fileReader  = new WordFileReader(new FileReader("src\\home_work_5\\test\\test.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    void hasNext() throws IOException {
        initialize();

        int count = 0;

        while (fileReader.hasNext()) {
            count++;
        }
        Assertions.assertEquals(21, count);
    }

    @Test
    void next() throws IOException {
        initialize();

        String[] test = new String[]{"Привет-привет", "один", "бабушке", "привет", "4-х", "дела",
                "Привет", "какдела", "1", "Что", "как", "бабушка", "и", "делаешь", "бабушку"};
        Set<String> words = new HashSet<>();

        while (fileReader.hasNext()) {
            words.add(fileReader.next());
        }

        Assertions.assertArrayEquals(test, words.toArray());
    }
}
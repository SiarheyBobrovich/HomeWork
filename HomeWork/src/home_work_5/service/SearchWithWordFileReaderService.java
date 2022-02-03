package home_work_5.service;

import home_work_5.dto.WordFileReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class SearchWithWordFileReaderService {

    public void run(String fileName) throws FileNotFoundException {
        WordFileReader reader = new WordFileReader(new FileReader(fileName));

        Set<String> uniqueWords = new HashSet<>();

        try {
            while (reader.hasNext()) {
                String wordFromFile = reader.next();

                if (wordFromFile != null) {
                    uniqueWords.add(wordFromFile);
                }
            }
        }catch (IOException e) {
            System.out.println("Файл повреждён");
        }

        System.out.println(uniqueWords.size());

    }
}

package home_work_5.service;

import home_work_5.dto.WordFileReader;
import home_work_5.comparator.EntryMapValueComparator;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class SearchWithWordFileReaderAndPrintTopService {

    public void run(String fileName, int countWords) throws FileNotFoundException {
        WordFileReader reader = new WordFileReader(new FileReader(fileName));

        Map<String, Integer> uniqueWords = new HashMap<>();

        try {
            while (reader.hasNext()) {
                String wordFromFile = reader.next();

                if (!uniqueWords.containsKey(wordFromFile)) {
                    uniqueWords.put(wordFromFile, 1);
                } else {
                    uniqueWords.put(wordFromFile, uniqueWords.get(wordFromFile) + 1);
                }
            }
        }catch (IOException e) {
            System.out.println("Файл повреждён");
        }


        List<Map.Entry<String, Integer>> list = new ArrayList<>(uniqueWords.entrySet());
        list.sort(new EntryMapValueComparator<String, Integer>().reversed());

        for (int i = 0; i < countWords && i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}

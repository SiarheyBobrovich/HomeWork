package home_work_5.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class WarAndMarService {

    public void run(String fileName) throws FileNotFoundException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String fileLine;
        Set<String> words = new HashSet<>();

        try {
            while (reader.ready()) {
                fileLine = reader.readLine();
                while (fileLine.endsWith("-")) {
                    fileLine = fileLine.substring(0, fileLine.length() - 2) + reader.readLine();
                }
                fileLine = normalize(fileLine);
                if (fileLine.length() > 0) {
                    words.addAll(getListWords(fileLine));
                }

            }
        } catch(IOException e){
            System.out.println("Что-то не так с файлом");
        }

        System.out.println(words.size());
    }

    /**
     * Метод приводит строку к удобному формату
     * @param str - строка
     * @return приведённая строка
     */
    private String normalize(String str) {
        str = str.replaceAll("[\",.?:;!()]", " ");
        str = str.replaceAll("-{2,}", " ");
        return str.replaceAll("\\s{2,}", " ").trim();
    }

    private Set<String> getListWords(String str) {
        return new HashSet<>(List.of(str.split(" ")));
    }
}

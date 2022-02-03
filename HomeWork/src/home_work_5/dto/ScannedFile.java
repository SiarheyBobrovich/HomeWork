package home_work_5.dto;

import home_work_5.api.ISearchEngine;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ScannedFile {

    private final String fileName;
    private final String word;
    private long countWords;

    public ScannedFile(String fileName, String word) {
        this.fileName = fileName;
        this.word = word;
    }

    @Override
    public String toString() {
        return fileName + " - " + word + " - " + countWords;
    }

    public void run() {
        BufferedReader reader = null;
        boolean isOpen = false;

        do {

            try {
                reader = new BufferedReader(new FileReader(fileName));
                isOpen = true;

            }catch (FileNotFoundException e) {
                System.out.println("Не меняйте содержимое папки!");
            }

        }while (!isOpen);

        ISearchEngine searchEngine = new RegExSearch();
        String fileLine;

        try {
            while ((fileLine = reader.readLine()) != null) {
                this.countWords += searchEngine.search(fileLine, word);
            }
        }catch (IOException e) {
            System.out.println("С файлом что-то не так.");
        }
    }
}

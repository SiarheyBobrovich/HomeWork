package home_work_5.service;


import home_work_5.api.ISearchEngine;
import home_work_5.dto.RegExSearch;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserSearchInDirectoriesService {

    public List<String> run(List<File> files) {
        File file;
        List<String> result = new ArrayList<>();

        while ((file = getFileToSearch(files)) != null) {

            String word = getWordToSearch();

            ISearchEngine searchEngine = new RegExSearch();
            long count = 0;

            try {
                count = searchEngine.search(Files.readString(file.toPath()), word);
            } catch (IOException e) {
                System.out.println("Ошибка чтения: " + e.getMessage());
            }

            result.add(file.getName() + " - " + word + " - " + count);
        }

        return result;
    }

    private void printFiles(List<File> files) {
        for (int i = 0; i < files.size(); i++) {
            System.out.println(i + 1 + ") " + files.get(i).getName());
        }
    }

    private File getFileToSearch(List<File> files) {
        printFiles(files);
        Scanner console = new Scanner(System.in);
        int result;

        do {
            System.out.print("Введите номер файла для сканирования или 0 для выхода: ");
            result = console.nextInt();

        }while (result < 0 || result > files.size());

        if (result > 0) {
            return files.get(result - 1);
        }else {
            return null;
        }
    }

    private String getWordToSearch() {
        String result;
        Scanner console = new Scanner(System.in);

        do {
            System.out.println("Введите слово или выражение для поиска");
            result = console.nextLine();

        }while (result.length() == 0);

        return result;
    }
}

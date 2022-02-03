package home_work_5.service;

import home_work_5.api.ISearchEngine;
import home_work_5.dto.EasySearch;
import home_work_5.dto.IgnoreCaseSearch;
import home_work_5.dto.RegExSearch;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


public class SearchWithISearchEngineService {

    public void run(String fileName) {
        ISearchEngine searchEngine = new IgnoreCaseSearch(new EasySearch());
        ISearchEngine searchEngine2 = new IgnoreCaseSearch(new RegExSearch());

        Path path = Path.of(fileName);
        String file = "";

        try {
             file = Files.readString(path);
        }catch (IOException e) {
            System.out.println("Что-то пошло не так.");
        }

        find(searchEngine, file);
        find(searchEngine2, file);
    }

    private void find(ISearchEngine searchEngine, String text) {

        long countWar = searchEngine.search(text, "война");
        long countMar = searchEngine.search(text, "мир");
        long countAnd = searchEngine.search(text, "и");

        System.out.printf("Война: %d, и: %d, Мир: %d.%n", countWar, countAnd, countMar);
    }
}

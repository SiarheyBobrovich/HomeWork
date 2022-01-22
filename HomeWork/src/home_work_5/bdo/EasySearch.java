package home_work_5.bdo;

import home_work_5.api.ISearchEngine;

//Реализовать поиск используя метод indexOf из класса String

public class EasySearch implements ISearchEngine {
    @Override
    public long search(String text, String word) {
        long count = 0;
        int index = -1;

        while ((index = text.indexOf(word, index + 1)) > 0) {
            if (word.equals(text.substring(index, index + word.length()))) {
                count++;
            }
        }

        return count;
    }
}

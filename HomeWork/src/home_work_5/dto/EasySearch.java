package home_work_5.dto;

import home_work_5.api.ISearchEngine;

//Реализовать поиск используя метод indexOf из класса String

public class EasySearch implements ISearchEngine {
    @Override
    public long search(String text, String word) {
        long count = 0;
        int index = -1;

        while ((index = text.indexOf(word, index + 1)) >= 0) {

            boolean isFind = true;

            if (index > 0) {
                char frontChar = text.charAt(index - 1);
                if (Character.isAlphabetic(frontChar) || Character.isDigit(frontChar) || frontChar == '-') {
                    isFind = false;
                }
            }

            if (index + word.length() < text.length()) {
                char nextChar = text.charAt(index + word.length());
                if (isFind && Character.isAlphabetic(nextChar) || Character.isDigit(nextChar) || nextChar == '-') {
                    isFind = false;
                }
            }

            if (isFind) {
                count++;
            }
        }

        return count;
    }
}

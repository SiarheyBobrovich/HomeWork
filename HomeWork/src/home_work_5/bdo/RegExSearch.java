package home_work_5.bdo;

import home_work_5.api.ISearchEngine;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Реализовать поиск при помощи класса Matcher

public class RegExSearch implements ISearchEngine {

    private final boolean ignoreCase;

    public RegExSearch() {
        this.ignoreCase = false;
    }

    public RegExSearch(boolean ignoreCase) {
        this.ignoreCase = ignoreCase;
    }

    @Override
    public long search(String text, String word) {
        long count = 0;

        Pattern wordPattern = !ignoreCase ?
                Pattern.compile(word) : Pattern.compile(word, Pattern.CASE_INSENSITIVE);
        Matcher wordMatcher = wordPattern.matcher(text);

        while (wordMatcher.find()) {
            count++;
        }

        return count;
    }
}

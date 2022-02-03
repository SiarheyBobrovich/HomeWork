package home_work_5.dto;

import home_work_5.api.ISearchEngine;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Реализовать поиск при помощи класса Matcher

public class RegExSearch implements ISearchEngine {

    private final boolean ignoreCase;

    public boolean isIgnoreCase() {
        return ignoreCase;
    }

    public RegExSearch() {
        this.ignoreCase = false;
    }

    public RegExSearch(boolean ignoreCase) {
        this.ignoreCase = ignoreCase;
    }

    @Override
    public long search(String text, String word) {
        long count = 0;
        String beforeWord = "(\\G|^|[\\p{Space}[\"(\\p{P}]&&[^-]]-?)";
        String afterWord = "([\\p{P}\\s&&[^-]]|$)";
        //String p = "(^|\\G|[\\p{Space}\"(\\p{P}&&[^-]])-?" + word + "([\\p{P}\\s&&[^-]]|$)";
        String p = beforeWord + "(" + word + ")" + afterWord;

        Pattern pattern = ignoreCase ?
                Pattern.compile(p, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE) :
                Pattern.compile(p);


        Matcher wordMatcher = pattern.matcher(text);

        while (wordMatcher.find()) {
            count++;
        }

        return count;
    }
}

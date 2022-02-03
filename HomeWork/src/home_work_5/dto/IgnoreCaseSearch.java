package home_work_5.dto;

import home_work_5.api.ISearchEngine;

public class IgnoreCaseSearch implements ISearchEngine {

    private final ISearchEngine searchEngine;

    public IgnoreCaseSearch(ISearchEngine searchEngine) {
        this.searchEngine = searchEngine;
    }

    @Override
    public long search(String text, String word) {

        if (searchEngine instanceof RegExSearch) {
            if (((RegExSearch) searchEngine).isIgnoreCase()) {
                return searchEngine.search(text, word);
            }
        }

        return searchEngine.search(text.toLowerCase(), word.toLowerCase());
    }
}

package home_work_5.bdo;

import home_work_5.api.ISearchEngine;

public class ignoreCaseSearch implements ISearchEngine {

    private final ISearchEngine searchEngine;

    public ignoreCaseSearch(ISearchEngine searchEngine) {
        this.searchEngine = searchEngine;
    }

    @Override
    public long search(String text, String word) {
//        if (searchEngine instanceof ignoreCaseSearch) {
//            throw new RuntimeException("Бесконечная рекурсия");
//        }
        if (searchEngine instanceof RegExSearch) {
            return search(text, word);
        }else {
            return search(text.toLowerCase(), word.toLowerCase());
        }
    }
}

package home_work_5.dto;

import home_work_5.api.ISearchEngine;

public class SearchEnginePunctuationNormalizer implements ISearchEngine {

    private final ISearchEngine searchEngine;

    public SearchEnginePunctuationNormalizer(ISearchEngine searchEngine) {
        this.searchEngine = searchEngine;
    }

    @Override
    public long search(String text, String word) {
        text = text.replaceAll("[\",.?:;!()]", " ");
        text = text.replaceAll("-{2,}", " ");
        text = text.replaceAll("\\s{2,}", " ").trim();
        return searchEngine.search(text, word);
    }
}

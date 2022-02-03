package home_work_5.dto;

import home_work_5.api.ISearchEngine;

import java.util.concurrent.Callable;

public class SearchRunnable implements Callable<Long> {

    private String text;
    private String word;
    private ISearchEngine searcher;

    public SearchRunnable(String text, String word, ISearchEngine searcher) {
        this.text = text;
        this.word = word;
        this.searcher = searcher;
    }


    @Override
    public Long call() {
        return searcher.search(text, word);
    }
}

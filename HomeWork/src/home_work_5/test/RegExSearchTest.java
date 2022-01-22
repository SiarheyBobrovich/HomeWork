package home_work_5.test;

import home_work_5.api.ISearchEngine;
import home_work_5.bdo.RegExSearch;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



class RegExSearchTest {

    private ISearchEngine easySearch = new RegExSearch();

    @Test
    void search() {
        String test = "Для Пьерa приезд государя, собрание в Слободском дворце, чувство жизни, испытанное там, сделались эпохой жизни.";
        Assertions.assertEquals(2, easySearch.search(test, "жизни"));
    }
}
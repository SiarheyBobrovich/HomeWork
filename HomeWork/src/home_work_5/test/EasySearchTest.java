package home_work_5.test;

import home_work_5.api.ISearchEngine;
import home_work_5.bdo.EasySearch;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EasySearchTest {

    private ISearchEngine easySearch = new EasySearch();

    @Test
    void search() {
        String test = "Для Пьерa приезд государя, собрание в Слободском дворце, чувство жизни, испытанное там, сделались эпохой жизни.";
        Assertions.assertEquals(2, easySearch.search(test, "жизни"));
    }
}
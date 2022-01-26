package home_work_5.test;

import home_work_5.api.ISearchEngine;
import home_work_5.bdo.EasySearch;
import home_work_5.bdo.RegExSearch;
import home_work_5.bdo.SearchEnginePunctuationNormalizer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SearchEnginePunctuationNormalizerTest {

    private ISearchEngine easySearch;
    String test = " -- Благодарю вашу светлость, -- отвечал князь\n Андрей, -- но я боюсь... что не гожусь больше для штабов," +
            " -- сказал он с улыбкой, которую Кутузов заметил и при которой вопросительно посмотрел\t на Князь Андрея." +
            " -- А главное, -- прибавил князь Андрей, -- я привык к полку, полюбил и офицеров, и людей." +
            " Ежели я отказываюсь от чести быть при вас, то поверьте...\n" +
            " Умное, доброе и тонкое выражение светилось в лице Кутузова. Он перебил Болконского.";


    @Test
    void search1() {
        String word = "я";
        easySearch = new SearchEnginePunctuationNormalizer(new EasySearch());
        Assertions.assertEquals(3, easySearch.search(test, word));
    }

    @Test
    void search2() {
        String word = "Андрей";
        easySearch = new SearchEnginePunctuationNormalizer(new RegExSearch());
        Assertions.assertEquals(2, easySearch.search(test, word));
    }

    @Test
    void search3() {
        String word = "князь";
        easySearch = new SearchEnginePunctuationNormalizer(new RegExSearch(true));
        Assertions.assertEquals(3, easySearch.search(test, word));
    }

}
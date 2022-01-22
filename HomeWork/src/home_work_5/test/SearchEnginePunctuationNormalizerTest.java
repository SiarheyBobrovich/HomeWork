package home_work_5.test;

import home_work_5.api.ISearchEngine;
import home_work_5.bdo.EasySearch;
import home_work_5.bdo.SearchEnginePunctuationNormalizer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SearchEnginePunctuationNormalizerTest {

    private ISearchEngine easySearch;
    String test = " -- Благодарю вашу светлость, -- отвечал князь\n Андрей, -- но я боюсь... что не гожусь больше для штабов, -- сказал он с улыбкой, которую Кутузов заметил и при которой вопросительно посмотрел\t на князя Андрея. -- А главное, -- прибавил князь Андрей, -- я привык к полку, полюбил и офицеров, и людей. Ежели я отказываюсь от чести быть при вас, то поверьте...\n" +
            "   Умное, доброе и тонкое выражение светилось в лице Кутузова. Он перебил Болконского.";
    String word = "я";

    @Test
    void search1() {
        easySearch = new SearchEnginePunctuationNormalizer(new EasySearch());
        Assertions.assertEquals(2, easySearch.search(test, word));
    }

}
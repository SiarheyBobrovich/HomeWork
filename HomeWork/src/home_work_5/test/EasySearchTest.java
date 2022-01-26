package home_work_5.test;

import home_work_5.api.ISearchEngine;
import home_work_5.bdo.EasySearch;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class EasySearchTest {

    private ISearchEngine easySearch = new EasySearch();

    String text = "привет, как дела!\n" +
            "привет,какдела!\n" +
            "привет;какдела!\n" +
            "как дела!.Что делаешь?\n" +
            "Привет-привет\n" +
            "Привет -привет\n" +
            "4-х\n" +
            "один и 1\n" +
            "бабушка бабушке бабушку";

    String text2 = " -- Благодарю вашу светлость, -- отвечал князь\n Андрей, -- но я боюсь... что не гожусь больше для штабов," +
            " -- сказал он с улыбкой, которую Кутузов заметил и при которой вопросительно посмотрел\t на Князь Андрея." +
            " -- А главное, -- прибавил князь Андрей, -- я привык к полку, полюбил и офицеров, и людей." +
            " Ежели я отказываюсь от чести быть при вас, то поверьте...\n" +
            " Умное, доброе и тонкое выражение светилось в лице Кутузова. Он перебил Болконского.";

    @Test
    void search1() {
        Assertions.assertEquals(3, easySearch.search(text, "привет"));
    }

    @Test
    void search2() {
        Assertions.assertEquals(2, easySearch.search(text, "как"));
    }

    @Test
    void search3() {
        Assertions.assertEquals(1, easySearch.search(text, "бабушка"));
    }


    @Test
    void search4() {
        Assertions.assertEquals(1, easySearch.search(text, "Привет-привет"));
    }


    @Test
    void search5() {
        Assertions.assertEquals(1, easySearch.search(text, "4-х"));
    }

    @Test
    void search6() {
        Assertions.assertEquals(2, easySearch.search(text2, "Андрей"));
    }

    @Test
    void search7() {
        Assertions.assertEquals(2, easySearch.search(text2, "князь"));
    }

    @Test
    void search8() {
        Assertions.assertEquals(3, easySearch.search(text2, "я"));
    }

    @Test
    void search9() {
        Assertions.assertEquals(0, easySearch.search(text2, "мама"));
    }
}
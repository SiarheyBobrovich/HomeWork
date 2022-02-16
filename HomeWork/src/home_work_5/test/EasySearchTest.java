package home_work_5.test;

import home_work_5.api.ISearchEngine;
import home_work_5.dto.EasySearch;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
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



    @ParameterizedTest
    @CsvFileSource(files = "C:\\JavaCourse\\HomeWork\\src\\home_work_5\\test.csv", delimiter = ';')
    void easySearchTest(String input, String expected) {
        long expect = Long.parseLong(expected);
        Assertions.assertEquals(expect, easySearch.search(text, input));
    }

    @ParameterizedTest
    @CsvFileSource(files = "C:\\JavaCourse\\HomeWork\\src\\home_work_5\\test2.csv", delimiter = ';')
    void easySearchTest2(String input, String expected) {
        Assertions.assertEquals(Long.parseLong(expected), easySearch.search(text2, input));
    }
}
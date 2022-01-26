package home_work_5.test;

import home_work_5.bdo.EasySearch;
import home_work_5.bdo.IgnoreCaseSearch;
import home_work_5.bdo.RegExSearch;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IgnoreCaseSearchTest {

    IgnoreCaseSearch ignoreCaseSearch1 = new IgnoreCaseSearch(new EasySearch());
    IgnoreCaseSearch ignoreCaseSearch2 = new IgnoreCaseSearch(new RegExSearch());
    IgnoreCaseSearch ignoreCaseSearch3 = new IgnoreCaseSearch(new RegExSearch(true));

    @Test
    void search1() {
        Assertions.assertEquals(2,
                ignoreCaseSearch1.search("Наша Маша в громко плачет, уронила в реку мячик.", "в"));
    }

    @Test
    void search2() {
        Assertions.assertEquals(0,
                ignoreCaseSearch1.search("Тише-тише Машенька не плачь.", "тише"));
    }

    @Test
    void search3() {
        Assertions.assertEquals(4,
                ignoreCaseSearch1.search("Косой косой косой косой косил косую траву", "Косой"));
    }

    @Test
    void search4() {
        Assertions.assertEquals(0,
                ignoreCaseSearch1.search("Ехал Грека через реку, видит Грека в реке рак", "река"));
    }

    @Test
    void search5() {
        Assertions.assertEquals(2,
                ignoreCaseSearch1.search("Быстро быстро Быстро-быстро", "быстро"));
    }

    @Test
    void search6() {
        Assertions.assertEquals(2,
                ignoreCaseSearch2.search("Наша Маша в громко плачет, уронила в реку мячик.", "в"));
    }

    @Test
    void search7() {
        Assertions.assertEquals(0,
                ignoreCaseSearch2.search("Тише-тише Машенька не плачь.", "тише"));
    }

    @Test
    void search8() {
        Assertions.assertEquals(4,
                ignoreCaseSearch2.search("Косой косой косой косой косил косую траву", "Косой"));
    }

    @Test
    void search9() {
        Assertions.assertEquals(0,
                ignoreCaseSearch2.search("Ехал Грека через реку, видит Грека в реке рак", "река"));
    }

    @Test
    void search10() {
        Assertions.assertEquals(2,
                ignoreCaseSearch2.search("Быстро быстро Быстро-быстро", "быстро"));
    }

    @Test
    void search11() {
        Assertions.assertEquals(0,
                ignoreCaseSearch3.search("Креатив подошел к концу, было хорошо, но плохо", "беда"));
    }

    @Test
    void search12() {
        Assertions.assertEquals(0,
                ignoreCaseSearch3.search("Тесты тесты тестят тесты и на Тестах тесты Тест-тест", "тест"));
    }

    @Test
    void search13() {
        Assertions.assertEquals(1,
                ignoreCaseSearch3.search("Привет из долёкого Долёка долеко Долека", "долека"));
    }

    @Test
    void search14() {
        Assertions.assertEquals(2,
                ignoreCaseSearch3.search("Куча Куч на куче куч", "куч"));
    }

    @Test
    void search15() {
        Assertions.assertEquals(1,
                ignoreCaseSearch3.search("Быстро быстро Быстро-быстро", "быстро-быстро"));
    }
}
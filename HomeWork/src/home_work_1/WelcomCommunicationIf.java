package home_work_1;

import java.util.Objects;

public class WelcomCommunicationIf implements ICommunicationPrinter {

    @Override
    public String welcom(String name) {

        if (Objects.equals(name, "Вася")) {
            return  "Привет!\nЯ тебя так долго ждал";
        }
        if(Objects.equals(name, "Анастасия")) {
            return "Я тебя так долго ждал";
        }
        return  "Добрый день, а вы кто?";
    }
}

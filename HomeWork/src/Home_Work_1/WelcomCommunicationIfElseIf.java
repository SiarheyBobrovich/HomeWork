package Home_Work_1;

import java.util.Objects;

public class WelcomCommunicationIfElseIf implements ICommunicationPrinter {

    @Override
    public String welcom(String name) {
        String welcom = "Я тебя так долго ждал";

        if (Objects.equals(name, "Вася")) {
            return  "Привет!\n" + welcom;
        } else if (Objects.equals(name, "Анастасия")) {
            return welcom;
        } else {
            return "Добрый день, а вы кто?";
        }
    }
}

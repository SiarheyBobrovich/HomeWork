package home_work_1;

public class WelcomCommunicationSwitch implements ICommunicationPrinter {

    @Override
    public String welcom(String name) {
        String welcom = "Я тебя так долго ждал";

        switch (name) {
            case "Вася" :
                return "Привет!\n" + welcom;
            case "Анастасия" :
                return welcom;
            default:
                return "Добрый день, а вы кто?";
        }
    }
}

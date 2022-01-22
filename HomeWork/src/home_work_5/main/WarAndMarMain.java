package home_work_5.main;

import home_work_5.service.WarAndMarService;

import java.io.FileNotFoundException;

public class WarAndMarMain {
    public static void main(String[] args) {
        String fileName = "Война и мир_книга_тест2.txt";
        WarAndMarService service = new WarAndMarService();

        try {
            service.run(fileName);
        }catch (FileNotFoundException e) {
            System.out.println("Не верно введён адрес документа");
        }
    }
}

package home_work_5.main;

import home_work_5.service.WarAndMarService2_1;

import java.io.FileNotFoundException;

public class WarAndMarMain2_1 {
    public static void main(String[] args) {
        String fileName = "Война и мир_книга.txt";
        WarAndMarService2_1 service = new WarAndMarService2_1();

        try {
            service.run(fileName);
        }catch (FileNotFoundException e) {
            System.out.println("Не верно введён адрес документа");
        }
    }
}

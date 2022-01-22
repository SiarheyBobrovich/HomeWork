package home_work_5.main;

import home_work_5.service.WarAndMarService2_2;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class WarAndMarMain2_2 {
    public static void main(String[] args) {
        String fileName = "Война и мир_книга.txt";
        WarAndMarService2_2 service = new WarAndMarService2_2();

        int printWords = new Scanner(System.in).nextInt();

        try {
            service.run(fileName, printWords);
        }catch (FileNotFoundException e) {
            System.out.println("Не верно введён адрес документа");
        }
    }
}

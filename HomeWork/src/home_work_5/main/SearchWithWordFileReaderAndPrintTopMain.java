package home_work_5.main;

import home_work_5.service.SearchWithWordFileReaderAndPrintTopService;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class SearchWithWordFileReaderAndPrintTopMain {
    public static void main(String[] args) {
        String fileName = "Война и мир_книга.txt";
        SearchWithWordFileReaderAndPrintTopService service = new SearchWithWordFileReaderAndPrintTopService();

        System.out.println("Введите ТОП слов для вывода");
        int printWords = new Scanner(System.in).nextInt();

        try {
            service.run(fileName, printWords);
        }catch (FileNotFoundException e) {
            System.out.println("Не верно введён адрес документа");
        }
    }
}

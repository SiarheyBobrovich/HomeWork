package home_work_5.main;

import home_work_5.service.SearchWithWordFileReaderService;

import java.io.FileNotFoundException;

public class SearchWithWordFileReaderMain {
    public static void main(String[] args) {
        String fileName = "Война и мир_книга.txt";
        SearchWithWordFileReaderService service = new SearchWithWordFileReaderService();

        try {
            service.run(fileName);
        }catch (FileNotFoundException e) {
            System.out.println("Не верно введён адрес документа");
        }
    }
}

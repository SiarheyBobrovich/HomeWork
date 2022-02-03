package home_work_5.main;

import home_work_5.service.SearchInDirectoryThreadService;

import java.io.File;
import java.nio.file.Path;
import java.util.Scanner;

public class SearchInDirectoryThreadMain {

    public static void main(String[] args) {
        File[] files = getFiles();

        SearchInDirectoryThreadService searchInDirectoryThreadService = new SearchInDirectoryThreadService();
        searchInDirectoryThreadService.run(files);
    }

    private static File[] getFiles() {
        Scanner console = new Scanner(System.in);

        File[] files = null;
        boolean isDirectory = false;

        do {
            System.out.print("Введите директорию для поиска: ");

            Path path = Path.of(console.nextLine());
            File file = path.toFile();

            if (file.isDirectory()) {
                isDirectory = true;
                files = file.listFiles((x) -> x.getName().endsWith("txt"));
            }

        }while (!isDirectory);

        return files;
    }
}

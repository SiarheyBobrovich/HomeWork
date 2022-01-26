package home_work_5.service;

import home_work_5.bdo.FilesDirectory;
import home_work_5.bdo.ScannedFile;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserSearchInDirectoryService {

    public void run(FilesDirectory files) {
        int fileIndex = -1;
        List<ScannedFile> scannedFileList = new ArrayList<>();

        while ((fileIndex = getFile(files.getFiles())) > 0) {

            String file = files.getDirectory() + "\\" + files.getFiles().get(fileIndex - 1);
            String word = getWordToSearch();

            scannedFileList.add(new ScannedFile(file, word));
            scannedFileList.get(scannedFileList.size() - 1).run();
        }

        String resultFile = files.getDirectory() + "/result.txt";

        try(BufferedWriter writer = new BufferedWriter(new FileWriter(resultFile))) {

            for (ScannedFile scannedFile : scannedFileList) {
                writer.write(scannedFile.toString() + "\n");
            }

        }catch (IOException e) {
            System.out.println("Нет доступа к файлу");
        }
    }

    private void printFiles(List<String> files) {
        for (int i = 0; i < files.size(); i++) {
            System.out.println(i + 1 + ") " + files.get(i));
        }
    }

    private int getFile(List<String> files) {
        printFiles(files);
        Scanner console = new Scanner(System.in);
        int result;

        do {
            System.out.print("Введите номер файла для сканирования или 0 для выхода: ");
            result = console.nextInt();

        }while (result < 0 || result > files.size());

        return result;
    }

    private String getWordToSearch() {
        String result;
        Scanner console = new Scanner(System.in);

        do {
            System.out.println("Введите слово или выражение для поиска");
            result = console.nextLine();

        }while (result.length() == 0);

        return result;
    }

}

package home_work_5.main;

import home_work_5.bdo.ScannedFile;
import home_work_5.service.UserSearchInDirectoriesService;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserSearchInDirectoriesMain {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        File directory = getFilesDirectory();
        List<File> files = null;

        try {
            files = getTxtFiles(directory);
        } catch (IOException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        UserSearchInDirectoriesService service = new UserSearchInDirectoriesService();
        List<String> result = service.run(files);

        try(BufferedWriter writer = new BufferedWriter(new FileWriter(directory + "/result.txt"))) {
            int index = result.size();
            for (String s : result) {
                writer.write(s);
                if (--index > 0) {
                    writer.write("\n");
                }
            }

        }catch (IOException e) {
            System.out.println("Нет доступа к файлу: " + e.getMessage());
        }
    }

    /**
     * Метод для получения директории от пользователя
     * @return директория
     */
    private static File getFilesDirectory() {
        Scanner console = new Scanner(System.in);
        Path path;
        File file;

        do {
            System.out.println("Введите папку, где будем искать: ");
            path = Path.of(console.nextLine()).toAbsolutePath();
            file = path.toFile();

        }while (!file.isDirectory());

        return file;
    }

    /**
     * Метод поиска *.txt файлов в папке
     * @param file - файл или директория
     * @return - лист файлов
     * @throws IOException - если что-то не так с файлами
     */
    public static List<File> getTxtFiles(File file) throws IOException {
        List<File> result = new ArrayList<>();

        if (!file.isDirectory() ) {
            String fileName = file.getName();
            if (fileName.endsWith("txt") && !fileName.endsWith("result.txt")){
                result.add(file);
            }
        }else {
            File[] files = file.listFiles();

            if (files != null) {
                for (File fileInDirectory : files) {
                    result.addAll(getTxtFiles(fileInDirectory));
                }
            }
        }
        return result;
    }
}

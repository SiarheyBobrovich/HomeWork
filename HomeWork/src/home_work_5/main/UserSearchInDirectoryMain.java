package home_work_5.main;

import home_work_5.dto.FilesDirectory;
import home_work_5.service.UserSearchInDirectoryService;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class UserSearchInDirectoryMain {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        File directory = getFilesDirectory();
        List<String> filesInDirectory = new ArrayList<>();

        for (String file : Objects.requireNonNull(directory.list())) {
            if (file.endsWith(".txt") && !file.equals("result.txt")) {
                filesInDirectory.add(file);
            }
        }

        FilesDirectory filesDirectory = new FilesDirectory(directory.toString(), filesInDirectory);

        UserSearchInDirectoryService service = new UserSearchInDirectoryService();
        service.run(filesDirectory);
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
}

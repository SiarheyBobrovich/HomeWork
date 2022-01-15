package hanoi.main;

import hanoi.api.ICanvas;
import hanoi.dto.Canvas;
import hanoi.dto.figure.api.Figure;
import hanoi.dto.towers.api.BaseTower;
import hanoi.dto.users.api.IUser;
import hanoi.service.HanoiGameService;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class HanoiMain {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        HanoiGameService game = null;

        int userMode = getUserMode(console);

        if (userMode == 1) {
            System.out.print("Хотите загрузить игру(да/любой другой ответ): ");
            String answer = "";

            while (answer.equals("")) {
                answer = console.nextLine();
            }

            if (answer.equalsIgnoreCase("да")) {
                game = load(console);
            }
        }

        if (game == null) {
            int countTower = getTowerCount(console);
            int countFigure = getFigureCount(console);

            game = new HanoiGameService(countTower,
                    countFigure,
                    userMode,
                    new Canvas(countFigure, countTower));
        }

        game.run();
    }

    /**
     * Метод загружает игру из файла
     * @param console с чего считываем
     * @return загруженая игра
     */
    private static HanoiGameService load(Scanner console) {
        String fileName;
        do {
            System.out.print("Введите имя сохранённой игры без расширения: ");
            fileName = console.nextLine();

            if (fileName.equals("new Game")) {
                return null;
            }

            fileName += ".hanoiGame";

        } while (Files.notExists(Path.of(fileName)));

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
            return (HanoiGameService) in.readObject();

        }catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    private static int getUserMode(Scanner console) {
        System.out.println("Доступные режимы игры:\n" +
                "1) Игрок\n" +
                "2) Автоматический(имитация)\n" +
                "3) Искуственный интелект. Внимание! Работает только на 3 башни.");

        while (true) {
            int user = console.nextInt();

            if (user > 0 && user < 4) {
                return user;
            }
        }

    }

    /**
     * Запрос колличества башен
     * @param console с чего считываем
     * @return количество башен
     */
    public static int getFigureCount(Scanner console) {
        System.out.print("Введите количество колец от 3 до 20: ");
        int result;

        while (true) {
            result = console.nextInt();

            if (result > 2 && result <= 20) {
                return result;
            }
        }
    }

    /**
     * Запрос количества фигур на башнях
     * @param console с чего считываем
     * @return количество фигур
     */
    public static int getTowerCount(Scanner console) {
        System.out.print("Введите количество башен от 3 до 8: ");

        while (true) {
            int result = console.nextInt();

            if (result > 2 && result <= 8) {
                return result;
            }
        }
    }
}

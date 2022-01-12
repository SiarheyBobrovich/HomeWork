package hanoi.main;

import hanoi.dto.Canvas;
import hanoi.service.HanoiGameService;

import java.util.Scanner;

public class HanoiMain {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int countTower = getTowerCount(console);
        int countFigure = getFigureCount(console);

        HanoiGameService game = new HanoiGameService(countTower,
                                    countFigure,
                                    getUserMode(console), new Canvas(countFigure, countTower));
        game.run();
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

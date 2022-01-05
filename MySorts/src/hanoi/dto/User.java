package hanoi.dto;

import java.util.Scanner;

public class User {

    private int pinCount;

    Scanner console = new Scanner(System.in);

    public int getPinCount() {
        System.out.print("Введите количество башен от 3 до 8: ");

        while (true) {
            pinCount = console.nextInt();

            if (pinCount > 2 && pinCount <= 8) {
                return pinCount;
            }
        }
    }

    public int getFigureCount() {
        System.out.print("Введите количество колец от 3 до 9: ");
        int result;

        while (true) {
            result = console.nextInt();

            if (result > 2 && result <= 9) {
                return result;
            }
        }

    }

    public int getFromMove() {
        System.out.print("Введите башню откуда снимем: ");
        return getNumberFromUser();
    }

    public int getToMove() {
        System.out.print("Введите башню на которую вешаем: ");
        return getNumberFromUser();
    }

    private int getNumberFromUser() {
        int result;
        while (true) {
            result = console.nextInt();

            if (result > 0 && result <= this.pinCount) {
                return result;
            }
        }
    }
}

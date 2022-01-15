package hanoi.dto.users;

import hanoi.dto.users.api.PlayerUser;

import java.util.Scanner;

public class PersonUser extends PlayerUser {

    private transient Scanner console;

    public PersonUser(int towerCount) {
        super(towerCount);
    }

    @Override
    public int[] getNextMove() {
        if (console == null) {
            console = new Scanner(System.in);
        }
        int from = getFromMove() - 1;

        if (from < 0) {
            return new int[]{from, 0};
        }else {
            return new int[] {from, getToMove() - 1};
        }
    }

    /**
     * Запрос пользователя откуда снимать фигуру
     * @return номер башни или 0 для выхода
     */
    private int getFromMove() {
        System.out.print("Введите башню откуда снимаем или 0 для выхода из игры: ");
        return getNumberFromUser();
    }

    /**
     * Запрос пользователя куда вешать фигуру
     * @return номер башни или 0 для выхода
     */
    private int getToMove() {
        System.out.print("Введите башню на которую вешаем или 0 для выхода из игры: ");
        return getNumberFromUser();
    }

    /**
     * Ввод значения пользователем
     * @return значение
     */
    private int getNumberFromUser() {
        int result;
        int towerCount = getTowerCount();

        while (true) {
            result = console.nextInt();

            if (result >= 0 && result <= towerCount) {
                return result;
            }
        }
    }
}

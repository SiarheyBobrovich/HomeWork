package hanoi.dto.users;

import hanoi.dto.users.api.PlayerUser;

import java.util.Scanner;

public class PersonUser extends PlayerUser {

    Scanner console = new Scanner(System.in);

    public PersonUser(int pinCount) {
        super(pinCount);
    }

    @Override
    public int[] getNextMove() {
        return new int[] {getFromMove() - 1, getToMove() - 1};
    }

    private int getFromMove() {
        System.out.print("Введите башню откуда снимаем: ");
        return getNumberFromUser();
    }

    private int getToMove() {
        System.out.print("Введите башню на которую вешаем: ");
        return getNumberFromUser();
    }

    private int getNumberFromUser() {
        int result;
        int pinCount = getPinCount();
        while (true) {
            result = console.nextInt();

            if (result > 0 && result <= pinCount) {
                return result;
            }
        }
    }

}

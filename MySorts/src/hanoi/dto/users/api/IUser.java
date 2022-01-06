package hanoi.dto.users.api;

public interface IUser {

    /**
     * Запрос у пользователя откуда ходим
     * @return введённое число
     */
    int[] getNextMove();
}

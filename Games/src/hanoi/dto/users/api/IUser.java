package hanoi.dto.users.api;

import java.io.Serializable;

public interface IUser extends Serializable {

    /**
     * Запрос у пользователя откуда ходим
     * @return введённое число
     */
    int[] getNextMove();
}

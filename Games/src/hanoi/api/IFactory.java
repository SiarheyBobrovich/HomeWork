package hanoi.api;

import hanoi.dto.users.api.IUser;

public interface IFactory {

    /**
     * Изготовление пользователя игры
     * @return пользователь игры
     */
    IUser get(int userMode, int towerCount, int figureCount);
}

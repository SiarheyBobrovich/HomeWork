package hanoi.dto.users;

import hanoi.api.IFactory;
import hanoi.dto.users.api.IUser;

import java.util.Scanner;

public class UserFactory implements IFactory {
    @Override
    public IUser get(int userMode, int towerCount) {
        switch (userMode) {
            case 1 :
                return new PersonUser(towerCount);
            case 2 :
                return new AutomaticUser(towerCount);
            case 3 :
                return new BotUser(towerCount);
            default:
                throw new IllegalArgumentException("Неизвестная ошибка");
        }
    }
}

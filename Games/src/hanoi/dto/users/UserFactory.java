package hanoi.dto.users;

import hanoi.api.IFactory;
import hanoi.dto.users.api.IUser;

public class UserFactory implements IFactory {

    @Override
    public IUser get(int userMode, int towerCount, int figureCount) {

        switch (userMode) {
            case 1 :
                return new PersonUser(towerCount);
            case 2 :
                return new AutomaticUser(towerCount);
            case 3 :
                return new BotUser(towerCount, figureCount);
            default:
                throw new IllegalArgumentException("Неизвестная ошибка");
        }
    }
}

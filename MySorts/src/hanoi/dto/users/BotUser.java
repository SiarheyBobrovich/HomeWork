package hanoi.dto.users;

import hanoi.dto.users.api.PlayerUser;

public class BotUser extends PlayerUser {
    public BotUser(int pinCount) {
        super(pinCount);
    }

    @Override
    public int[] getNextMove() {
        return new int[0];
    }
}

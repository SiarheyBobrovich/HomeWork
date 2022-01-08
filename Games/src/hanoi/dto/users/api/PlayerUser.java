package hanoi.dto.users.api;

import hanoi.dto.users.api.IUser;

public abstract class PlayerUser implements IUser {

    private final int pinCount;

    public PlayerUser(int pinCount) {
        this.pinCount = pinCount;
    }

    protected int getTowerCount() {
        return pinCount;
    }

}

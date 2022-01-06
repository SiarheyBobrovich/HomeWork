package hanoi.dto.users;

import hanoi.dto.users.api.PlayerUser;

import java.util.concurrent.ThreadLocalRandom;

public class AutomaticUser extends PlayerUser {

    ThreadLocalRandom rnd = ThreadLocalRandom.current();

    public AutomaticUser(int pinCount) {
        super(pinCount);
    }

    @Override
    public int[] getNextMove() {
        try {
            Thread.sleep(200);
        }catch (InterruptedException e) {}

        return new int[] {
                rnd.nextInt(0, getPinCount()),
                rnd.nextInt(0, getPinCount())};
    }
}

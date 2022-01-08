package hanoi.dto.users;

import hanoi.dto.users.api.PlayerUser;
import java.util.concurrent.ThreadLocalRandom;

public class AutomaticUser extends PlayerUser {

    ThreadLocalRandom rnd = ThreadLocalRandom.current();

    public AutomaticUser(int towerCount) {
        super(towerCount);
    }

    @Override
    public int[] getNextMove() {

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return new int[] {
                rnd.nextInt(0, getTowerCount()),
                rnd.nextInt(0, getTowerCount())};
    }
}

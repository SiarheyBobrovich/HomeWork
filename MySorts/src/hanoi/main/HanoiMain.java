package hanoi.main;

import hanoi.dto.User;
import hanoi.service.HanoiGame;

public class HanoiMain {
    public static void main(String[] args) {
        User user = new User();

        HanoiGame game = new HanoiGame(user);
        game.run();
    }
}

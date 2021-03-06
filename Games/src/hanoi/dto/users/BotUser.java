package hanoi.dto.users;

import hanoi.dto.users.api.PlayerUser;
import java.util.ArrayList;
import java.util.List;

public class BotUser extends PlayerUser {

    private int index;
    private final int figureCount;
    private final List<Integer> steps = new ArrayList<>();

    public BotUser(int towerCount, int figureCount) {
        super(towerCount);
        this.figureCount = figureCount;
        recurse(figureCount, 0, getTowerCount() - 2, getTowerCount() - 1);
    }

    private void recurse(int figureCount, int from, int to, int buffer) {
        if (figureCount == 0) {
           return;
        }

        recurse(figureCount - 1, from, buffer, to);

        steps.add(from);
        steps.add(to);

        recurse(figureCount - 1, buffer, to, from);
    }

    @Override
    public int[] getNextMove() {
        System.out.printf("Хожу с: %d на: %d%n", steps.get(index) + 1, steps.get(index + 1)+ 1);

        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return new int[]{steps.get(index++), steps.get(index++)};
    }
}

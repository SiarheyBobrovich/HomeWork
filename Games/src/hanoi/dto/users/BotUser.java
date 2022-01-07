package hanoi.dto.users;

import hanoi.dto.users.api.PlayerUser;

import java.util.ArrayList;
import java.util.List;

public class BotUser extends PlayerUser {

    private List<Integer> steps = new ArrayList<>();
    int index;
    int from = 0;
    int to = 1;
    int buffer = 2;
    int figureCount = 20;

    public BotUser(int towerCount) {
        super(towerCount);
        recurse(figureCount, from, to, buffer);
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

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new int[]{steps.get(index++), steps.get(index++)};
    }
}

package hanoi.service;

import hanoi.api.IImage;
import hanoi.dto.*;
import hanoi.dto.figure.api.Figure;
import hanoi.dto.figure.Ring;
import hanoi.dto.users.UserFactory;
import hanoi.dto.users.api.IUser;

import java.util.ArrayList;
import java.util.List;

public class HanoiGame {

    private int count;
    private final List<Tower> towers;
    private List<Character[]> save;
    private IImage image;
    private final IUser user;
    private boolean isEnd = false;

    public HanoiGame(int towerCount, int figureCount, int userMode) {
        this.user = new UserFactory().get(userMode, towerCount);
        this.towers = getTowers(towerCount, figureCount);
        this.save = new ArrayList<>();
    }

    public void run() {
        draw();

        while (!isEnd) {
            round();
            draw();

            for (int i = 1; i < towers.size(); i++) {
                isEnd = towers.get(i).isFull();
                if (isEnd) {
                    break;
                }
            }
        }

        System.out.println("Поздравляю ваша игра заняла: " + count + " ходов");
    }

    private void draw() {
        image.clear();

        for (Tower tower : towers) {
            tower.draw();
        }

        image.printMyself();
    }

    private void setCount() {
        count++;
    }

    private void round() {
        int[] fromTo = user.getNextMove();
        boolean isEmptyFrom = towers.get(fromTo[0]).isEmpty();

        if (!isEmptyFrom && (towers.get(fromTo[1]).isEmpty() || towers.get(fromTo[1]).isLess(towers.get(fromTo[0]).getFromTop()))){
            Figure moveFigure = towers.get(fromTo[0]).peekRing();
            towers.get(fromTo[1]).popRing(moveFigure);
        }
        setCount();
    }

    private List<Tower> getTowers(int count, int countFigure){
        List<Tower> result = new ArrayList<>(count);
        this.image = new Image(countFigure, count);
        int x = countFigure;

        for (int i = 0; i < count; i++) {
            Tower tower = new Tower(x, countFigure, image);

            if (i == 0) {
                for (int j = countFigure - 1; j >= 0; j--) {
                    tower.popRing(new Ring(x, j, j + 1, image));
                }
            }
            result.add(tower);
            x = ++x + countFigure * 2 + 1;
        }

        return result;
    }
}

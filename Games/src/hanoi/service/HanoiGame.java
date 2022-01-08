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
    private final IImage image;
    private final IUser user;
    private boolean isEnd = false;

    public HanoiGame(int towerCount, int figureCount, int userMode, IImage image) {
        this.user = new UserFactory().get(userMode, towerCount);
        this.towers = Tower.getTowers(towerCount, figureCount, image);
        this.save = new ArrayList<>();
        this.image = image;
    }

    /**
     * Запуск игры
     */
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

    /**
     * Отрисовка поля
     */
    private void draw() {
        image.clear();

        for (Tower tower : towers) {
            tower.draw();
        }

        image.printMyself();
    }

    /**
     * Запись хода
     */
    private void setCount() {
        count++;
    }

    /**
     * Запуск раунда(хода)
     */
    private void round() {
        int[] fromTo = user.getNextMove();
        boolean isEmptyFrom = towers.get(fromTo[0]).isEmpty();

        if (!isEmptyFrom && (towers.get(fromTo[1]).isEmpty() || towers.get(fromTo[1]).isLess(towers.get(fromTo[0]).getFromTop()))){
            Figure moveFigure = towers.get(fromTo[0]).peekRing();
            towers.get(fromTo[1]).popRing(moveFigure);
        }

        setCount();
    }
}

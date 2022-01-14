package hanoi.service;

import hanoi.api.ICanvas;
import hanoi.dto.figure.api.Figure;
import hanoi.dto.towers.Tower2;
import hanoi.dto.towers.api.BaseTower;
import hanoi.dto.users.UserFactory;
import hanoi.dto.users.api.IUser;

import java.util.ArrayList;
import java.util.List;

public class HanoiGameService {

    private int count;
    private final List<BaseTower<Figure>> towers;
    private List<Character[]> save;
    private final ICanvas image;
    private final IUser user;
    private boolean isEnd = false;

    public HanoiGameService(int towerCount, int figureCount, int userMode, ICanvas image) {
        this.user = new UserFactory().get(userMode, towerCount, figureCount);
        this.towers = Tower2.getTowers(towerCount, figureCount, image);
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

        for (BaseTower<? extends Figure> tower : towers) {
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

        if (towers.get(fromTo[0]).test(towers.get(fromTo[1]).watchFigure())){
            Figure moveFigure = towers.get(fromTo[0]).getFigure();
            towers.get(fromTo[1]).add(moveFigure);
        }

        setCount();
    }
}

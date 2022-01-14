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
        do {
            draw();

        }while (round() && !isEndGame());

        System.out.println("Поздравляю ваша игра заняла: " + count + " ходов");
    }

    private boolean isEndGame() {
        for (int i = 1; i < towers.size(); i++) {
            if (towers.get(i).isFull()) {
                return true;
            }
        }
        return false;
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
    private boolean round() {
        int[] fromTo = user.getNextMove();

        int from = fromTo[0];
        int to = fromTo[1];

        if (from == -1 || to == -1) {
            return false;
        }

        if (towers.get(from).test(towers.get(to).watchFigure())){
            Figure moveFigure = towers.get(from).getFigure();
            towers.get(to).add(moveFigure);
        }

        setCount();

        return true;
    }
}

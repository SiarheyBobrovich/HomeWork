package hanoi.service;

import hanoi.api.IImage;
import hanoi.dto.*;
import hanoi.dto.users.UserFactory;
import hanoi.dto.users.api.IUser;

import java.util.ArrayList;
import java.util.List;

public class HanoiGame {

    private int count;
    private final List<Tower> pins;
    private List<Character[]> save;
    private IImage image;
    private final IUser user;
    private boolean isEnd = false;

    public HanoiGame(int towerCount, int figureCount, int userMode) {
        this.user = new UserFactory().get(userMode, towerCount);
        this.pins = getPins(towerCount, figureCount);
        this.save = new ArrayList<>();
    }

    public void run() {
        draw();

        while (!isEnd) {
            round();
            draw();

            for (int i = 1; i < pins.size(); i++) {
                isEnd = pins.get(i).isFull();
                if (isEnd) {
                    break;
                }
            }
        }

        System.out.println("Поздравляю ваша игра заняла: " + count + " ходов");
    }

    private void draw() {
        image.clear();

        for (Tower pin : pins) {
            pin.draw();
        }

        image.printMyself();
    }

    private void setCount() {
        count++;
    }

    private void round() {
        int[] fromTo = user.getNextMove();
        boolean isEmptyFrom = pins.get(fromTo[0]).isEmpty();
        if (!isEmptyFrom && (pins.get(fromTo[1]).isEmpty() || pins.get(fromTo[1]).isLess(pins.get(fromTo[0]).getFromTop()))){
            Figure moveFigure = pins.get(fromTo[0]).peekRing();
            pins.get(fromTo[1]).popRing(moveFigure);
        }
        setCount();
    }

    private List<Tower> getPins(int count, int countFigure){
        List<Tower> result = new ArrayList<>(count);
        image = new Image(countFigure, count);
        int x = countFigure;
        for (int i = 0; i < count; i++) {
            Tower pin = new Tower(x, countFigure, image);

            if (i == 0) {
                for (int j = countFigure - 1; j >= 0; j--) {
                    pin.popRing(new Ring(x, j, j + 1, image));
                }
            }
            result.add(pin);
            x = ++x + countFigure * 2 + 1;
        }

        return result;
    }
}

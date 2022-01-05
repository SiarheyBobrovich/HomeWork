package hanoi.service;

import hanoi.api.IImage;
import hanoi.dto.*;

import java.util.ArrayList;
import java.util.List;

public class HanoiGame {

    private int count;
    private final List<Pin> pins;
    private List<Character[]> save;
    private IImage image;
    private final User user;
    private boolean isEnd = false;

    public HanoiGame(User user) {
        this.user = user;
        this.pins = getPins(user.getPinCount(), user.getFigureCount());
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

        for (Pin pin : pins) {
            pin.draw();
        }

        image.printMyself();
    }

    private void setCount() {
        count++;
    }

    private void round() {
        int from = user.getFromMove() - 1;
        int to = user.getToMove() - 1;
        boolean isEmptyFrom = pins.get(from).isEmpty();
        if (!isEmptyFrom && (pins.get(to).isEmpty() || pins.get(to).isLess(pins.get(from).getFromTop()))){
            Figure moveFigure = pins.get(from).peekRing();
            pins.get(to).popRing(moveFigure);
        }
        setCount();
    }



    private List<Pin> getPins(int count, int countFigure){
        List<Pin> result = new ArrayList<>(count);
        image = new Image(countFigure, count);
        int x = countFigure;
        for (int i = 0; i < count; i++) {
            Pin pin = new Pin(x, countFigure, image);

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

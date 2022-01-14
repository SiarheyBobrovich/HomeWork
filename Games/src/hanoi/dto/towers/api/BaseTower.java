package hanoi.dto.towers.api;

import hanoi.api.BaseObject;
import hanoi.api.ICanvas;
import hanoi.dto.figure.api.Figure;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public abstract class BaseTower<T extends Figure> extends BaseObject implements Predicate<T> {

    private final int x;
    private int y;
    private final int countFigures;
    private final List<T> figures = new ArrayList<>();

    protected BaseTower(ICanvas image, int x, int countFigures) {
        super(image);
        this.x = x;
        this.countFigures = countFigures;
    }

    public boolean isFull() {
        return countFigures == figures.size();
    }

    public void add(T figure) {
        figure.setX(this.x);
        figure.setY(this.countFigures - figures.size() - 1);
        figures.add(figure);
    }

    public T watchFigure() {
        return !figures.isEmpty() ? figures.get(figures.size() - 1) : null;
    }

    public T getFigure() {
        return !figures.isEmpty() ? figures.remove(figures.size() - 1) : null;
    }

    @Override
    public void draw() {
        this.y = countFigures - 1;

        for (int i = figures.size() - 1; !figures.isEmpty() && i >= 0; i--) {
            getImage().draw(figures.get(i));
            this.y--;
        }

        while (this.y >= 0) {
            super.draw();
            this.y--;
        }
    }

    @Override
    public int getX() {
        return this.x;
    }

    @Override
    public int getY() {
        return this.y;
    }

    @Override
    public boolean test(T t) {
        return !figures.isEmpty() && (t == null || watchFigure().test(t));
    }
}

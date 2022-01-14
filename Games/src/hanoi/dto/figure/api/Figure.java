package hanoi.dto.figure.api;

import hanoi.api.BaseObject;
import hanoi.api.ICanvas;

import java.util.function.Predicate;

public abstract class Figure extends BaseObject implements Predicate<Figure> {

    private int x;          //Фигура находится на башне X
    private int y;          //На позиции Y
    private final int size; //У каждой фигуры есть свой размер

    protected Figure(int x, int y, int size, ICanvas image) {
        super(image);
        this.x = x;         //центр фигуры
        this.y = y;         //Позиция на башне
        this.size = size;   //Размер
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public int getX() {
        return x - size;
    }

    @Override
    public boolean test(Figure figure) {
        return this.size < figure.size;
    }
}

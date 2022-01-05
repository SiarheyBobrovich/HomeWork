package hanoi.dto;

import hanoi.api.IDrawable;
import hanoi.api.IImage;

public class Pin implements IDrawable {

    private final int x;
    private int y;
    private int freePosition;
    private Figure[] rings;

    private final char[][] picture;
    private final IImage image;


    public Pin(int x, int height, IImage image) {
        this.x = x;
        this.rings = new Figure[height];
        this.image = image;
        picture = new char[][]{{'|'}};
        freePosition = rings.length - 1;
    }

    /**
     * Снять фигуру
     * @return фигура
     */
    public Figure peekRing() {
        if (freePosition == rings.length) {
            return null;
        }
        Figure figure = rings[freePosition + 1];
        if (figure != null) {
            rings[freePosition + 1] = null;
            freePosition++;
            return figure;
        }
        return null;
    }

    public Figure getFromTop() {
        return rings[freePosition + 1];
    }

    /**
     * Положить фигуру
     * @param figure сама фигура
     */
    public void popRing(Figure figure) {
        figure.setX(this.x);
        figure.setY(freePosition);
        rings[freePosition] = figure;
        freePosition--;
    }

    /**
     * Проверяет можно ли сюда положить следующую фигуру
     * @param figure
     * @return
     */
    public boolean isLess(Figure figure) {
        return freePosition == 0 || figure.getSize() < rings[freePosition + 1].getSize();
    }

    public boolean isEmpty() {
        return freePosition == rings.length - 1;
    }

    public boolean isFull() {
        return this.freePosition == -1;
    }

    @Override
    public void draw() {

        for (Figure figure : rings) {

            if (figure != null) {
                figure.draw();
            }else {
                image.iDrawIt(this);
            }
            this.y++;
        }

        this.y = 0;
    }

    @Override
    public char[][] getPicture() {
        return this.picture;
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
    public int getSize() {
        return 1;
    }
}

package hanoi.dto;

import hanoi.api.IDrawable;
import hanoi.api.IImage;
import hanoi.dto.figure.Ring;
import hanoi.dto.figure.api.Figure;

import java.util.ArrayList;
import java.util.List;

public class Tower implements IDrawable {

    private final int x;
    private int y;
    private int freePosition;
    private Figure[] rings;

    private final char[][] picture = new char[][]{{ (char)9617}};
    private final IImage image;

    public Tower(int x, int height, IImage image) {
        this.x = x;
        this.rings = new Figure[height];
        this.image = image;
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
     * @param figure проверяемая фигура
     * @return true - если башня пустая или предыдущая фигура большего размера иначе false
     */
    public boolean isLess(Figure figure) {
        return freePosition == 0 || figure.getSize() < rings[freePosition + 1].getSize();
    }

    /**
     * Проверяет пустая ли башня
     * @return true - если башня пустая, иначе false
     */
    public boolean isEmpty() {
        return freePosition == rings.length - 1;
    }

    /**
     * Проверяет полная ли башня
     * @return true - если башня полная, иначе false
     */
    public boolean isFull() {
        return this.freePosition == -1;
    }

    /**
     * Отрисовка всех объектов башня
     */
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

    public static List<Tower> getTowers(int count, int countFigure, IImage image){
        List<Tower> result = new ArrayList<>(count);
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

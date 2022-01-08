package hanoi.dto;

import hanoi.api.IDrawable;
import hanoi.api.IImage;
import hanoi.dto.figure.Ring;
import hanoi.dto.figure.api.Figure;

import java.util.ArrayList;
import java.util.List;

public class Tower implements IDrawable {

    //В принципе класс абстрактный

    private final int x;                //Башня неподвижна по Х
    private int y;                      //Y фигуры
    private int freePosition;           //Свободное место на башне
    private final Figure[] figures;     //Фигуры не башне

    private char[][] picture;           //Изабражение башни
    private final IImage image;         //изображение, где будем рисовать

    public Tower(int x, int countFigures, IImage image) {
        this.x = x;
        this.figures = new Figure[countFigures];
        this.image = image;
        freePosition = figures.length - 1;
        setPicture(new char[][]{{ (char)9617}});
    }

    /**
     * Смена изображения башни
     * @param picture новое изображение(для наследников)
     */
    private void setPicture(char[][] picture) {
        this.picture = picture;
    }

    /**
     * Снять фигуру
     * @return фигура
     */
    public Figure peekRing() {
        if (freePosition == figures.length) {
            return null;
        }

        Figure figure = figures[freePosition + 1];

        if (figure != null) {
            figures[freePosition + 1] = null;
            freePosition++;
            return figure;
        }

        return null;
    }

    public Figure getFromTop() {
        return figures[freePosition + 1];
    }

    /**
     * Положить фигуру
     * @param figure сама фигура
     */
    public void popRing(Figure figure) {
        figure.setX(this.x);
        figure.setY(freePosition);

        figures[freePosition] = figure;
        freePosition--;
    }

    /**
     * Проверяет можно ли сюда положить следующую фигуру
     * @param figure проверяемая фигура
     * @return true - если башня пустая или предыдущая фигура большего размера иначе false
     */
    public boolean isLess(Figure figure) {
        return freePosition == 0 || figure.getSize() < figures[freePosition + 1].getSize();
    }

    /**
     * Проверяет пустая ли башня
     * @return true - если башня пустая, иначе false
     */
    public boolean isEmpty() {
        return freePosition == figures.length - 1;
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

        for (Figure figure : figures) {

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

    /**
     * Метод создания всех башен
     * @param count - Количество башен
     * @param countFigure - высота башни(количество фигур помещаемых на башню)
     * @param image - где будем рисовать башню
     * @return заполненный список башен со стартовой позицией фигур
     */
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

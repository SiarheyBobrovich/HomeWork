package hanoi.dto.towers;

import hanoi.api.BaseObject;
import hanoi.api.ICanvas;
import hanoi.dto.figure.Ring;
import hanoi.dto.figure.api.Figure;
import hanoi.utils.Container;

import java.util.ArrayList;
import java.util.List;

//Первый вариант(Рабочий но мне не понравился)

public class Tower extends BaseObject {

    private int y;                      //У каждой фигуры есть своя координата Y
    private final int x;                //Башня неподвижна по Х
    private final Container<Figure> figures;     //Фигуры не башне

    public Tower(int x, int countFigures, ICanvas image) {
        super(image);
        this.x = x;
        this.figures = new Container<>(new Figure[1], countFigures);
        setPicture(new char[][]{{ (char)9617}});
    }

    /**
     * Снять фигуру
     * @return фигура
     */
    public Figure peekRing() {
        return figures.peekRing();
    }

    public Figure getFromTop() {
        return figures.getFromTop();
    }

    /**
     * Положить фигуру
     * @param figure сама фигура
     */
    public void popRing(Figure figure) {
        figure.setX(this.x);
        figure.setY(figures.getFreePosition());;
        figures.pop(figure);
    }

    /**
     * Проверяет пустая ли башня
     * @return true - если башня пустая, иначе false
     */
    public boolean isEmpty() {
        return figures.isEmpty();
    }

    /**
     * Проверяет полная ли башня
     * @return true - если башня полная, иначе false
     */
    public boolean isFull() {
        return figures.isFull();
    }

    /**
     * Отрисовка всех объектов башня
     */
    @Override
    public void draw() {

        for (Figure figure : figures){

            if (figure != null) {
                figure.draw();
            }else {
                super.draw();
            }
            this.y++;
        }

        this.y = 0;
    }

    @Override
    public int getX() {
        return this.x;
    }

    @Override
    public int getY() {
        return this.y;
    }

    /**
     * Метод создание всех башен
     * @param count - Количество башен
     * @param countFigure - высота башни(количество фигур помещаемых на башню)
     * @param image - где будем рисовать башню
     * @return заполненный список башен со стартовой позицией фигур
     */
    public static List<Tower> getTowers(int count, int countFigure, ICanvas image){
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

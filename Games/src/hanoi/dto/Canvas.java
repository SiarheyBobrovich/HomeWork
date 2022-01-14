package hanoi.dto;

import hanoi.api.IDrawable;
import hanoi.api.ICanvas;

import java.util.Arrays;

public class Canvas implements ICanvas {

    private final char[][] canvas;

    /**
     * Конструктор картинки
     * @param countFigure Количество фигурок(колец)
     * @param countTower - колличество позиций для смены(штырей)
     */
    public Canvas(int countFigure, int countTower) {
        this.canvas = new char[countFigure][2 * countTower * countFigure + 2 * countTower - 1];
    }

    /**
     * Метод отрисовки объекта
     * @param drawable - фигура
     */
    @Override
    public void draw(IDrawable drawable) {
        char[][] figureToDraw = drawable.getPicture();        // Изубражение фигуры
        int startY = drawable.getY();                         // Начальная позиция Y
        int startX = drawable.getX();                         // Ночальная позиция X
        for (int i = 0; i < figureToDraw.length; i++) {
            for (int j = 0; j < figureToDraw[i].length ; j++) {
                this.canvas[startY + i][startX + j] = figureToDraw[i][j];
            }
        }
    }

    @Override
    public void printMyself() {
        System.out.println("\n\n");

        for (char[] chars : canvas) {
            for (char aChar : chars) {
                System.out.print(aChar);
            }
            System.out.println();
        }
    }

    @Override
    public void clear() {
        for (char[] c : canvas) {
            Arrays.fill(c, ' ');
        }
    }
}

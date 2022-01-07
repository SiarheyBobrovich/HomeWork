package hanoi.dto;

import hanoi.api.IDrawable;
import hanoi.api.IImage;

import java.util.Arrays;

public class Image implements IImage {

    private final char[][] image;

    /**
     * Конструктор картинки
     * @param countFigure Количество фигурок(колец)
     * @param countTower - колличество позиций для смены(штырей)
     */
    public Image(int countFigure, int countTower) {
        this.image = new char[countFigure][2 * countTower * countFigure + 2 * countTower - 1];
    }

    /**
     * Метод отрисовки объекта
     * @param figure - фигура
     */
    @Override
    public void iDrawIt(IDrawable figure) {
        char[][] figureToDraw = figure.getPicture();        // Изубражение фигуры
        int startY = figure.getY();                         // Начальная позиция Y
        int startX = figure.getX();                         // Ночальная позиция X
        for (int i = 0; i < figureToDraw.length; i++) {
            for (int j = 0; j < figureToDraw[i].length ; j++) {
                this.image[startY + i][startX + j] = figureToDraw[i][j];
            }
        }
    }

    @Override
    public void printMyself() {
        System.out.println("\n\n");

        for (char[] chars : image) {
            for (char aChar : chars) {
                System.out.print(aChar);
            }
            System.out.println();
        }
    }

    @Override
    public void clear() {
        for (char[] c : image) {
            Arrays.fill(c, ' ');
        }
    }
}

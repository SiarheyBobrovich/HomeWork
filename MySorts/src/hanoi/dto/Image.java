package hanoi.dto;

import hanoi.api.IDrawable;
import hanoi.api.IImage;

import java.util.Arrays;

public class Image implements IImage {

    private char[][] image;

    /**
     * Конструктор картинки
     * @param countFigure Количество фигурок(колец)
     * @param countPin - колличество позиций для смены(штырей)
     */
    public Image(int countFigure, int countPin) {
        this.image = new char[countFigure][2 * countPin * countFigure + 2 * countPin - 1];
    }

    /**
     * Метод отрисовки объекта
     * @param figure - фигура
     */
    @Override
    public void iDrawIt(IDrawable figure) {
        char[][] figureToDraw = figure.getPicture();        // Изубражение фигуры
        int startY = figure.getY();                         // Начальная позиция Х
        int startX = figure.getX();  // Ночальная позиция Y

        for (int i = 0; i < figureToDraw.length; i++) {
            for (int j = 0; j < figureToDraw[i].length ; j++) {
                this.image[startY + i][startX + j] = figureToDraw[i][j];
            }
        }
    }

    @Override
    public void printMyself() {
        for (char[] chars : image) {
            for (char aChar : chars) {
                System.out.print(aChar);
            }
            System.out.println();
        }
    }

    public void clear() {
        for (char[] c : image) {
            Arrays.fill(c, ' ');
        }
    }
}

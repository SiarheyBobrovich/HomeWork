package hanoi.api;

import java.io.Serializable;

public interface ICanvas extends Serializable {
    /**
     * Рисует объект на себя
     * @param baseObject - объект
     */
    void draw(IDrawable baseObject);


    /**
     * Печатает себя в консоль
     */
    void printMyself();

    /**
     * Очищает изображение
     */
    void clear();
}

package hanoi.api;

public interface ICanvas {
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

package hanoi.api;

public interface IImage {
    /**
     * Рисует объект на себя
     * @param figure - объект
     */
    void iDrawIt(IDrawable figure);


    /**
     * Печатает себя в консоль
     */
    void printMyself();

    /**
     * Очищает изображение
     */
    void clear();
}

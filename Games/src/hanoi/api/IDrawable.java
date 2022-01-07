package hanoi.api;

public interface IDrawable {

    /**
     * Метод для запроса изображения
     * @return своё изображение
     */
    char[][] getPicture();

    /**
     * Метод для запроса координаты X
     * @return координату X
     */
    int getX();

    /**
     * Метод для запроса координаты Y
     * @return координату Y
     */
    int getY();

    /**
     * Метод для запроса координаты размера объекта
     * @return размер
     */
    int getSize();

    /**
     * Команда нарисовать себя
     */
    void draw();
}

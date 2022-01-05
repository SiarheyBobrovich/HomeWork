package hanoi.api;

public interface IDrawable {

    char[][] getPicture();
    int getX();
    int getY();
    int getSize();
    void draw();
}

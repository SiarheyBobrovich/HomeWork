package hanoi.dto;

import hanoi.api.IDrawable;
import hanoi.api.IImage;

public abstract class Figure implements IDrawable {

    private int x;
    private int y;
    private final int size;

    private final IImage image;
    private char[][] picture;

    public Figure(int x, int y, int size, IImage image) {
        this.x = x; //центр фигуры
        this.y = y;
        this.size = size;
        this.image = image;
    }

    public IImage getImage() {
        return image;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }


    public void setPicture(char[][] picture) {
        this.picture = picture;
    }

    @Override
    public char[][] getPicture() {
        return picture;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public int getX() {
        return x - size;
    }
}

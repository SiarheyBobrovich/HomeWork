package hanoi.api;

public abstract class BaseObject implements IDrawable{

    private final ICanvas image;
    private char[][] picture;

    protected BaseObject(ICanvas image) {
        this.image = image;
    }

    public ICanvas getImage() {
        return image;
    }

    @Override
    public char[][] getPicture() {
        return picture;
    }

    public void setPicture(char[][] picture) {
        this.picture = picture;
    }

    @Override
    public void draw() {
        getImage().draw(this);
    }
}

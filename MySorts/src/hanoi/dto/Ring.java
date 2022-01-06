package hanoi.dto;


import hanoi.api.IImage;

import java.util.Arrays;

public class Ring extends Figure {

    public Ring(int x, int y, int size, IImage image) {
        super(x, y,size, image);

        char[][] pictureOfRing = new char[1][2 * size + 1];
        Arrays.fill(pictureOfRing[0], (char) 9609);
        setPicture(pictureOfRing);
    }

    /**
     * Метод отрисовки себя на картинке
     */
    @Override
    public void draw() {
        getImage().iDrawIt(this);
    }
}

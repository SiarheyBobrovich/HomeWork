package hanoi.dto.figure;


import hanoi.api.ICanvas;
import hanoi.dto.figure.api.Figure;

import java.util.Arrays;

public class Ring extends Figure {

    public Ring(int x, int y, int size, ICanvas image) {
        super(x, y,size, image);

        char[][] pictureOfRing = new char[1][2 * size + 1];
        Arrays.fill(pictureOfRing[0], (char) 9609);
        setPicture(pictureOfRing);
    }
}

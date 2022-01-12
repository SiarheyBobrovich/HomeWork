package hanoi.dto.towers;

import hanoi.dto.figure.Ring;
import hanoi.dto.figure.api.Figure;
import hanoi.dto.towers.api.BaseTower;
import hanoi.api.ICanvas;

import java.util.ArrayList;
import java.util.List;

public class Tower2<T extends Figure> extends BaseTower<T> {

    public Tower2(ICanvas image, int x, int countFigures) {
        super(image, x, countFigures);
        setPicture(new char[][] {{'|'}});
    }

    @Override
    public int getSize() {
        return 1;
    }

    public static List<BaseTower<Figure>> getTowers(int count, int countFigure, ICanvas image){
        List<BaseTower<Figure>> result = new ArrayList<>(count);
        int x = countFigure;

        for (int i = 0; i < count; i++) {
            Tower2<Figure> tower2 = new Tower2<>(image, x, countFigure);

            if (i == 0) {
                for (int j = countFigure - 1; j >= 0; j--) {
                    tower2.add(new Ring(x, j, j + 1, image));
                }
            }

            result.add(tower2);
            x = ++x + countFigure * 2 + 1;
        }

        return result;
    }
}

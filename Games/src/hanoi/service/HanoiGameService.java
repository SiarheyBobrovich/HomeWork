package hanoi.service;

import hanoi.api.ICanvas;
import hanoi.dto.figure.api.Figure;
import hanoi.dto.towers.Tower2;
import hanoi.dto.towers.api.BaseTower;
import hanoi.dto.users.PersonUser;
import hanoi.dto.users.UserFactory;
import hanoi.dto.users.api.IUser;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class HanoiGameService implements Serializable {

    private int count;
    private final List<BaseTower<Figure>> towers;
    private final ICanvas image;
    private final IUser user;

    public HanoiGameService(int towerCount, int figureCount, int userMode, ICanvas image) {
        this.user = new UserFactory().get(userMode, towerCount, figureCount);
        this.towers = Tower2.getTowers(towerCount, figureCount, image);
        this.image = image;
    }

    /**
     * Запуск игры
     */
    public void run() {
        do {

            draw();

        }while (round() && !isEndGame());

        draw();

        if (isEndGame()) {
            System.out.println("Поздравляю ваша игра заняла: " + count + " ходов");
        }

        save();
    }

    private void save() {
        if (!(user instanceof PersonUser)) {
            return;
        }
        System.out.println("Сохранить игру? (да/другой ответ): ");

        Scanner console = new Scanner(System.in);

        if (console.nextLine().equalsIgnoreCase("да")) {
            System.out.println("Сохранить(имя файла): ");
            String fileName = console.nextLine() + ".hanoiGame";
            Path pathOfFile = Path.of(fileName);

            try {
                Files.deleteIfExists(pathOfFile);
                Files.createFile(pathOfFile);

            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(fileName));
                writer.writeObject(this);

            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }


    private boolean isEndGame() {
        for (int i = 1; i < towers.size(); i++) {
            if (towers.get(i).isFull()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Отрисовка поля
     */
    private void draw() {
        image.clear();

        for (BaseTower<? extends Figure> tower : towers) {
            tower.draw();
        }

        image.printMyself();
    }

    /**
     * Запись хода
     */
    private void setCount() {
        count++;
    }

    /**
     * Запуск раунда(хода)
     */
    private boolean round() {
        int[] fromTo = user.getNextMove();

        int from = fromTo[0];
        int to = fromTo[1];

        if (from == -1 || to == -1) {
            return false;
        }

        if (towers.get(from).test(towers.get(to).watchFigure())){
            Figure moveFigure = towers.get(from).getFigure();
            towers.get(to).add(moveFigure);
        }

        setCount();

        return true;
    }
}

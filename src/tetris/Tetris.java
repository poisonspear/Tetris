package tetris;

/**
 * Created by IntelliJ IDEA.
 * Author  Suknatov Aleksey
 * Date    19.09.2016
 */
public class Tetris {
    private static Figure figure;
    private static Field field;
    private boolean isGameOver;


    private static Tetris tetris;

    public static Figure getFigure() {
        return figure;
    }

    public static Field getField() {
        return field;
    }

    public boolean isGameOver() {
        return isGameOver;
    }

    public Tetris(int width, int height) {
        field = new Field(width, height);
        figure = null;
    }

    public void start() throws InterruptedException {
        isGameOver = false;
        //construct first figure
        figure = FigureFactory.getRandomFigure(field.getWidth() / 2, 0);
        while (!isGameOver) {
            //listen keyboard events
            //handle keyboard events

            step();
            field.print();
            //sleeping between steps
            Thread.sleep(400);
        }
        System.out.println("GAME OVER");
    }

    public void step() {
        figure.down();
        if (!figure.isCurrentPositionOK()) {
            figure.up();
            figure.fix();
            if (figure.getY() <= 1)
                isGameOver = true;
            field.removeFullLines();
            figure = FigureFactory.getRandomFigure(field.getWidth() / 2, 0);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        tetris = new Tetris(10, 20);
        tetris.start();
    }
}

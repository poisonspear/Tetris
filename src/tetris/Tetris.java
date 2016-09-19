package tetris;

import java.awt.event.KeyEvent;

/**
 * Created by IntelliJ IDEA.
 * Author  Suknatov Aleksey
 * Date    19.09.2016
 */
public class Tetris {
    private static Figure figure;
    private static Field field;
    private boolean isGameOver;


    public static Tetris tetris;

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
        KeyObserver keyObserver = new KeyObserver();
        keyObserver.start();

        //print canvas
        new Printer().start();

        while (!isGameOver) {
            //listen keyboard events
            //handle keyboard events
            if (keyObserver.hasKeyEvents()) {
                KeyEvent keyEvent = keyObserver.getEvent();
                //figure direction
                if (keyEvent.getKeyCode() == KeyEvent.VK_LEFT)
                    figure.left();
                if (keyEvent.getKeyCode() == KeyEvent.VK_RIGHT)
                    figure.right();
                if (keyEvent.getKeyCode() == KeyEvent.VK_DOWN)
                    figure.down();
                if (keyEvent.getKeyCode() == KeyEvent.VK_UP)
                    figure.up();
                if (keyEvent.getKeyCode() == KeyEvent.VK_ENTER)
                    figure.flip();
                if (keyEvent.getKeyCode() == KeyEvent.VK_SPACE)
                    figure.fullDown();
            }

            step();
            System.out.println("---------------------------------------------------");
            //field.print();
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

package tetris;

/**
 * Created by IntelliJ IDEA.
 * Author  Suknatov Aleksey
 * Date    19.09.2016
 */
public class Tetris {
    private Figure figure;
    private Field field;
    private boolean isGameOver;


    private static Tetris tetris;

    public Tetris(int width, int height) {
        field = new Field(width, height);
        field = null;
    }

    public void start() throws InterruptedException {
        isGameOver = false;

        while (!isGameOver) {
            //listen keyboard events
            //handle keyboard events

            step();

            Thread.sleep(400);
        }
        System.out.println("GAME OVER");
    }

    public void step() {
          field.print();
    }

    public static void main(String[] args) throws InterruptedException {
        tetris = new Tetris(10, 20);
        tetris.start();
    }
}

package tetris;

/**
 * Created by IntelliJ IDEA.
 * Author  Suknatov Aleksey
 * Date    19.09.2016
 */
public class Printer extends Thread {
    public void run() {
        while (!Tetris.tetris.isGameOver()) {
            Tetris.getField().print();
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

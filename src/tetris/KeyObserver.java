package tetris;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by IntelliJ IDEA.
 * Author  Suknatov Aleksey
 * Date    19.09.2016
 */
public class KeyObserver extends Thread {
    BlockingQueue<KeyEvent> keyEvents = new ArrayBlockingQueue<KeyEvent>(10);
    @Override
    public void run() {
        //something to keyboard control
        JFrame jFrame = new JFrame("Tetris");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);

        jFrame.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                keyEvents.add(e);
            }
        });


    }
    public boolean hasKeyEvents() {
        return !keyEvents.isEmpty();
    }

    public KeyEvent getEvent() {
        return keyEvents.poll();
    }
}

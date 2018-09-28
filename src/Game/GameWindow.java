package Game;

import Game.GameCanvas;
import base.KeyEventPress;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameWindow extends JFrame {

    GameCanvas canvas;

    public GameWindow() {
        //setup Window
        this.setSize( 800 ,600);
        this.setResizable(false); // không cho người dùng chỉnh sửa kích thước
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setUpEventListtener();
        // init game
        this.canvas = new GameCanvas();
        this.add(canvas);
        this.setVisible(true); // cho phép cửa sổ hiện ra

    }

    private void setUpEventListtener() {
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_W){
                    KeyEventPress.isUpPress = true;
                }
                if (e.getKeyCode() == KeyEvent.VK_S){
                    KeyEventPress.isDownPress = true;
                }
                if (e.getKeyCode() == KeyEvent.VK_D){
                    KeyEventPress.isLeftPress = true;
                }
                if (e.getKeyCode() == KeyEvent.VK_A){
                    KeyEventPress.isRightPress = true;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_W){
                    KeyEventPress.isUpPress = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_S){
                    KeyEventPress.isDownPress = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_D){
                    KeyEventPress.isLeftPress = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_A){
                    KeyEventPress.isRightPress = false;
                }
            }


        });
    }


    void gameLoop() {
        long delay = 1000/60;
        long lastTime = 0;
        while (true) {
            long currentTime = System.currentTimeMillis();
            if( currentTime - lastTime > delay) {
                canvas.run();
                this.repaint();
                lastTime = currentTime;
            }
        }
    }

    // paintCom

}


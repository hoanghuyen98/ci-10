package Game;

import Game.GameCanvas;
import base.KeyEventPress;
import base.Player;

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
                if (e.getKeyCode() == KeyEvent.VK_UP){
                    KeyEventPress.isUpPress = true;
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN){
                    KeyEventPress.isDownPress = true;
                }
                if (e.getKeyCode() == KeyEvent.VK_LEFT){
                    KeyEventPress.isLeftPress = true;
                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT){
                    KeyEventPress.isRightPress = true;
                }
                if (e.getKeyCode() == KeyEvent.VK_SPACE){
                    KeyEventPress.isSpacePress = true;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_UP){
                    KeyEventPress.isUpPress = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN){
                    KeyEventPress.isDownPress = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_LEFT){
                    KeyEventPress.isLeftPress = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT){
                    KeyEventPress.isRightPress = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_SPACE){
                    KeyEventPress.isSpacePress = false;
                }
            }


        });
    }


    public void gameLoop() {
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


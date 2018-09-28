package Game;

import Game.GameCanvas;
import base.KeyEventPress;
import base.Settings;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameOver extends JFrame {
    GameCanvas canvas;
    public GameOver(){
        // setup
        this.setSize(Settings.SCREEN_WIDHT, Settings.SCREEN_HEIGHT);
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setUpEventListtener();
        // init
        this.canvas = new GameCanvas();
        this.add(canvas);
        this.setVisible(true);
    }

    private void setUpEventListtener() {
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_W){
                    KeyEventPress.isUpPree = true;
                }
                if(e.getKeyCode() == KeyEvent.VK_S){
                    KeyEventPress.isDownPree = true;
                }
                if(e.getKeyCode() == KeyEvent.VK_D){
                    KeyEventPress.isRightPree = true;
                }
                if(e.getKeyCode() == KeyEvent.VK_A){
                    KeyEventPress.isLeftPree = true;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_W){
                    KeyEventPress.isUpPree = false;
                }
                if(e.getKeyCode() == KeyEvent.VK_S){
                    KeyEventPress.isDownPree = false;
                }
                if(e.getKeyCode() == KeyEvent.VK_D){
                    KeyEventPress.isRightPree = false;
                }
                if(e.getKeyCode() == KeyEvent.VK_A){
                    KeyEventPress.isLeftPree = false;
                }
            }
        });
    }

    public void GameLoop(){
        long delay = 1000/60;
        long lastTime = 0;
        while(true){
            long currentTime = System.currentTimeMillis();
            if(currentTime - lastTime > delay){
                canvas.run();
                this.repaint();
                lastTime = currentTime;
            }
        }
    }

}

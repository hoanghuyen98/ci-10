package Game;

import base.BackGround;
import base.Enemy;
import base.Player;
import base.PlayerBullet;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GameCanvas extends JPanel {
    BackGround backGround;
    Player player;
    Enemy enemy;

    public static ArrayList<Enemy> enemies ;
    public static ArrayList<PlayerBullet> playerBullets;

    public GameCanvas(){
        this.backGround = new BackGround();
        this.player = new Player();
        this.enemy = new Enemy();
        enemies = new ArrayList<>();
        playerBullets = new ArrayList<>();
    }

    public void run(){
        backGround.run();
        player.run();
        for(Enemy enemy : enemies){
            enemy.run();
        }
        for(PlayerBullet playerBullet: playerBullets){
            playerBullet.run();
        }
    }

    public void render(Graphics g){
        backGround.render(g);
        player.render(g);

        for(Enemy enemy: enemies){
            enemy.render(g);
        }
        for(PlayerBullet playerBullet : playerBullets){
            playerBullet.render(g);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        this.render(g);
    }
}

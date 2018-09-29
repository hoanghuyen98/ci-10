package base;

import Game.GameCanvas;
import base.renderer.AnimationRenderer;
import com.sun.xml.internal.ws.api.config.management.policy.ManagementAssertion;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Player extends GameObject {
    ArrayList<PlayerBullet> playerBullets;

    public Player(){
        ArrayList<BufferedImage> images = new ArrayList<>();
        images.add(SpriteUtils.loadImage("assets/images/players/straight/0.png"));
        images.add(SpriteUtils.loadImage("assets/images/players/straight/1.png"));
        images.add(SpriteUtils.loadImage("assets/images/players/straight/2.png"));
        images.add(SpriteUtils.loadImage("assets/images/players/straight/3.png"));
        images.add(SpriteUtils.loadImage("assets/images/players/straight/4.png"));
        images.add(SpriteUtils.loadImage("assets/images/players/straight/5.png"));
        images.add(SpriteUtils.loadImage("assets/images/players/straight/6.png"));
        this.renderer = new AnimationRenderer(images);
        this.position = new Vector2D(Settings.START_PLAYER_POSITION_X, Settings.START_PLAYER_POSITION_Y);
        this.playerBullets = new ArrayList<>();
    }


    public void  move(int translatex, int translatey){

        this.position.addThis(translatex, translatey);
    }

    public void shoot(){
        PlayerBullet playerBullet = new PlayerBullet();
        playerBullet.position.x = this.position.x;
        playerBullet.position.y = this.position.y;
        GameCanvas.playerBullets.add(playerBullet);
//        this.position.y ++;
//        playerBullet.run();
    }


    @Override
    public void run(){
        if (KeyEventPress.isUpPress) {
            this.move(0, -1);
        }
        if (KeyEventPress.isDownPress) {
            this.move(0, 1);
        }
        if (KeyEventPress.isLeftPress) {
            this.move(-1, 0);
        }
        if (KeyEventPress.isRightPress) {
            this.move(1, 0);
        }
        if (KeyEventPress.isSpacePress) {
            this.shoot();
        }
    }

}

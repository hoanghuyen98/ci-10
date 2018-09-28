package base;

import Game.GameCanvas;
import base.renderer.AnimationRenderer;
import base.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Player extends GameObject{
    public Player(){
//        BufferedImage image = SpriteUtils.loadImage("assets/images/players/straight/0.png");
        ArrayList<BufferedImage> images = new ArrayList<>();

        images.add(SpriteUtils.loadImage("assets/images/players/straight/0.png"));
        images.add(SpriteUtils.loadImage("assets/images/players/straight/1.png"));
        images.add(SpriteUtils.loadImage("assets/images/players/straight/2.png"));
        images.add(SpriteUtils.loadImage("assets/images/players/straight/3.png"));
        images.add(SpriteUtils.loadImage("assets/images/players/straight/4.png"));
        images.add(SpriteUtils.loadImage("assets/images/players/straight/5.png"));
        images.add(SpriteUtils.loadImage("assets/images/players/straight/6.png"));

        this.renderer = new AnimationRenderer(images);
        this.position = new Vector2D(
                                     Settings.START_PLAYER_POSITION_X,
                                     Settings.START_PLAYER_POSITION_Y
                                    );


    }
    void shoot(){
//        ...
        PlayerBullet bullet = new PlayerBullet();

        GameCanvas.playerBullets.add(bullet);
    }

    public void move(int translatex,int translatey){
        this.position.addThis(translatex,translatey);
    }

    @Override
    public void run() {
        if(KeyEventPress.isUpPree){
            this.move(0,-1);
        }
        if(KeyEventPress.isDownPree){
            this.move(0,1);
        }
        if(KeyEventPress.isRightPree){
            this.move(1,0);
        }
        if(KeyEventPress.isLeftPree){
            this.move(-1,0);
        }
    }
}

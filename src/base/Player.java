package base;

import base.counter.FrameCounter;
import base.directionbullet.LeftBullets;
import base.directionbullet.RightBullets;
import base.renderer.AnimationRenderer;
import base.renderer.SingleImageRenderer;
import game.GameCanvas;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Player extends GameObject implements Physics{
    FrameCounter fireCounter;
    BoxCollider collider;
    boolean onOff=false;
    public Player() {
        super();
        ArrayList<BufferedImage> images = SpriteUtils.loadImages(
                "assets/images/players/straight/0.png",
                "assets/images/players/straight/1.png",
                "assets/images/players/straight/2.png",
                "assets/images/players/straight/3.png",
                "assets/images/players/straight/4.png",
                "assets/images/players/straight/5.png",
                "assets/images/players/straight/6.png"
        );
        this.renderer = new AnimationRenderer(images);
        this.position = new Vector2D(Settings.START_PLAYER_POSITION_X
                , Settings.START_PLAYER_POSITION_Y);
        this.fireCounter = new FrameCounter(10);
        this.collider = new BoxCollider(28,28);
    }

    @Override
    public void run() {
        if(KeyEventPress.isUpPress) {
            this.move(0, -1);
        }
        if(KeyEventPress.isDownPress) {
            this.move(0, 1);
        }
        if(KeyEventPress.isRightPress) {
            this.move(1, 0);
        }
        if(KeyEventPress.isLeftPress) {
            this.move(-1, 0);
        }
        //fire
        boolean fireCounterRun = this.fireCounter.run();

        if(KeyEventPress.isFirePress  ) {
            onOff=true;
            if( fireCounterRun)
            this.fire();
        }
        if(!KeyEventPress.isFirePress){

            if( fireCounterRun && this.fireCounter.check<3 && onOff==true){
                this.fireCounter.check++;
                this.fire();
            }

            if(this.fireCounter.check>=3){
                this.fireCounter.check=0;
                onOff=false;
            }
        }
    }

    public void fire() {
//        PlayerBullet bullet = new PlayerBullet();
//        GameCanvas.playerBullets.add(bullet);
        PlayerBullet bullet = GameObject.recycle(PlayerBullet.class);
        LeftBullets bullet1 = GameObject.recycle(LeftBullets.class);
        RightBullets bullet2 = GameObject.recycle(RightBullets.class);
//        bullet.velocit
        bullet.position.set(this.position.x, this.position.y);
        bullet1.position.set(this.position.x, this.position.y);
        bullet2.position.set(this.position.x, this.position.y);
        this.fireCounter.reset();
    }


    public void move(int translateX, int translateY) {
        this.position.addThis(translateX, translateY);
    }
    @Override
    public BoxCollider getBoxCollider() {
        return this.collider;
    }
}

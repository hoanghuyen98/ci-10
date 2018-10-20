package base.enemy;

import base.Settings;
import base.physics.BoxCollider;
import base.GameObject;
import base.physics.Physics;
import base.Vector2D;
import base.action.Action;
import base.action.ActionRepeat;
import base.action.ActionSequence;
import base.action.ActionWait;
import base.renderer.AnimationRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

public class Enemy extends GameObject implements Physics {//
//    FrameCounter fireCounter;
    BoxCollider collider;
    Action action;
    int checkx = rand(-3,3);

    public Enemy() {
        super();
        ArrayList<BufferedImage> images = SpriteUtils.loadImages(
                "assets/images/enemies/level0/pink/0.png",
                "assets/images/enemies/level0/pink/1.png",
                "assets/images/enemies/level0/pink/2.png",
                "assets/images/enemies/level0/pink/3.png"
            );
        this.renderer = new AnimationRenderer(images);
        this.setPosition();
//        this.position = new Vector2D(200, 100);
//        this.fireCounter = new FrameCounter(20);
        this.collider = new BoxCollider(28,28);
        this.defineAction();

    }
    void defineAction(){
        ActionWait actionWait = new ActionWait(50);
        Action actionFire = new Action() {
            @Override
            public void run(GameObject master) {
                fire();
                this.isDone = true;
            }

            @Override
            public void reset() {
                this.isDone = false;
            }
        };
        ActionSequence actionSequence = new ActionSequence(actionWait, actionFire);
        ActionRepeat actionRepeat = new ActionRepeat(actionSequence);
        this.action = actionRepeat;
    }

    @Override
    public void setPosition() {
        super.setPosition();
        //
        this.position= new Vector2D(new Random().nextInt(370),0 );
    }

    public void fire(){

        EnemyBullet bullet = GameObject.recycle(EnemyBullet.class);
//        EnemyBullet bullet2 = GameObject.recycle(EnemyBullet.class);
//        EnemyBullet bullet3 = GameObject.recycle(EnemyBullet.class);

//        bullet.velocity.set(0,1);
//        bullet.velocity.set(1,-1);
//        bullet.velocity.set(-1,-1);

        bullet.position.set(this.position.x, this.position.y + 5);
//        bullet2.position.set(this.position.x, this.position.y);
//        bullet3.position.set(this.position.x, this.position.y);

//        this.fireCounter.reset();

    }
    public static int rand(int min, int max) {
        try {
            Random rn = new Random();
            int range = max - min + 1;
            int randomNum = min + rn.nextInt(range);
            return randomNum;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
    @Override
    public void run() {
//        boolean fireCounterRun = this.fireCounter.run();
//        if(fireCounterRun){
        this.action.run(this);
//            this.fireCounter.reset();
        this.position.addThis(checkx,5);
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.collider;
    }//
}

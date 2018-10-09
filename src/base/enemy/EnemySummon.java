package base.enemy;

import base.GameObject;
import base.action.Action;
import base.action.ActionRepeat;
import base.action.ActionSequence;
import base.action.ActionWait;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class EnemySummon extends GameObject  {
Action action;
    ArrayList<Enemy> arr =new ArrayList<>();
    public EnemySummon(){
//        ArrayList<BufferedImage> images = SprssssssaasssssaddddddddwiteUtils.loadImages(""
        taoRaNhieuQuaiVat();

    }
    public void taoRaNhieuQuaiVat(){
        ActionWait actionWait = new ActionWait(200);
        base.action.Action actionFire = new Action() {
            @Override
            public void run(GameObject master) {
                taoQuaiVat();
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
    public void taoQuaiVat(){
        for(int i=0;i<5;i++){
            Enemy a = GameObject.recycle(Enemy.class);
            this.arr.add(a);
        }
    }

    @Override
    public void run() {
        this.action.run(this);

    }
}

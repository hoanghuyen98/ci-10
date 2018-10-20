package base;

import base.action.Action;
import base.action.ActionRepeat;
import base.action.ActionSequence;
import base.action.ActionWait;
import base.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Background extends GameObject {
    Action action;
    int index=0;
    String[] diaChiAnh;
    public Background() {
        super();
        BufferedImage image = SpriteUtils.loadImage("assets/images/background/0.png");
        BufferedImage image1 = SpriteUtils.loadImage("assets/images/background/0.png");
        this.renderer = new SingleImageRenderer(image);
        this.position = new Vector2D(0,
                -(image.getHeight() - Settings.SCREEN_HEIGHT));
        diaChiAnh= new String[]{
                "assets/images/background/1.png",
                "assets/images/background/2.jpg",
                "assets/images/background/3.jpg",
                "assets/images/background/4.jpg",
                "assets/images/background/6.png",
                "assets/images/background/8.jpg"
        };
        defineAction();
    }
    void defineAction(){
        ActionWait actionWait = new ActionWait(300);
        Action actionFire = new Action() {
            @Override
            public void run(GameObject master) {
                try {
                    BufferedImage image = SpriteUtils.loadImage(diaChiAnh[index++]);

                    renderer = new SingleImageRenderer(image);
                    position = new Vector2D(0,
                            -(image.getHeight() - Settings.SCREEN_HEIGHT));
                    this.isDone = true;
                }catch (Exception e){
                    index=0;
                }
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
    public void run() {
        this.action.run(this);
        if(this.position.y >= 0) {
            return;
        } else {
            this.position.y += 2/*speed*/;
        }
    }
}

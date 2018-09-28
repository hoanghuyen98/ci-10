package base;

import base.renderer.AnimationRenderer;
import tklibs.SpriteUtils;

import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Enemy extends GameObject{
    public Enemy(){
//        BufferedImage image = SpriteUtils.loadImage("assets/images/enemies/level0/black/0.png");
        ArrayList<BufferedImage> image = new ArrayList<>();
        image.add(SpriteUtils.loadImage("assets/images/enemies/level0/black/0.png"));
        image.add(SpriteUtils.loadImage("assets/images/enemies/level0/black/1.png"));
        image.add(SpriteUtils.loadImage("assets/images/enemies/level0/black/2.png"));
        image.add(SpriteUtils.loadImage("assets/images/enemies/level0/black/3.png"));
        image.add(SpriteUtils.loadImage("assets/images/enemies/level0/black/4.png"));
        image.add(SpriteUtils.loadImage("assets/images/enemies/level0/black/5.png"));
        image.add(SpriteUtils.loadImage("assets/images/enemies/level0/black/6.png"));
        image.add(SpriteUtils.loadImage("assets/images/enemies/level0/black/7.png"));
        image.add(SpriteUtils.loadImage("assets/images/enemies/level0/black/8.png"));
        this.renderer = new AnimationRenderer(image);
        this.position = new Vector2D(
                Settings.START_ENEMY_POSITION_X,
                Settings.START_ENEMY_POSITION_Y
        );
    }



}

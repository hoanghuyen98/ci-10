package base.player;

import base.GameObject;
import base.renderer.BoxColliderRenderer;
import base.scene.SceneManager;
import base.snack.Snack;
import game.GameCanvas;

import java.awt.*;

public class SnakeHead extends SnakePart {
    public SnakeHead() {
        super();
        this.renderer = new BoxColliderRenderer(Color.green);
    }

    @Override
    public void run() {
        this.checkIntersects();
    }

    private void checkIntersects() {
        //intersect with snake's parts
        //intersect with food
        Snack snack = GameObject.intersect(Snack.class, this);
        if(snack != null) {
            snack.destroy();
            SceneManager.currentScene.player.growUp();
        }
    }
}

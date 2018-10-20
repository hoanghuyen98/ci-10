package base.player;

import base.GameObject;
import base.Settings;
import base.Vector2D;
import base.counter.FrameCounter;
import base.event.KeyEventPress;
import base.scene.Scene;
import base.scene.SceneManager;
import base.scene.SceneStage1;

import java.util.ArrayList;
import java.util.Set;

public class Player extends GameObject {
    ArrayList<SnakePart> parts;
    SnakeHead head;
    FrameCounter moveCounter;
    int direction;
    SnakePart newPart;

    public Player() {
        super();
        this.moveCounter = new FrameCounter(3);
        this.position.set(190, 290);
        this.initParts();
        this.direction = Settings.UP;
        this.newPart = GameObject.recycle(SnakePart.class);
    }

    private void initParts() {
        this.parts = new ArrayList<>();
        this.head = GameObject.recycle(SnakeHead.class);
        this.head.position.set(this.position);
        SnakePart tail = GameObject.recycle(SnakePart.class);
        tail.position.set(this.head.position.add(0, -Settings.WAY_SIZE));
        this.parts.add(this.head);
        this.parts.add(tail);
    }

    FrameCounter newSceneCounter = new FrameCounter(500);
    @Override
    public void run() {
        this.setDirection();
        if(this.moveCounter.run()) {
            this.move();
            this.setPartsPosition();
            this.moveCounter.reset();
        }
        if(newSceneCounter.run()) {
            System.out.println("new scene coming");
            SceneManager.signNewScene(new SceneStage1());
        }
    }
    private void setDirection() {
        if(KeyEventPress.isUpPress && this.direction != Settings.DOWN) {
            this.direction = Settings.UP;
        } else if(KeyEventPress.isDownPress && this.direction != Settings.UP) {
            this.direction = Settings.DOWN;
        } else if(KeyEventPress.isLeftPress && this.direction != Settings.RIGHT) {
            this.direction = Settings.LEFT;
        } else if(KeyEventPress.isRightPress && this.direction != Settings.LEFT) {
            this.direction = Settings.RIGHT;
        }
    }

    private void move() {
        switch (this.direction) {
            case Settings.UP: {
                this.position.addThis(0, -Settings.WAY_SIZE);
                break;
            }
            case Settings.DOWN: {
                this.position.addThis(0, Settings.WAY_SIZE);
                break;
            }
            case Settings.LEFT: {
                this.position.addThis(-Settings.WAY_SIZE, 0);
                break;
            }
            case Settings.RIGHT: {
                this.position.addThis(Settings.WAY_SIZE, 0);
                break;
            }
        }

    }

    private void setPartsPosition() {

        if( this.head.position.y<0){
            this.position.set(this.position.x,Settings.SCREEN_HEIGHT-Settings.WAY_SIZE/2);
        }

        if( this.head.position.y>Settings.SCREEN_HEIGHT){
            this.position.set(this.position.x,0+Settings.WAY_SIZE/2);
        }
        if( this.head.position.x<0){
            this.position.set(Settings.SCREEN_WIDHT-Settings.WAY_SIZE/2,this.position.y);
        }
        if( this.head.position.x>Settings.SCREEN_WIDHT){
            this.position.set(0+Settings.WAY_SIZE/2,this.position.y);
        }

        if(this.newPart != null) {
            parts.add(1, this.newPart);
            this.newPart.position.set(this.head.position);
            this.newPart = null;
        } else {
            for(int i = this.parts.size() - 1; i > 0; i--) {
                SnakePart part = this.parts.get(i);
                SnakePart prevPart = this.parts.get(i - 1);
                part.position.set(prevPart.position);
            }
        }
        if( this.head.position.x<0){
            this.head.position.set(Settings.WAY_SIZE-1,this.head.position.y);
        }

        this.head.position.set(this.position);

    }


    public void growUp() {
        this.newPart = GameObject.recycle(SnakePart.class);
    }
}

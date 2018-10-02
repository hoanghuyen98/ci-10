package base.directionbullet;

import base.PlayerBullet;

public class LeftBullets extends PlayerBullet {
    @Override
    public void run() {
        this.position.addThis(-3, -3);
    }
}

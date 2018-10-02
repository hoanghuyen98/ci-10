package base.directionbullet;

import base.PlayerBullet;

public class RightBullets extends PlayerBullet {
    @Override
    public void run() {
        this.position.addThis(3,-3);
    }
}

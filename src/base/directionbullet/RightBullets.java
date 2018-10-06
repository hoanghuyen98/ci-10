package base.directionbullet;

import base.PlayerBullet;

public class RightBullets extends PlayerBullet {
    @Override
    public void run() {
        if(this.position.y < 0){
            this.destroy();
            return;
        }
        this.position.addThis(3,-3);
    }
}

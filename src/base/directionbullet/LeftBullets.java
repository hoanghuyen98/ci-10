package base.directionbullet;

import base.PlayerBullet;

public class LeftBullets extends PlayerBullet {
    @Override
    public void run() {
        if(this.position.y < 0){
            this.destroy();
            return;
        }
        this.position.addThis(-3, -3);
    }
}

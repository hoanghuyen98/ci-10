package base.directionbullet;

import base.*;

public class LeftBullets extends PlayerBullet implements Physics {
    @Override
    public void run() {
        Enemy enemy = GameObject.intersect(Enemy.class, this);

        if(enemy != null){
            enemy.destroy();
            this.destroy();
            return;
        }
        if(this.position.y < 0){
            this.destroy();
            return;
        }
        this.position.addThis(-3, -3);
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.collider;
    }
}

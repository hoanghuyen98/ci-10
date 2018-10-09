package game;

import base.*;
import base.action.Action;
import base.action.ActionRepeat;
import base.action.ActionSequence;
import base.action.ActionWait;
import base.enemy.Enemy;
import base.enemy.EnemySummon;
import base.player.Player;

import javax.swing.*;
import java.awt.*;

public class GameCanvas extends JPanel {
    Background background;
    Player player;
    public GameCanvas() {
        this.background = GameObject.create(Background.class);
        this.player = GameObject.recycle(Player.class);
        EnemySummon enemy = GameObject.recycle(EnemySummon.class);


    }

    public void run() {
        GameObject.runAll();
    }

    public void render(Graphics g) {
        GameObject.renderAll(g);
    }

    @Override
    protected void paintComponent(Graphics g) {
        this.render(g);
    }
}

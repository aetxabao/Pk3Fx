package edu.masanz.da.pk3.sprite.enemies;

import edu.masanz.da.pk3.sprite.interfaces.IHaveShield;

import static edu.masanz.da.pk3.game.AppConsts.*;

public class BombEnemy extends AEnemy implements IHaveShield {

    private int shield = E_BOMB_SHIELD;

    public BombEnemy() {
        super(E_BOMB_SPRITE_IMAGE, E_BOMB_SPRITE_ROWS, E_BOMB_SPRITE_COLS);
        currentFrame = (int) (Math.random()*cols);
    }

    @Override
    public void update() {
        currentFrame = ++currentFrame%cols;
    }

    @Override
    public boolean impact() {
        shield--;
        return shield == 0;
    }
}

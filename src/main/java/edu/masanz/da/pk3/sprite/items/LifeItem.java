package edu.masanz.da.pk3.sprite.items;

import edu.masanz.da.pk3.game.AppStatus;
import edu.masanz.da.pk3.game.GameObject;

import static edu.masanz.da.pk3.game.AppConsts.*;

public class LifeItem extends AItem {

    public LifeItem() {
        super(I_LIFE_SPRITE_IMAGE, I_LIFE_SPRITE_ROWS, I_LIFE_SPRITE_COLS);
        currentFrame = (int) (Math.random()*cols);
    }

    @Override
    public void useItem() {
        AppStatus appStatus = GameObject.getInstance().getAppStatus();
        appStatus.increaseLifes();
    }

    @Override
    public void update() {
        currentFrame = ++currentFrame%cols;
    }

}

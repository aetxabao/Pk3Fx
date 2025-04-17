package edu.masanz.da.pk3.sprite.items;

import edu.masanz.da.pk3.game.GameObject;
import edu.masanz.da.pk3.sprite.Hero;

import static edu.masanz.da.pk3.game.AppConsts.*;

public class AmmunitionItem extends AItem {

    private int ammunition;

    public AmmunitionItem(int ammunition) {
        super(I_AMMUNITION_SPRITE_IMAGE_SMALL, I_AMMUNITION_SPRITE_ROWS, I_AMMUNITION_SPRITE_COLS);
        if (ammunition > 5) {
            setImg(I_AMMUNITION_SPRITE_IMAGE_LARGE);
        }
        this.ammunition = ammunition;
    }

    @Override
    public void useItem() {
        Hero hero = GameObject.getInstance().getHero();
        hero.rechargeAmmunition(ammunition);
    }

    @Override
    public void update() {
    }

}

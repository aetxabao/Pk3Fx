package edu.masanz.da.pk3.sprite.weaponry;

import edu.masanz.da.pk3.sprite.ASprite;
import edu.masanz.da.pk3.sprite.interfaces.IIsDisposable;

import java.util.ArrayList;
import java.util.List;

import static edu.masanz.da.pk3.game.AppConsts.SHOT_SPEED;

public class CrossGun extends AWeapon implements IIsDisposable {

    private boolean isDisposable;

    public CrossGun(ASprite owner) {
        super(owner);
    }

    public CrossGun(ASprite owner, boolean isRechargable, int ammunition, boolean isDisposable) {
        super(owner, isRechargable, ammunition);
        this.isDisposable = isDisposable;
    }


    @Override
    public List<AShot> shoot() {
        List<AShot> list = new ArrayList<>();
        if (isRechargable) {
            if (ammunition == 0) {
                return list;
            }
            ammunition--;
        }
        int[] a = {0, 90, 180, 270};
        for (int i = 0; i < 4; i++) {
            AShot shot = new Cannonball();
            shot.setPos(owner.getRect().centerX(), owner.getRect().centerY());
            shot.setSpeed(SHOT_SPEED, a[i]);
            list.add(shot);
        }
        return list;
    }

    @Override
    public boolean isDisposable() {
        return isDisposable;
    }
}

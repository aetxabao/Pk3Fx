package edu.masanz.da.pk3.sprite.enemies;

import edu.masanz.da.pk3.game.GameArea;
import edu.masanz.da.pk3.game.GameManager;
import edu.masanz.da.pk3.sprite.weaponry.CrossGun;
import org.apache.log4j.Logger;

import static edu.masanz.da.pk3.game.AppConsts.*;

public class FlyingBouncerEnemy extends AMovableEnemy {

    private static Logger log = Logger.getLogger(GameManager.class);

    public FlyingBouncerEnemy() {
        super(E_VWX_SPRITE_IMAGE, E_VWX_SPRITE_ROWS, E_VWX_SPRITE_COLS);
        setSpeed(E_VWX_SPEED, 0);
        setWeapon(new CrossGun(this));
    }

    public FlyingBouncerEnemy(int angleDegrees) {
        this();
        setSpeed(E_VWX_SPEED, angleDegrees);
        setWeapon(new CrossGun(this));
        log.debug(this.toString() + ", angleDegrees=" + angleDegrees);
    }


    @Override
    public boolean canGoToNextPosition() {
        if (x > GameArea.rect.right - width - xSpeed || x + xSpeed < GameArea.rect.left) {
            return false;
        }
        if (y + height + ySpeed > GameArea.rect.bottom || y + ySpeed < GameArea.rect.top) {
            return false;
        }
        return true;
    }

    @Override
    public void goToNextPosition() {
        x = x + xSpeed;
        y = y + ySpeed;
    }

    @Override
    public void changeRoute() {
        if (x > GameArea.rect.right - width - xSpeed || x + xSpeed < GameArea.rect.left) {
            xSpeed = -xSpeed;
        }
        if (y + height + ySpeed > GameArea.rect.bottom || y + ySpeed < GameArea.rect.top) {
            ySpeed = -ySpeed;
        }
    }

    @Override
    public void updateFrame(){
        if (currentFrame == 0) {
            currentFrame = 1;
        }else{
            currentFrame = 0;
        }
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() +
                ", x=" + x +
                ", y=" + y +
                ", xSpeed=" + xSpeed +
                ", ySpeed=" + ySpeed +
                ", width=" + width +
                ", height=" + height +
                ", weapon=" +  getWeapon() ;
    }
}

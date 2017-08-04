package com.fogok.recegame.control;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Polygon;
import com.fogok.recegame.view.GameScreen;

/**
 * Created by Code on 04.08.2017.
 */

public class CarController {

    private Polygon carBounds;
    public CarController(Polygon carBounds){
        this.carBounds = carBounds;
    }

    float speed, speedVelocity = 0.1f, speedMax = 3f;
    public void handle(){
        if(Gdx.input.isKeyPressed(Input.Keys.UP))
            speed += speedVelocity;
        else if(Gdx.input.isKeyPressed(Input.Keys.DOWN))
            speed -= speedVelocity;
        else
            dawnSpeed();

        speed = sliceSpeed();


        carBounds.setPosition(carBounds.getX() + MathUtils.cosDeg(carBounds.getRotation() + 90)* speed * GameScreen.deltaCff,
                        carBounds.getY() + MathUtils.sinDeg(carBounds.getRotation() + 90)* speed * GameScreen.deltaCff);
    }
    private void dawnSpeed(){
        if (speed > speedVelocity)
            speed -= speedVelocity;
        else if (speed < speedVelocity)
            speed +=speedVelocity;
        else
            speed = 0f;
    }

    private float sliceSpeed(){
        if(speed > speedMax)
            return speedMax;

        if (speed < -speedMax)
            return -speedMax;

        return speed;
    }
}

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

    private float carSpeed, speedVelocity = 10f, speedMax = 10f;
    private float rotationSpeed = 30f;

    public void handle(){
        //все, что связанно со скоростью
        if(Gdx.input.isKeyPressed(Input.Keys.UP))
            carSpeed += speedVelocity * GameScreen.deltaCff;
        else if(Gdx.input.isKeyPressed(Input.Keys.DOWN))
            carSpeed -= speedVelocity * GameScreen.deltaCff;
        else
            dawnSpeed();

        carSpeed = sliceSpeed();


        //все, что связанно с поворотом
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT))
            carBounds.rotate(rotationSpeed * carSpeed * GameScreen.deltaCff);
        else if(Gdx.input.isKeyPressed(Input.Keys.RIGHT))
            carBounds.rotate(-rotationSpeed * carSpeed * GameScreen.deltaCff);


        carBounds.setPosition(carBounds.getX() + MathUtils.cosDeg(carBounds.getRotation() + 90)* carSpeed * GameScreen.deltaCff,
                        carBounds.getY() + MathUtils.sinDeg(carBounds.getRotation() + 90)* carSpeed * GameScreen.deltaCff);
    }
    private void dawnSpeed(){    // гасим скорость
        if (carSpeed > speedVelocity * GameScreen.deltaCff)
            carSpeed -= speedVelocity * GameScreen.deltaCff;
        else if (carSpeed < speedVelocity * GameScreen.deltaCff)
            carSpeed +=speedVelocity * GameScreen.deltaCff;
        else
            carSpeed = 0f;
    }

    private float sliceSpeed(){ // ограничиваем скорость
        if(carSpeed > speedMax)
            return speedMax;

        if (carSpeed < -speedMax)
            return -speedMax;

        return carSpeed;
    }
}

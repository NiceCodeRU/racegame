package com.fogok.recegame.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.fogok.recegame.model.Car;
import com.fogok.recegame.model.Road;

/**
 * Created by Code on 02.08.2017.
 */

public class GameScreen implements Screen {

    private Texture carTexture, roadTexture;
    private SpriteBatch batch;
    private Car car;
    private Road road;

    @Override
    public void show() {
        batch = new SpriteBatch();
        carTexture = new Texture(Gdx.files.internal("car.png"));
        roadTexture = new Texture(Gdx.files.internal("road.jpg"));
        road = new Road(roadTexture, 0, 0, 852, 480);
        car = new Car(carTexture, 0, 0, 146, 288);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        road.draw(batch);
        car.draw(batch);
        batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        roadTexture.dispose();
        carTexture.dispose();
        batch.dispose();
    }
}

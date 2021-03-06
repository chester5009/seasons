package com.seasons.game.states;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by chester on 22.09.16.
 */

public abstract class State {

    protected OrthographicCamera camera;
    protected OrthographicCamera staticCamera;
    protected Vector3 mouse;
    protected GameStateManager gsm;

    public State(GameStateManager gsm){
        this.gsm=gsm;
        camera=new OrthographicCamera();
        staticCamera=new OrthographicCamera();
        mouse=new Vector3();

    }
    protected abstract void handleInput();
    public abstract void update(float dt);
    public abstract void render(SpriteBatch sb);
    public abstract void dispose();

}

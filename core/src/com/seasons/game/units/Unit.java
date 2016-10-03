package com.seasons.game.units;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by chester on 02.10.16.
 */

public abstract class Unit {
    protected Vector3 position;
    protected Vector3 velocity;


    protected Texture texture;
    protected int direction;

    public Unit(Texture t,Vector3 position){
        this.position=position;
        velocity=new Vector3();
        direction=0;
        texture=t;
    }

    public abstract void update(float dt);
    public abstract void draw(SpriteBatch sb);

}

package com.seasons.game.units;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by chester on 02.10.16.
 */

public class Player extends Unit {


    public Player(Texture t, Vector3 position) {
        super(t, position);
        direction=0;
    }

    public void setDirection(int dir){
        direction=dir;
    }

    @Override
    public void update(float dt) {
        if(direction==1) velocity=new Vector3(-2,0,0);
        if(direction==2) velocity=new Vector3(2,0,0);
        if(direction==0) velocity=new Vector3(0,0,0);

        position.add(velocity);

        System.out.println(direction);
    }

    @Override
    public void draw(SpriteBatch sb) {
        sb.draw(texture,position.x,position.y,50,100,0,1,1,0);
    }

    public Vector3 getPosition(){
        return this.position;
    }
    public Texture getTexture(){
        return this.texture;
    }

    public void move(Vector3 speed){
        position.add(speed);
    }
}

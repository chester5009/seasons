package com.seasons.game.units;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by chester on 02.10.16.
 */

public class Player extends Unit {

    TextureRegion textureRegion;

    int frame=0;
    float deltaTimeDraw=0;
    public Player(Texture t, Vector3 position) {
        super(t, position);
        direction=0;
        textureRegion=new TextureRegion(t,texture.getWidth()/4*frame,0,texture.getWidth()/4,texture.getHeight());
    }

    public void setDirection(int dir){
        direction=dir;
    }

    @Override
    public void update(float dt) {

        if(direction==1) velocity=new Vector3(-2,0,0);
        if(direction==2) velocity=new Vector3(2,0,0);
        if(direction==0) velocity=new Vector3(0,0,0);

        textureRegion.setRegion(texture.getWidth()/4*frame,0,texture.getWidth()/4,texture.getHeight());
        if(direction>0){
            deltaTimeDraw+= Gdx.graphics.getDeltaTime();
            if(deltaTimeDraw>0.14) {
                frame++;
                deltaTimeDraw=0;
            }
        }
        if(direction==1){
            textureRegion.flip(true,false);
        }
        if(direction==2){
            textureRegion.flip(false,false);
        }

        if(frame>3)frame=0;
        position.add(velocity);

        System.out.println(direction);
    }

    @Override
    public void draw(SpriteBatch sb) {
        sb.draw(textureRegion,position.x,position.y,textureRegion.getRegionWidth()/2,textureRegion.getRegionHeight()/2);
        //sb.draw(texture,position.x,position.y, 0,0,texture.getWidth()/4,texture.getHeight());
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

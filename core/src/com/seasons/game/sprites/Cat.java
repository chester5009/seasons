package com.seasons.game.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;

import java.util.Random;

/**
 * Created by chester on 25.09.16.
 */

public class Cat {
    Vector3 position;
    Vector3 velocity;
    Texture text;





    public Cat(int x ,int y){
        Random random=new Random();
        this.position=new Vector3(x,y,0);
        this.velocity=new Vector3(random.nextInt(4)-2,random.nextInt(4)-2,0);
        if(velocity.x==0)velocity.x=1;
        if(velocity.y==0)velocity.y=1;
        text=new Texture("cat.png");
    }

    public Texture getText() {
        return text;
    }

    public void setText(Texture text) {
        this.text = text;
    }

    public Vector3 getPosition() {
        return position;
    }

    public void setPosition(Vector3 position) {
        this.position = position;
    }


    public void update(float dt){
        position.add(velocity.x,velocity.y,0);

        if(position.x<0 || position.x+text.getWidth()> Gdx.graphics.getWidth()/2) velocity.x*=-1;
        if(position.y<0 || position.y+text.getHeight()> Gdx.graphics.getHeight()/2) velocity.y*=-1;

    }


}

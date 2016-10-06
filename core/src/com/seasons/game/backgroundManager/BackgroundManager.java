package com.seasons.game.backgroundManager;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by chester on 06.10.16.
 */

public class BackgroundManager {
    Texture texture;
    ArrayList<Float>pts;
    float step;
    public BackgroundManager(Texture texture,OrthographicCamera camera){
        pts=new ArrayList<Float>();
        pts.add(0f-camera.viewportWidth);
        pts.add(0f);
        pts.add(0f+camera.viewportWidth);
        Collections.sort(pts);
        step=camera.viewportWidth;
        this.texture=texture;
    }

    public void draw(SpriteBatch sb, OrthographicCamera camera){
        for(Float p:pts){
            sb.draw(texture,p,0,camera.viewportWidth+1,camera.viewportHeight);
        }

    }
    public void update(float x){
        if(x>pts.get(0) && x<pts.get(0)+step/2) swapLeft();
        else if(x>pts.get(2) && x<pts.get(2)+step/2) swapRight();
    }

    public void swapLeft(){
        Collections.sort(pts);
        pts.set(2,pts.get(0)-step);
        Collections.sort(pts);
    }

    public void swapRight(){
        Collections.sort(pts);
        pts.set(0,pts.get(2)+step);
        Collections.sort(pts);
    }

    public String getData(){
        return new String(" "+pts.get(0)+","+pts.get(1)+","+pts.get(2));
    }
}

package com.seasons.game.ButtonManager;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.seasons.game.ButtonManager.ButtonActions.Action;

/**
 * Created by chester on 03.10.16.
 */

public class GameButton {
    int buttonState;
    Action action;


    Texture texture;
    float u,v,u2,v2;
    Vector3 position;
    float width,height;
    public int getButtonState() {
        return buttonState;
    }

    public void setButtonState(int buttonState) {
        this.buttonState = buttonState;
    }

    public Action getAction() {
        return action;
    }

    public GameButton(Texture t,Action action,Vector3 p,float w,float h, float u, float v, float u2, float v2){
        this.texture=t;
        this.action=action;
        this.position=p;
        this.width=w;
        this.height=h;
        this.u=u;
        this.v=v;
        this.u2=u2;
        this.v2=v2;
    }

    public void draw(SpriteBatch sb){
        sb.draw(texture,position.x,position.y,width,height,u,v,u2,v2);
    }
}

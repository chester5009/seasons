package com.seasons.game.ButtonManager;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;


import java.util.ArrayList;

/**
 * Created by chester on 03.10.16.
 */

public class ButtonManager {
    ArrayList<GameButton>btns;
    ArrayList<ButtonActions.Action>actions;
    Vector3 cursor;

    boolean isPressed;

    public ButtonManager(){
        btns=new ArrayList<GameButton>();
        isPressed=false;
        cursor=new Vector3();

    }

    public void setCursor(Vector3 cursor) {
        this.cursor = cursor;
    }

    public void setPressed(boolean pressed) {
        isPressed = pressed;
    }

    public void update(float dt){
        actions=new ArrayList<ButtonActions.Action>();
        /*for(GameButton gb:btns){
            if(gb.getButtonState()==1){
                actions.add(gb.getAction());
            }
        }*/
        System.out.println(actions.size());
    }

    public ButtonActions.Action screenClick(float x,float y){
        Rectangle cursorRect=new Rectangle(x,y,1,1);
        for (GameButton gb:btns){
            Rectangle intersection=new Rectangle();
            if(Intersector.intersectRectangles(gb.getRectangle(), cursorRect,intersection)){
                gb.setButtonState(0);
                return gb.getAction();
                //actions.add(gb.getAction());
            }

        }
        return null;
    }

    /*public boolean isAction(ButtonActions.Action action){
        for(ButtonActions.Action action1:actions){
            if(action==action1) return true;
        }
        return false;
    }*/

    public void addButton(GameButton gb){
        btns.add(gb);
    }

    public void draw(SpriteBatch sb){
        for(GameButton gb:btns){
            gb.draw(sb);
        }
    }


}

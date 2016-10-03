package com.seasons.game.ButtonManager;

import com.seasons.game.ButtonManager.ButtonActions.Action;

/**
 * Created by chester on 03.10.16.
 */

public class GameButton {
    int buttonState;
    Action action;

    float u,v,u2,v2;

    public int getButtonState() {
        return buttonState;
    }

    public void setButtonState(int buttonState) {
        this.buttonState = buttonState;
    }

    public GameButton(Action action,float u,float v,float u2,float v2){
        this.action=action;
        this.u=u;
        this.v=v;
        this.u2=u2;
        this.v2=v2;
    }
}

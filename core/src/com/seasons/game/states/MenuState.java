package com.seasons.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.seasons.game.ButtonManager.*;
import com.seasons.game.ButtonManager.ButtonManager;
import com.seasons.game.ButtonManager.GameButton;

/**
 * Created by chester on 22.09.16.
 */

public class MenuState extends State {

    ButtonManager bm;
    Texture background;
    Texture playBtn;

    public MenuState(GameStateManager gsm) {
        super(gsm);
        bm=new ButtonManager();
        bm.addButton(new GameButton(playBtn, ButtonActions.));

        background=new Texture("fon.png");
        playBtn=new Texture("igrat.png");
    }

    @Override
    public void handleInput() {
        if(Gdx.input.justTouched()){
            gsm.set(new PlayState(gsm));
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();

        sb.draw(background,0,0, Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        sb.draw(playBtn,Gdx.graphics.getWidth()/2-playBtn.getWidth()/2,Gdx.graphics.getHeight()/3*2-playBtn.getHeight()/2);

        sb.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        playBtn.dispose();
    }
}

package com.seasons.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.seasons.game.ButtonManager.*;
import com.seasons.game.ButtonManager.ButtonManager;
import com.seasons.game.ButtonManager.GameButton;
import com.seasons.game.SeasonsClass;

/**
 * Created by chester on 22.09.16.
 */

public class MenuState extends State {

    ButtonManager bm;
    Texture background;
    Texture playBtn;
    Texture exitBtn;

    public MenuState(GameStateManager gsm) {
        super(gsm);
        bm=new ButtonManager();
        background=new Texture("fon.png");
        playBtn=new Texture("igrat.png");
        exitBtn=new Texture("vykhod.png");

        bm.addButton(new GameButton(playBtn, ButtonActions.Action.START,new Vector3(SeasonsClass.WIDTH/2-100,SeasonsClass.HEIGHT/2+120,0),200,90,0,1,1,0));
        bm.addButton(new GameButton(exitBtn, ButtonActions.Action.EXIT,new Vector3(SeasonsClass.WIDTH/2-100,SeasonsClass.HEIGHT/2-90,0),200,90,0,1,1,0));
    }

    @Override
    public void handleInput() {
        if(Gdx.input.justTouched()){
            if(bm.screenClick(Gdx.input.getX(),SeasonsClass.HEIGHT-Gdx.input.getY())==ButtonActions.Action.START) gsm.set(new PlayState(gsm));
            if(bm.screenClick(Gdx.input.getX(),SeasonsClass.HEIGHT-Gdx.input.getY())==ButtonActions.Action.EXIT) Gdx.app.exit();

        }


    }

    @Override
    public void update(float dt) {
        handleInput();
        bm.update(dt);

    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();

        sb.draw(background,0,0, Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        bm.draw(sb);
        sb.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        playBtn.dispose();

    }
}

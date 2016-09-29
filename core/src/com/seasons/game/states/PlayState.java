package com.seasons.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.List;
import com.seasons.game.GameTime;
import com.seasons.game.SeasonsClass;


import java.util.ArrayList;

/**
 * Created by chester on 25.09.16.
 */

public class PlayState extends State {
    Texture background;
    BitmapFont font;
    GameTime gt;

    public PlayState(GameStateManager gsm) {
        super(gsm);
        background=new Texture("leto_den_pattern_tsv.png");
        font=new BitmapFont();
        font.getData().setScale(2.f,2.f);
        gt=new GameTime();
        camera.setToOrtho(false,SeasonsClass.WIDTH/2,SeasonsClass.HEIGHT/2);

    }

    @Override
    public void handleInput() {
        if(Gdx.input.justTouched()){

        }
    }


    @Override
    public void update(float dt) {
        camera.position.x+=2;
        handleInput();
        gt.update(dt);
        camera.update();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(camera.combined);
        sb.begin();
        sb.draw(background,0,0, camera.viewportWidth,camera.viewportHeight);
        font.draw(sb,gt.getTime(),40,40);
        font.setColor(Color.BLUE);
        font.draw(sb,"camera position "+camera.position.x+" "+camera.position.y,40,100);
        sb.end();
        //sb.draw(cat, Gdx.graphics.getWidth()/2-cat.getWidth()*4/2, Gdx.graphics.getHeight()/2-cat.getHeight()*4/2,cat.getWidth()*4,cat.getHeight()*4);

    }

    @Override
    public void dispose() {

    }
}

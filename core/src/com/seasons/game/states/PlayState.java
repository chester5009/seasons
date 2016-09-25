package com.seasons.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.List;
import com.seasons.game.sprites.Cat;

import java.util.ArrayList;

/**
 * Created by chester on 25.09.16.
 */

public class PlayState extends State {
    ArrayList<Cat> cats;
    Cat cat;
    BitmapFont font;
    public PlayState(GameStateManager gsm) {
        super(gsm);
        cats=new ArrayList<Cat>();
        camera.setToOrtho(false,Gdx.graphics.getWidth()/2,Gdx.graphics.getHeight()/2);
        cat=new Cat(0,0);
        font=new BitmapFont();
    }

    @Override
    public void handleInput() {
        if(Gdx.input.justTouched()){
            Cat newCat=new Cat(Gdx.graphics.getWidth()/4-50,Gdx.graphics.getHeight()/4-50);
            cats.add(newCat);
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
        for (int i=0;i<cats.size();i++){
            cats.get(i).update(dt);
        }
        cat.update(dt);
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(camera.combined);

        for (int i=0;i<cats.size();i++){
            sb.begin();
            sb.draw(cats.get(i).getText(),cats.get(i).getPosition().x,cats.get(i).getPosition().y);
            sb.end();
        }
        sb.begin();
        sb.draw(cat.getText(),cat.getPosition().x,cat.getPosition().y);
        font.draw(sb,"Cats: "+cats.size()+ " FPS: "+Gdx.graphics.getFramesPerSecond(),15,15);
        sb.end();

        //sb.draw(cat, Gdx.graphics.getWidth()/2-cat.getWidth()*4/2, Gdx.graphics.getHeight()/2-cat.getHeight()*4/2,cat.getWidth()*4,cat.getHeight()*4);

    }

    @Override
    public void dispose() {

    }
}

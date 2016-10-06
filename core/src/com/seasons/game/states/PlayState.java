package com.seasons.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.ui.List;
import com.seasons.game.ButtonManager.ButtonActions;
import com.seasons.game.ButtonManager.ButtonManager;
import com.seasons.game.ButtonManager.GameButton;
import com.seasons.game.ButtonManager.MyInputProcessor;
import com.seasons.game.GameTime;
import com.seasons.game.SeasonsClass;
import com.seasons.game.backgroundManager.BackgroundManager;
import com.seasons.game.units.Player;


import java.util.ArrayList;

/**
 * Created by chester on 25.09.16.
 */

public class PlayState extends State {
    Texture background;
    BitmapFont font;
    GameTime gt;
    Player player;
    Texture arrowBtn;
    ButtonManager bm;
    BackgroundManager bgm;


    public PlayState(GameStateManager gsm) {
        super(gsm);
        bm=new ButtonManager();

        background=new Texture("leto_den_pattern_tsv.png");
        arrowBtn=new Texture("arrow.png");
        font=new BitmapFont();
        player=new Player(new Texture("hero.png"),new Vector3(50,150,0));

        gt=new GameTime();
        camera.setToOrtho(false,SeasonsClass.WIDTH/2,SeasonsClass.HEIGHT/2);
        staticCamera.setToOrtho(false,SeasonsClass.WIDTH/2,SeasonsClass.HEIGHT/2);

        bgm=new BackgroundManager(background,camera);

        bm.addButton(new GameButton(arrowBtn, ButtonActions.Action.MOVE_LEFT,new Vector3(staticCamera.position.x-staticCamera.viewportWidth/2,staticCamera.position.y/2,0),70,30,0,1,1,0));
        bm.addButton(new GameButton(arrowBtn, ButtonActions.Action.MOVE_RIGHT,new Vector3(staticCamera.position.x-staticCamera.viewportWidth/2+100,staticCamera.position.y/2,0),70,30,1,0,0,1));
    }

    @Override
    public void handleInput() {
        if(Gdx.input.isTouched()){
            if(bm.screenClick(Gdx.input.getX()/2,SeasonsClass.HEIGHT/2-Gdx.input.getY()/2)==ButtonActions.Action.MOVE_LEFT)player.setDirection(1);
            if(bm.screenClick(Gdx.input.getX()/2,SeasonsClass.HEIGHT/2-Gdx.input.getY()/2)==ButtonActions.Action.MOVE_RIGHT)player.setDirection(2);
        }
        if(!Gdx.input.isTouched()){
            player.setDirection(0);

        }


    }


    @Override
    public void update(float dt) {
        handleInput();
        gt.update(dt);
        bm.update(dt);
        player.update(dt);
        bgm.update(player.getPosition().x);
        camera.position.x=player.getPosition().x;
        camera.position.y=SeasonsClass.HEIGHT/4;

        camera.update();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(camera.combined);
        sb.begin();
        bgm.draw(sb,camera);
        //sb.draw(background,0,0, camera.viewportWidth,camera.viewportHeight);
        player.draw(sb);
        sb.end();

        sb.setProjectionMatrix(staticCamera.combined);
        sb.begin();
        bm.draw(sb);
        font.getData().setScale(1.2f,1.2f);
        font.setColor(Color.RED);
        font.draw(sb,gt.getTime()+" "+player.getPosition().x+bgm.getData(),40,40);
        sb.end();

        //sb.draw(cat, Gdx.graphics.getWidth()/2-cat.getWidth()*4/2, Gdx.graphics.getHeight()/2-cat.getHeight()*4/2,cat.getWidth()*4,cat.getHeight()*4);

    }

    @Override
    public void dispose() {

    }
}

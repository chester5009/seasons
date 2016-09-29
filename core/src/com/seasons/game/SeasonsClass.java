package com.seasons.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.seasons.game.states.GameStateManager;
import com.seasons.game.states.MenuState;

public class SeasonsClass extends ApplicationAdapter {
	public static int WIDTH;
	public static int HEIGHT;
	SpriteBatch batch;
	GameStateManager gsm;
	@Override
	public void create () {
		WIDTH=Gdx.graphics.getWidth();
		HEIGHT=Gdx.graphics.getHeight();
		batch = new SpriteBatch();
		gsm=new GameStateManager();
		gsm.push(new MenuState(gsm));
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		gsm.update(Gdx.graphics.getDeltaTime());
		gsm.render(batch);
	}
	
	@Override
	public void dispose () {
		batch.dispose();

	}
}

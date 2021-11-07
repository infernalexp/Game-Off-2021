package org.infernalstudios.gameoff;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameOff extends Game {
    public SpriteBatch batch;
	public BitmapFont font;

    public int width;
    public int height;

    public GameOff(int width, int height) {
        this.width = width;
        this.height = height;
    }
    
    @Override
    public void create() {
        batch = new SpriteBatch();
        font = new BitmapFont();

		this.setScreen(new MainMenuScreen(this));
    }

    @Override
    public void render() {
        super.render();
    }
    
    @Override
    public void dispose() {
        batch.dispose();
        font.dispose();
    }
}

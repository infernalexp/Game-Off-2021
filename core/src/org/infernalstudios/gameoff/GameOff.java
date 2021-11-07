package org.infernalstudios.gameoff;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameOff extends Game {
    public SpriteBatch batch;
	public BitmapFont font;

    public int width;
    public int height;

    public List<Tickable> tickables = new ArrayList<Tickable>();

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

    private long lastTick = System.currentTimeMillis();

    @Override
    public void render() {
        long timeSinceLastTick = System.currentTimeMillis() - lastTick;
        lastTick = System.currentTimeMillis();
        super.render();
        this.tickables.forEach(tickable -> {
            if (tickable != null) {
                tickable.tick(timeSinceLastTick / 1000f);
            }
        });
    }
    
    @Override
    public void dispose() {
        batch.dispose();
        font.dispose();
    }
}

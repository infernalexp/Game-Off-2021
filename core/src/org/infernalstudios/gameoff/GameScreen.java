package org.infernalstudios.gameoff;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;

import org.infernalstudios.gameoff.level.Level;
import org.infernalstudios.gameoff.level.TestLevel;

public class GameScreen implements Screen {
    public OrthographicCamera camera;
    public GameOff game;
    public Level level;

    public GameScreen(final GameOff game) {
        this.game = game;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, this.game.width, this.game.height);
        this.level = new TestLevel(this);
        this.setLevel(this.level);
    }

    public void setLevel(Level level) {
        this.game.tickables.remove(this.level);
        this.level = level;
        this.game.tickables.add(this.level);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0.0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();

        if (this.level != null) {
            this.level.render();
        }

        game.batch.end();
    }

    @Override
    public void show() {
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void hide() {
    }

    @Override
    public void dispose() {
    }
}

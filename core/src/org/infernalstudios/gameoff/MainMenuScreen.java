package org.infernalstudios.gameoff;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class MainMenuScreen implements Screen {
    public OrthographicCamera camera;
    public GameOff game;

    public MainMenuScreen(final GameOff game) {
        this.game = game;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, this.game.width, this.game.height);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0.0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();

        // Draw the main menu here
        game.font.draw(game.batch, "Mecha Milly", game.width / 2, game.height - 100);

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

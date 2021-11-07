package org.infernalstudios.gameoff.level;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;

import org.infernalstudios.gameoff.GameScreen;
import org.infernalstudios.gameoff.Tickable;

public abstract class Level implements Tickable {
    public World world = new World(new Vector2(0, -9.8f * 5), true);
    private Box2DDebugRenderer debugRenderer;
    public GameScreen screen;

    public Level(GameScreen screen) {
        this.screen = screen;
        this.debugRenderer = new Box2DDebugRenderer();
    }

    public void tick(float delta) {
        this.world.step(delta, 6, 2);
    }

    public void render() {
        this.debugRenderer.render(this.world, this.screen.camera.combined);
    }
    
}

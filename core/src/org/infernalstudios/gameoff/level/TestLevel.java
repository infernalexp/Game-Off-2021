package org.infernalstudios.gameoff.level;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.EdgeShape;
import com.badlogic.gdx.physics.box2d.PolygonShape;

import org.infernalstudios.gameoff.GameScreen;

public class TestLevel extends Level {
    public TestLevel(GameScreen screen) {
        super(screen);
        // ground
        createEdge(BodyDef.BodyType.StaticBody, 0, 0, screen.game.width, 0, 0);
        // left wall
        createEdge(BodyDef.BodyType.StaticBody, 0, 0, 0, screen.game.height, 0);
        // right wall
        createEdge(BodyDef.BodyType.StaticBody, screen.game.width, 0, screen.game.width, screen.game.height, 0);

        Gdx.input.setInputProcessor(new InputAdapter() {
            @Override
            public boolean touchDown(int x, int y, int pointer, int button) {

                Vector3 touchedPoint = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
                TestLevel.this.screen.camera.unproject(touchedPoint);

                if (MathUtils.randomBoolean()) {
                    createBox(BodyDef.BodyType.DynamicBody, touchedPoint.x, touchedPoint.y, 50, 50, 1);
                } else {
                    createCircle(BodyDef.BodyType.DynamicBody, touchedPoint.x, touchedPoint.y, 50, 3);
                }

                return true;
            }
        });
    }


	private Body createBox(BodyDef.BodyType type, float x, float y, float width, float height, float density) {
        PolygonShape poly = new PolygonShape();
        poly.setAsBox(width, height);

        BodyDef def = new BodyDef();
        def.type = type;
        Body body = world.createBody(def);
        body.createFixture(poly, density);
        body.setTransform(x, y, 0);
        poly.dispose();

        return body;
    }

    private Body createEdge(BodyDef.BodyType type, float x1, float y1, float x2, float y2, float density) {
        EdgeShape poly = new EdgeShape();
        poly.set(new Vector2(0, 0), new Vector2(x2 - x1, y2 - y1));

        BodyDef def = new BodyDef();
        def.type = type;
        Body body = world.createBody(def);
        body.createFixture(poly, density);
        body.setTransform(x1, y1, 0);
        poly.dispose();

        return body;
    }

    private Body createCircle(BodyDef.BodyType type, float x, float y, float radius, float density) {
        CircleShape poly = new CircleShape();
        poly.setRadius(radius);

        BodyDef def = new BodyDef();
        def.type = type;
        Body body = world.createBody(def);
        body.createFixture(poly, density);
        body.setTransform(x, y, 0);
        poly.dispose();

        return body;
    }
}

package org.infernalstudios.gameoff.client;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.gwt.GwtApplication;
import com.badlogic.gdx.backends.gwt.GwtApplicationConfiguration;
import org.infernalstudios.gameoff.GameOff;

public class HtmlLauncher extends GwtApplication {
    @Override
    public GwtApplicationConfiguration getConfig () {
        GwtApplicationConfiguration config = new GwtApplicationConfiguration(640, 640);

        config.antialiasing = false;

        return config;
    }

    @Override
    public ApplicationListener createApplicationListener () {
        return new GameOff();
    }
}
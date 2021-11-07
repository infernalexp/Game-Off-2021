package org.infernalstudios.gameoff.desktop;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import org.infernalstudios.gameoff.GameOff;

public class DesktopLauncher {
    public static void main(String[] arg) {
        int width = 640;
        int height = 640;

        Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
        config.setWindowedMode(width, height);
        config.setResizable(false);
        GameOff game = new GameOff(width, height);
        new Lwjgl3Application(game, config);
    }
}

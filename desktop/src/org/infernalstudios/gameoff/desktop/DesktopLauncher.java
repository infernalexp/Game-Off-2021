package org.infernalstudios.gameoff.desktop;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import org.infernalstudios.gameoff.GameOff;

public class DesktopLauncher {
    public static void main (String[] arg) {
        Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
        config.setWindowedMode(640, 640);
        config.setResizable(false);
        new Lwjgl3Application(new GameOff(), config);
    }
}

package com.artsuo.hallsofosiris.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.artsuo.hallsofosiris.Hoo;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Halls of Osiris";
		//config.fullscreen = true;
		config.width = 1280;
		config.height = 800;
		new LwjglApplication(new Hoo(), config);
	}
}

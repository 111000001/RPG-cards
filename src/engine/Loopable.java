package engine;

import java.awt.Graphics;

public interface Loopable {

	public abstract void tick();
	public abstract void render(Graphics g);
}

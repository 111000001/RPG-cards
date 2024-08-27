package game.entidades.personage;

import java.awt.Color;
import java.awt.Graphics;

import game.entidades.Entity;

public class Personage extends Entity{

	public Personage(double x, double y, int width, int height) {
		super(x, y, width, height);
	}

	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
		
		g.setColor(Color.white);
		g.fillRect(getX(), getY(), getWidth(), getHeight());
	}

}

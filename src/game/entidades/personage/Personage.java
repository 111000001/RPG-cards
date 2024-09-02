package game.entidades.personage;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import engine.gfx.Sprites;
import game.Game;
import game.entidades.Entity;

public class Personage extends Entity{
	
	protected BufferedImage spriteDir[] = new BufferedImage[2];
	public int dir;
	
	public Personage(double x, double y, int width, int height, int dir) {
		super(x, y, width, height);
		this.dir = dir;
		
		Game.sprite = new Sprites("/SpriteSheet.png");
		Game.entidades.add(this);
	}

	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
		
		if(dir == 1) {
			
		g.drawImage(spriteDir[0],getX(),getY(),getWidth(),getHeight(),null);
		}else if(dir == -1) {
			
		g.drawImage(spriteDir[1],getX(),getY(),getWidth(),getHeight(),null);
		}
	}

}

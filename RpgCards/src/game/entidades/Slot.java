package game.entidades;

import java.awt.Color;
import java.awt.Graphics;

import game.Game;
import game.entidades.personage.Personage;

public class Slot extends Entity{

	private boolean isColldingMouse;
	public Color color = Color.white; 
	
	public Slot(double x, double y, int width, int height) {
		super(x, y, width, height);
	}

	@Override
	public void tick() {
		
		if(isColldingMouse) {
			
			for(int i = 0;i < Game.cards.size();i++) {
				
				if(Game.cards.get(i).isSelect() && Game.gc.input.isButtonDown(1)) {
					
					Game.entidades.remove(Game.cards.get(i));
					Game.cards.remove(i);
					
					Game.personages.add(new Personage(getX() + 50 / 2,getY() + 13,50,75));
				}
				
			}
			
		}
	}

	@Override
	public void render(Graphics g) {
		
		g.setColor(color);
		g.drawRect(getX(),getY(),getWidth(),getHeight());
	}

	public void isMouseColliding() {
		
		if(isColidding(Game.gc.input.getMouseX(),Game.gc.input.getMouseY(),1,1,this)) {
			isColldingMouse = true;
			color = Color.red;
		}else {
			isColldingMouse = false;
			color = Color.white;
		}
	}
}

package game.entidades.card;

import java.awt.Color;
import java.awt.Graphics;

import game.Game;
import game.entidades.Entity;

public class Card extends Entity{

	private boolean isCollidingMouse;
	private boolean isSelect;
	
	public Card(double x, double y, int width, int height) {
		super(x, y, width, height);
	}

	@Override
	public void tick() {
		
		isCollidingMouse();
		
		
	}

	@Override
	public void render(Graphics g) {
		
		if(!isSelect) {
		g.setColor(Color.blue);
		g.drawRect(getX(), getY(), getWidth(), getHeight());
		}else {
		g.setColor(Color.cyan);
		g.drawRect(getX(), getY(), getWidth(), getHeight());	
		}
	}

	private void isCollidingMouse() {
		
		if(isColidding(Game.gc.input.getMouseX(),Game.gc.input.getMouseY(),1,15,this)) {
			
			if(isSelect == false && !isCollidingMouse) {
				y-=30;
			}
			
			isSelectedCard();
			
			isCollidingMouse = true;
		}else {
			
			if(isSelect == false && isCollidingMouse) {
				y+=30;
			}
			
			isCollidingMouse = false;
		}
	}
	
	private void isSelectedCard() {
		
        if (Game.gc.input.isButtonDown(1) && !isSelect) {
        	
        	for(int i = 0;i < Game.cards.size();i++) {
        		
        		if(Game.cards.get(i).isSelect) {
        			
        			Game.cards.get(i).isSelect = false;
        			Game.cards.get(i).y+=30;
        		}
        	}
        	
        	if(!isSelect) {
            isSelect = true;
        	}else {
        	isSelect = false;	
        	}
        	
        }
	}

	
	public boolean isSelect() {
		return isSelect;
	}

	public void setSelect(boolean isSelect) {
		this.isSelect = isSelect;
	}
	
	
	
}

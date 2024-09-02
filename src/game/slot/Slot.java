package game.slot;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;

import game.Game;
import game.entidades.Entity;
import game.entidades.card.Card;

public abstract class Slot extends Entity {

    private boolean isColldingMouse;
    private Color color = Color.darkGray; 
    protected boolean isFull;
    private boolean isCliked;
    
    public Slot(double x, double y, int width, int height) {
        super(x, y, width, height);
        Game.entidades.add(this);
    }

    @Override
    public void tick() {
    	
        isMouseColliding();
        
        if(isColldingMouse) {
        	
            for (int i = 0; i < getDeck().size(); i++) {
                if (!isFull && getDeck().get(i).isSelect() && Game.gc.input.isButtonDown(1)) {
                    createPersonage(i);
                    isFull = true;
                }
            }
        }
        
        if(!Card.SELECTED && isFull && Game.gc.input.isButtonDown(1)) {
        	isCliked = true;
        }else {
        	isCliked = false;
        }
        
    }

    @Override
    public void render(Graphics g) {
    	
        g.setColor(color);
        g.drawOval(getX(), getY() + 75, getWidth(), getHeight() / 4);
    }

    protected abstract List<Card> getDeck();

    public abstract void createPersonage(int i);

    public void isMouseColliding() {
        if (isColidding(Game.gc.input.getMouseX(), Game.gc.input.getMouseY(), 1, 1, this)) {
            isColldingMouse = true;
            color = Color.lightGray;
        } else {
            isColldingMouse = false;
            color = Color.darkGray;
        }
    }

	public boolean isCliked() {
		return isCliked;
	}
}

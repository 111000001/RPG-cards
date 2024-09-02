package game.entidades.card;

import java.awt.Color;
import java.awt.Graphics;

import engine.gfx.Sprites;
import game.Game;
import game.entidades.Entity;
import game.entidades.Player;

public class Card extends Entity{

	private boolean isCollidingMouse;
	private boolean isSelect;
	public static boolean SELECTED;
	
	public Card(int width, int height) {
		super(width, height);
		
		Game.sprite = new Sprites("/CardsPersonage.png");
		Game.cheaps.add(this);
	}

	@Override
	public void tick() {
		
		if(!player.showMenuAttack) {
		isCollidingMouseAlgorotmo();
		}
		
	    for (Card card : Player.deck) {
	        if (card.isSelect) {
	            SELECTED = true;
	            break;
	        }
	    }
	    
	}

	@Override
	public void render(Graphics g) {
		
		g.drawImage(sprite,getX(), getY(), getWidth(), getHeight(),null);
		
		isSelectCard(g);
	}
	
	
	public void configureDimensions(int x,int y) {
		
		setX(x);
		setY(y);
	}
	
	protected void isSelectCard(Graphics g) {
		
		if(!isSelect) {
		g.setColor(Color.darkGray);
		g.drawRect(getX(), getY(), getWidth(), getHeight());
		}else {
		g.setColor(Color.lightGray);
		g.drawRect(getX(), getY(), getWidth(), getHeight());	
		}
	}
	
	private void isCollidingMouseAlgorotmo() {
		
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
        	
        	for(int i = 0;i < Player.deck.size();i++) {
        		
        		if(Player.deck.get(i).isSelect) {
        			
        			Player.deck.get(i).isSelect = false;
        			Player.deck.get(i).y+=30;
        		}
        	}
        	
        	if(!isSelect) {
            isSelect = true;
        	}else {
        	isSelect = false;	
        	}
        	
        }else if(Game.gc.input.isButtonDown(1) && isSelect) {
        	
        	isSelect = false;
        }
	}

	public boolean isSelect() {
		return isSelect;
	}
	
	public boolean isCollidingMouse() {
		return isCollidingMouse;
	}

	public void setCollidingMouse(boolean isCollidingMouse) {
		this.isCollidingMouse = isCollidingMouse;
	}

	public void setSelect(boolean isSelect) {
		this.isSelect = isSelect;
	}
}

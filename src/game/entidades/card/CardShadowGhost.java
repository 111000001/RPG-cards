package game.entidades.card;

import java.awt.Color;
import java.awt.Graphics;

import engine.gfx.Sprites;
import game.Game;

public class CardShadowGhost extends Card{

	public CardShadowGhost(int width, int height) {
		super(width, height);
		
		Game.sprite = new Sprites("/SpriteSheet.png");
		sprite = Game.sprite.getSprite(59,112,46,74);
	}
	
	public void render(Graphics g) {
		
		int width = 46*2 + 46/3;
		int height = 74*2 + 74/3;
		
		isSelectCard(g);
		
		g.setColor(Color.black);
		g.fillRect(getX()+1, getY() + 1, getWidth() - 1,getHeight() - 1);
		g.drawImage(sprite, getX() + 25, getY() + 30, width, height, null);
	}
}

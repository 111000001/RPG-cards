package game.entidades.card;

import game.Game;

public class CardKight extends Card{

	public CardKight(int width, int height) {
		super(width, height);
		
		sprite = Game.sprite.getSprite(0,0,150,230);
	}
	
}

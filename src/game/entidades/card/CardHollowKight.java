package game.entidades.card;

import game.Game;

public class CardHollowKight extends Card{

	public CardHollowKight(int width, int height) {
		super(width, height);
		
		sprite = Game.sprite.getSprite(302,0,150,230);
	}

}

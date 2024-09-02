package game.entidades.card;

import game.Game;

public class CardAssassin extends Card{

	public CardAssassin(int width, int height) {
		super(width, height);
		
		sprite = Game.sprite.getSprite(151,0,150, 230);
	}
}

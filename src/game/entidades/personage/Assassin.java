package game.entidades.personage;

import game.Game;

public class Assassin extends Personage{

	public Assassin(double x, double y, int width, int height,int dir) {
		super(x, y, width, height,dir);
		
		spriteDir[0] = Game.sprite.getSprite(0,101,58,99);
		spriteDir[1] = Game.sprite.getSprite(742,101,58,99);
	}
}

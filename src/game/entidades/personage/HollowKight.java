package game.entidades.personage;

import game.Game;

public class HollowKight extends Personage{

	public HollowKight(double x, double y, int width, int height,int dir) {
		super(x, y, width, height,dir);
		
		spriteDir[0] = Game.sprite.getSprite(0,201,58,93);
		spriteDir[1] = Game.sprite.getSprite(742,201,58,93);
	}
}

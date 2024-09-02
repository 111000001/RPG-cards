package game.entidades.personage;

import game.Game;

public class ShadowGhost extends Personage{

	public ShadowGhost(double x, double y, int width, int height, int dir) {
		super(x, y, width, height, dir);
		
		
		spriteDir[0] = Game.sprite.getSprite(59,112,46,74);
		spriteDir[1] = Game.sprite.getSprite(695,112,46,74);
	}
}

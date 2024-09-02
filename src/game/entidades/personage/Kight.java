package game.entidades.personage;

import game.Game;

public class Kight extends Personage{
	
	public Kight(double x, double y, int width, int height,int dir) {
		super(x, y, width, height,dir);
		
		spriteDir[0] = Game.sprite.getSprite(59,0,90,111);
		spriteDir[1] = Game.sprite.getSprite(651,0,90,111);
	}
}

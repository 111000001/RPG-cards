package game.algoritmo;

import java.awt.Rectangle;
import game.gfx.Dimensioned;

public interface Collidable {

	public default boolean isColidding(Dimensioned e1,Dimensioned e2){
		
		Rectangle e1Mask = new Rectangle(e1.getX(),e1.getY(),e1.getWidth(),e1.getHeight());
		Rectangle e2Mask = new Rectangle(e2.getX(),e2.getY(),e2.getWidth(),e2.getHeight());
		
		return e1Mask.intersects(e2Mask);
	}
	
	public default boolean isColidding(int setX,int setY,int setWidth,int setHeight,Dimensioned e2){
		
		Rectangle e1Mask = new Rectangle(setX,setY,setWidth,setHeight);
		Rectangle e2Mask = new Rectangle(e2.getX(),e2.getY(),e2.getWidth(),e2.getHeight());
		
		return e1Mask.intersects(e2Mask);
	}
}

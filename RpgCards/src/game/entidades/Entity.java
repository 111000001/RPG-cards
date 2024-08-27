package game.entidades;

import java.awt.image.BufferedImage;
import java.util.Random;

import engine.Loopable;
import game.Game;
import game.algoritmo.Collidable;
import game.algoritmo.DistanceCalculable;
import game.gfx.Animation;
import game.gfx.Dimensioned;
import game.gfx.Deepable;

public abstract class Entity implements Deepable,Dimensioned,Collidable,DistanceCalculable,Loopable {
	
	protected double x;
	protected double y;
	protected int width;
	protected int height;
	protected double spd;
	protected boolean moved;
	
	public int depth;
	protected BufferedImage sprite;
	
	public int lifeMax = 10;
	public int life = lifeMax;
	
	public static Random rand = new Random();
	protected Animation animation;
	
	public Entity(double x,double y,int width,int height){
		
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		Game.entidades.add(this);
	}
	
	public Entity(double x,double y,int width,int height,double speed){
		
		this.x = x;
		this.y = y;
		this.spd = speed;
		this.width = width;
		this.height = height;
		Game.entidades.add(this);
	}
	
	public Entity(double x,double y,int width,int height,BufferedImage sprite){
		
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.sprite = sprite;
		Game.entidades.add(this);
	}
	
	@Override
	public int getDepth() {
		return depth;
	}
	
	@Override
	public int getX() {
		return (int)this.x;
	}
	
	@Override
	public int getY() {
		return (int)this.y;
	}
	
	@Override
	public void setX(int x) {
		this.x = x;
	}
	
	@Override
	public void setY(int y) {
		this.y = y;
	}
	
	@Override
	public int getWidth() {
		return this.width;
	}
	
	@Override
	public int getHeight() {
		return this.height;
	}
	
	public int getSpd() {
		return (int)spd;
	}
}

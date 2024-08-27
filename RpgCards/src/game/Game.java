package game;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import engine.GameContainer;
import engine.gfx.Sprites;
import engine.gfx.Window;
import game.entidades.Entity;
import game.entidades.Slot;
import game.entidades.card.Card;
import game.entidades.personage.Personage;

public class Game {
	
	public static Sprites sprite;
	public static GameContainer gc;
	
	public static List<Entity> entidades = new ArrayList<Entity>();
	
	public static List<Card> cards = new ArrayList<Card>();
	
	public static List<Personage> personages = new ArrayList<Personage>();
	public static List<Personage> enemys = new ArrayList<Personage>();
	
	public static List<Slot> slotsCharacters = new ArrayList<Slot>();
	public static List<Slot> slotsEnemys = new ArrayList<Slot>();
	
	public static void main (String args[]) {
		
		Game game = new Game();
		sprite = new Sprites("/SpriteSheet.png");
		
		///////////////////////////////////////
		//Inicializando objetos:
		
		game.initializationSlots();
		
		cards.add(new Card((Window.WIDTH / 2) - 150 - 200,(Window.HEIGHT / 2) - 230 / 2 + 400, 150, 230));
		cards.add(new Card((Window.WIDTH / 2) - 150,(Window.HEIGHT / 2) - 230 / 2 + 400, 150, 230));
		cards.add(new Card((Window.WIDTH / 2) - 150 + 200,(Window.HEIGHT / 2) - 230 / 2 + 400, 150, 230));
		
		///////////////////////////////////////
		gc = new GameContainer();
		gc.start();
	}
	
	public void tick() {
		
		for(int i = 0;i < entidades.size();i++) {
			entidades.get(i).tick();
		}
		
		for(int i = 0;i < slotsCharacters.size();i++) {
			
			slotsCharacters.get(i).isMouseColliding();
		}
	}

	public void render(Graphics g) {
		
		Collections.sort(Game.entidades,Entity.nodeSorter);

		for(int i = 0;i < entidades.size();i++) {
			entidades.get(i).render(g);
		}
	}
	
	private void initializationSlots() {
		
		int width = 100;
		int height = 100;
		
		int x = (Window.WIDTH / 2) - (width / 2);
		int y = (Window.HEIGHT / 2) - (height / 2) - 50;
		
		Slot slots [] = new Slot[6];
		
		//Allys
		
		//parte da frente
		slots[1] = new Slot(x - x / 4, y - (height + height / 2), width, height);
		slots[3] = new Slot(x - x / 4, y, width, height);
		slots[5] = new Slot(x - x / 4, y + (height + height / 2), width, height);
		//parte de trás
		slots[2] = new Slot(x - x / 4 - (width + width / 2), y, width, height);
		slots[0] = new Slot(x - x / 4 - (width + width / 2), y - (height + height / 2), width, height);
		slots[4] = new Slot(x - x / 4 - (width + width / 2), y + (height + height / 2), width, height);
		
		for(int i = 0;i < slots.length;i++) {
			
			slotsCharacters.add(slots[i]);
		}
		
		slots = new Slot[6];
		
		//Enemys
		//parte da frente
		slots[1] = new Slot(x + x / 4, y - (height + height / 2), width, height);
		slots[3] = new Slot(x + x / 4, y, width, height);
		slots[5] = new Slot(x + x / 4, y + (height + height / 2), width, height);
		//parte de trás
		slots[2] = new Slot(x + x / 4 - (width + width / 2), y, width, height);
		slots[0] = new Slot(x + x / 4 - (width + width / 2), y - (height + height / 2), width, height);
		slots[4] = new Slot(x + x / 4 - (width + width / 2), y + (height + height / 2), width, height);
		
		for(int i = 0;i < slots.length;i++) {
			
			slotsEnemys.add(slots[i]);
		}
	}
}

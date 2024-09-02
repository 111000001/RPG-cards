package game;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import engine.GameContainer;
import engine.gfx.Sprites;
import engine.gfx.Window;
import game.entidades.Entity;
import game.entidades.Opponent;
import game.entidades.Player;
import game.entidades.card.Card;
import game.entidades.card.CardAssassin;
import game.entidades.card.CardHollowKight;
import game.entidades.card.CardKight;
import game.entidades.card.CardShadowGhost;
import game.entidades.card.Cheap;
import game.slot.EnemySlot;
import game.slot.PlayerSlot;

public class Game {
	
	public static Sprites sprite;
	public static GameContainer gc;
	private static Cheap cheap;
	
	public static Player player;
	public static Opponent opponent;
	
	public static List<Entity> entidades = new ArrayList<Entity>();
	public static List<Card> cheaps = new ArrayList<Card>();
	
	public static void main (String args[]) {
		
		Game game = new Game();
		sprite = new Sprites("/SpriteSheet.png");
		
		///////////////////////////////////////
		//Inicializando objetos:
		player = new Player();
		opponent = new Opponent();
		
		cheap = new Cheap();
		
		new CardAssassin(150, 230);
		
		new CardKight(150, 230);
		
		new CardHollowKight(150, 230);
		
		new CardShadowGhost(150, 230);
		
		//cheap.distributeEqually(4);
		cheap.distribute(Player.deck,4);
		game.initializationSlots();
		
		//opponent.startCard();
		///////////////////////////////////////
		gc = new GameContainer();
		gc.start();
	}
	
	public void tick() {
		
		setPositionCards();
		
		Card.SELECTED = false;
		
		for(int i = 0;i < entidades.size();i++) {
			entidades.get(i).tick();
		}
		
		player.isAttackMode();
	}

	public void render(Graphics g) {

		player.graphics = g;
		
		for(int i = 0;i < entidades.size();i++) {
			entidades.get(i).render(g);
		}
		
		player.showDialogModeAttack(g);
	}
	
	private void setPositionCards() {
		
		int[][] offsets = { {0, 0}, {-100, 100}, {-200, 0, 200}, {-100, 100, -300, 300} };
		
		for (int i = 0; i < Player.deck.size(); i++) {
			
		    if (Player.deck.get(i).isCollidingMouse() == false && Player.deck.get(i).isSelect() == false) {
		    	Player.deck.get(i).configureDimensions(
		            (Window.WIDTH / 2) - 150 + offsets[Player.deck.size() - 1][i], 
		            (Window.HEIGHT / 2) - 230 / 2 + 400
		        );
		    }
		}
	}
	
	private void initializationSlots() {
		
	    int width = 100;
	    int height = 100;
	    
	    int x = (Window.WIDTH / 2) - (width / 2);
	    int y = (Window.HEIGHT / 2) - (height / 2) - 50;
	    
	    // Criação dos slots para o jogador (PlayerSlot)
	    PlayerSlot[] playerSlots = new PlayerSlot[6];
	    
	    // Parte da frente
	    playerSlots[1] = new PlayerSlot(x - x / 4, y - (height + height / 2), width, height);
	    playerSlots[3] = new PlayerSlot(x - x / 4, y, width, height);
	    playerSlots[5] = new PlayerSlot(x - x / 4, y + (height + height / 2), width, height);
	    // Parte de trás
	    playerSlots[2] = new PlayerSlot(x - x / 4 - (width + width / 2), y, width, height);
	    playerSlots[0] = new PlayerSlot(x - x / 4 - (width + width / 2), y - (height + height / 2), width, height);
	    playerSlots[4] = new PlayerSlot(x - x / 4 - (width + width / 2), y + (height + height / 2), width, height);
	    
	    for (int i = 0; i < playerSlots.length; i++) {
	    	Player.slots.add(playerSlots[i]);
	    }
	    
	    // Criação dos slots para o inimigo (EnemySlot)
	    EnemySlot[] enemySlots = new EnemySlot[6];
	    
	    // Parte da frente
	    enemySlots[1] = new EnemySlot(x + x / 4, y - (height + height / 2), width, height);
	    enemySlots[3] = new EnemySlot(x + x / 4, y, width, height);
	    enemySlots[5] = new EnemySlot(x + x / 4, y + (height + height / 2), width, height);
	    // Parte de trás
	    enemySlots[2] = new EnemySlot(x + x / 4 - (width + width / 2), y, width, height);
	    enemySlots[0] = new EnemySlot(x + x / 4 - (width + width / 2), y - (height + height / 2), width, height);
	    enemySlots[4] = new EnemySlot(x + x / 4 - (width + width / 2), y + (height + height / 2), width, height);
	    
	    for (int i = 0; i < enemySlots.length; i++) {
	        Opponent.slots.add(enemySlots[i]);
	    }
	}

}

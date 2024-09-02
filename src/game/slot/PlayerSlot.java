package game.slot;

import java.util.List;

import game.Game;
import game.entidades.Player;
import game.entidades.card.Card;
import game.entidades.card.CardAssassin;
import game.entidades.card.CardHollowKight;
import game.entidades.card.CardKight;
import game.entidades.card.CardShadowGhost;
import game.entidades.personage.Assassin;
import game.entidades.personage.HollowKight;
import game.entidades.personage.Kight;
import game.entidades.personage.Personage;
import game.entidades.personage.ShadowGhost;

public class PlayerSlot extends Slot {
	
	private Personage personage;
	
    public PlayerSlot(double x, double y, int width, int height) {
        super(x, y, width, height);
    }
    
    @Override
    protected List<Card> getDeck() {
        return Player.deck;
    }

    @Override
    public void createPersonage(int i) {
        List<Card> deck = getDeck();
        if (deck.get(i) instanceof CardKight) {
        	Player.personages.add(setPersonage(new Kight(getX() - 6, getY() - 22, 90, 111, 1)));
        } else if (deck.get(i) instanceof CardAssassin) {
        	Player.personages.add(setPersonage(new Assassin(getX() + 56 / 2, getY() - 12, 58, 100, 1)));
        } else if (deck.get(i) instanceof CardHollowKight) {
        	Player.personages.add(setPersonage(new HollowKight(getX() + 72 / 2, getY() - 6, 58, 93, 1)));
        } else if (deck.get(i) instanceof CardShadowGhost) {
        	Player.personages.add(setPersonage(new ShadowGhost(getX() + 55 / 2, getY() - 6, 58, 93, 1)));
        }
        Game.entidades.remove(deck.get(i));
        deck.remove(i);
    }

	public Personage getPersonage() {
		return personage;
	}

	public Personage setPersonage(Personage personage) {
		this.personage = personage;
		return personage;
	}
	
	public boolean isColidingMouse() {
		
		if(isColidding(Game.gc.input.getMouseX(),Game.gc.input.getMouseY(),1,1,this)) {
			return true;
		}
		return false;
	}
}

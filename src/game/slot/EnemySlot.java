package game.slot;

import java.util.List;

import game.Game;
import game.entidades.Opponent;
import game.entidades.card.Card;
import game.entidades.card.CardAssassin;
import game.entidades.card.CardHollowKight;
import game.entidades.card.CardKight;
import game.entidades.card.CardShadowGhost;
import game.entidades.personage.Assassin;
import game.entidades.personage.HollowKight;
import game.entidades.personage.Kight;
import game.entidades.personage.ShadowGhost;

public class EnemySlot extends Slot {

    public EnemySlot(double x, double y, int width, int height) {
        super(x, y, width, height);
    }
    
    @Override
    protected List<Card> getDeck() {
        return Opponent.deck;
    }

    @Override
    public void createPersonage(int i) {
    	
        List<Card> deck = getDeck();
        
        if (deck.get(i) instanceof CardKight) {
        	Opponent.personages.add(new Kight(getX() + 15, getY() - 22, 90, 111, -1));
        } else if (deck.get(i) instanceof CardAssassin) {
        	Opponent.personages.add(new Assassin(getX() + 30 / 2, getY() - 12, 58, 100, -1));
        } else if (deck.get(i) instanceof CardHollowKight) {
        	Opponent.personages.add(new HollowKight(getX() + 15 / 2, getY() - 6, 58, 93, -1));
        } else if (deck.get(i) instanceof CardShadowGhost) {
        	Opponent.personages.add(new ShadowGhost(getX() + 37 / 2, getY() - 6, 58, 93, -1));
        }
        Game.entidades.remove(deck.get(i));
        deck.remove(i);
    }
}

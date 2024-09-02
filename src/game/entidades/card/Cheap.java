package game.entidades.card;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import game.Game;
import game.entidades.Opponent;
import game.entidades.Player;

public class Cheap {
	
    private Random random = new Random();

    public void distributeEqually(int quantity) {
    	
        // Verifica se há cartas suficientes para distribuir
        int totalCards = Game.cheaps.size();
        if (totalCards < quantity) {
            System.out.println("Não há cartas suficientes para distribuir.");
            return;
        }
        // Embaralha as cartas para distribuir aleatoriamente
        Collections.shuffle(Game.cheaps, random);

        // Divide as cartas entre deckPlayer e deckOpponent
        for (int i = 0; i < quantity; i++) {
            if (i >= Game.cheaps.size()) break;

            Card card = Game.cheaps.get(i);

            if (i % 2 == 0) {
            	Player.deck.add(card);
                Game.entidades.add(card);
            } else {
                Opponent.deck.add(card);
            }
        }

        // Remove as cartas distribuídas da lista original
        Game.cheaps.subList(0, quantity).clear();
    }
    
    public void distribute(List<Card> card,int quantity) {
    	
    	if(quantity > Game.cheaps.size()) {
    		System.err.println("O tamanho fornecido está ultrapassando o limite da lista cheaps que está localizada na classe Game\n");
    		return;
    	}
    	
    	for(int i = 0;i < quantity;i++) {
    		
    		card.add(Game.cheaps.get(0));
    		
    		if(card == Player.deck) {
    		Game.entidades.add(Game.cheaps.get(0));
    		}
    		
    		Game.cheaps.remove(0);
    	}
    }
    
}

package game.entidades;

import java.util.ArrayList;
import java.util.List;

import game.entidades.card.Card;
import game.entidades.personage.Personage;
import game.slot.EnemySlot;

public class Opponent {
	
	public static List<Card> deck = new ArrayList<Card>();
	public static List<Personage> personages = new ArrayList<Personage>();
	public static List<EnemySlot> slots = new ArrayList<EnemySlot>();
	
	public void startCard() {
		
		for(int i = 0; i < 2;i++) {
		EnemySlot slot[] = new EnemySlot [2];
		slot[i] = slots.get(i);
		slot[i].createPersonage(0);
		}
	}
}

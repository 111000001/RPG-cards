package game.entidades;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import game.Game;
import game.entidades.card.Card;
import game.entidades.personage.Assassin;
import game.entidades.personage.HollowKight;
import game.entidades.personage.Kight;
import game.entidades.personage.Personage;
import game.entidades.personage.ShadowGhost;
import game.gfx.ui.Ui;
import game.slot.PlayerSlot;

public class Player {

    public Ui ui = new Ui();

    public static List<Card> deck = new ArrayList<Card>();
    public static List<Personage> personages = new ArrayList<Personage>();
    public static List<PlayerSlot> slots = new ArrayList<PlayerSlot>();

    public boolean showMenuAttack;
    private PlayerSlot slotCliked;
    public Graphics graphics;
    private String whatPersonageModeAttack = "";
    
    public void isAttackMode() {
        if (!Card.SELECTED) {
            for (PlayerSlot slot : slots) {
                if (slot.isColidingMouse() && slot.getPersonage() != null) {
                    if (Game.gc.input.isButtonDown(1)) {
                        if (slot.getPersonage() instanceof Assassin) {
                            whatPersonageModeAttack = "assassin";
                        } else if (slot.getPersonage() instanceof Kight) {
                            whatPersonageModeAttack = "kight";
                        } else if (slot.getPersonage() instanceof ShadowGhost) {
                            whatPersonageModeAttack = "shadow ghost";
                        } else if (slot.getPersonage() instanceof HollowKight) {
                            whatPersonageModeAttack = "hollow kight";
                        }

                        if (slotCliked == slot) {
                            showMenuAttack = !showMenuAttack;
                        } else {
                            showMenuAttack = true;
                            slotCliked = slot;
                        }

                        ui.finishedComponents();  // Remover os componentes anteriores ao clicar em um novo slot.
                    }
                }
            }
        }
    }

    public void showDialogModeAttack(Graphics g) {
        if (showMenuAttack) {
            ui.showDialog(g, whatPersonageModeAttack);
        } else {
            ui.finishedComponents();
            ui.isInitialized = false;
        }
    }
}

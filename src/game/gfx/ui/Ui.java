package game.gfx.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import engine.gfx.Sprites;
import engine.gfx.Window;
import game.Game;

public class Ui {
    public boolean isInitialized;
    private String personage;
    
    private Sprites sprite = new Sprites("/icones.png");
    
    private int 
    x = Window.WIDTH / 10,
    y = Window.HEIGHT / 2 + Window.HEIGHT / 4 - 10,
    width = 1918 - (x * 2),
    height = 270;

    private GButton buttonAssassin[] = new GButton[6];
    private GButton buttonKight[] = new GButton[4];
    private GButton buttonShadowGhost[] = new GButton[4];
    private GButton buttonHollowKight[] = new GButton[6];

    public void finishedComponents() {
        for (GButton button : buttonAssassin) {
            Game.entidades.remove(button);
        }

        for (GButton button : buttonKight) {
            Game.entidades.remove(button);
        }

        for (GButton button : buttonShadowGhost) {
            Game.entidades.remove(button);
        }

        for (GButton button : buttonHollowKight) {
            Game.entidades.remove(button);
        }
        isInitialized = false;  // Resetar a inicialização para garantir que componentes novos sejam inicializados.
    }

    public void showDialog(Graphics g, String whatPersonage) {
        whatPersonage = whatPersonage.toLowerCase();
        personage = whatPersonage;

        if (!isInitialized) {
            switch (whatPersonage) {
                case "assassin":
                    initializeComponentsOfAssassin();
                    break;
                case "kight":
                    initializeComponentsOfKight();
                    break;
                case "shadow ghost":
                    initializeComponentsOfShadowGhost();
                    break;
                case "hollow kight":
                    initializeComponentsOfHollowKight();
                    break;
            }
        }
        
        g.setColor(Color.black);
        g.fillRect(x, y, width, height);

        g.setColor(Color.white);
        g.drawRect(x, y, width, height);
        
        g.setFont(new Font(Font.DIALOG,2,17));
        g.drawString(personage, x + 20, y + 20);
        
        try {
        renderButtons(g);
        }catch (NullPointerException e) {}
        
    }

    private void initializeComponentsOfAssassin() {
    	
        buttonAssassin[0] = new GButton(525, 850, 300, 50,"Ataque de Adaga",sprite.getSprite(0, 45, 45, 44));
        buttonAssassin[0].setTextX(buttonAssassin[0].getTextX() - 30);
        		
        buttonAssassin[1] = new GButton(1025, 850, 300, 50,"Envenenamento",sprite.getSprite(46, 45, 45, 44));
        buttonAssassin[1].setTextX(buttonAssassin[1].getTextX() - 25);
        
        buttonAssassin[2] = new GButton(1025, 925, 300, 50,"Silenciamento",sprite.getSprite(92, 45, 45, 44));
        buttonAssassin[2].setTextX(buttonAssassin[2].getTextX() - 20);
        
        buttonAssassin[3] = new GButton(525, 925, 300, 50,"Ataque das Sombras",sprite.getSprite(138, 45, 45, 44));
        buttonAssassin[3].setTextX(buttonAssassin[3].getTextX() - 45);
        
        buttonAssassin[4] = new GButton(525, 1000, 300, 50,"Ataque Rapido",sprite.getSprite(184, 45, 45, 44));
        buttonAssassin[4].setTextX(buttonAssassin[4].getTextX() - 25);
        
        buttonAssassin[5] = new GButton(1025, 1000, 300, 50,"Ataque Mortal",sprite.getSprite(230, 45, 45, 44));
        buttonAssassin[5].setTextX(buttonAssassin[5].getTextX() - 20);
        
        isInitialized = true;
        
    }

    private void initializeComponentsOfKight() {
    	
        buttonKight[0] = new GButton(525, 850, 300, 50,"Ataque Basico",sprite.getSprite(0, 0, 45, 44));
        buttonKight[0].setTextX(buttonKight[0].getTextX() - 25);
        
        buttonKight[1] = new GButton(1025, 850, 300, 50,"Bloqueio",sprite.getSprite(46, 0, 45, 44));
        buttonKight[2] = new GButton(1025, 925, 300, 50,"Berserk",sprite.getSprite(92, 0, 45, 44));
        
        buttonKight[3] = new GButton(525, 925, 300, 50,"Ataque Consecutivo",sprite.getSprite(138, 0, 45, 44));
        buttonKight[3].setTextX(buttonKight[3].getTextX() - 40);
        isInitialized = true;
    }

    private void initializeComponentsOfShadowGhost() {
        buttonShadowGhost[0] = new GButton(550, 850, 300, 50,"Ataque de Adaga",sprite.getSprite(0, 45, 45, 44));
        isInitialized = true;
    }

    private void initializeComponentsOfHollowKight() {
        buttonHollowKight[0] = new GButton(525, 850, 300, 50,"Soco Basico",sprite.getSprite(0, 90, 45, 44));
        buttonHollowKight[0].setTextX(buttonHollowKight[0].getX() - 10);
        
        buttonHollowKight[1] = new GButton(1025, 850, 300, 50,"Transformação das sombras",sprite.getSprite(92, 90, 45, 44));
        buttonHollowKight[1].setTextX(buttonHollowKight[1].getX() - 70);
        
        buttonHollowKight[2] = new GButton(1025, 925, 300, 50,"Sono Profundo",sprite.getSprite(138, 90, 45, 44));
        buttonHollowKight[2].setTextX(buttonHollowKight[2].getX() - 15);
        
        buttonHollowKight[3] = new GButton(525, 925, 300, 50,"Ataque com a espada sombria",sprite.getSprite(46, 90, 45, 44));
        buttonHollowKight[3].setTextX(buttonHollowKight[3].getX() - 75);
        
        buttonHollowKight[4] = new GButton(525, 1000, 300, 50,"Escudo das sombras",sprite.getSprite(230, 90, 45, 44));
        buttonHollowKight[4].setTextX(buttonHollowKight[4].getX() - 45);
        
        buttonHollowKight[5] = new GButton(1025, 1000, 300, 50,"Corrupção",sprite.getSprite(184, 90, 45, 44));
        
        isInitialized = true;
    }
    
    private void renderButtons(Graphics g) {
        switch (personage) {
            case "assassin":
                for (GButton button : buttonAssassin) {
                        button.render(g);
                }
                break;
            case "kight":
                for (GButton button : buttonKight) {
                        button.render(g);               
                }
                break;
            case "shadow ghost":
                for (GButton button : buttonShadowGhost) {
                        button.render(g);
                }
                break;
            case "hollow kight":
                for (GButton button : buttonHollowKight) {
                        button.render(g);
                }
                break;
        }
    }


}

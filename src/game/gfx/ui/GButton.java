package game.gfx.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import game.Game;
import game.entidades.Entity;

public class GButton extends Entity {

    public ActionButton actionButton;
    public CollidingMouse collidingMouse;
    public CollidingMouse notCollidingMouse;

    public int clicks = 0;
    private Color colorBackgroud;
    private Color colorForeground;
    private Color colorFont;
    private boolean isCollidingMouse;
    private String text;
    private int TextX = getX();
    private int TextY = getY();
    
    public GButton(double x, double y, int width, int height,String text,BufferedImage sprite) {
        super(x, y, width, height,sprite);
        Game.entidades.add(this);
        
        // Defina o actionButton aqui, ou forneça um setter para configurá-lo
        this.actionButton = () -> {
            clicks++;
        };
        
        this.text = text;
        
        // Definindo a cor inicial
        this.colorBackgroud = Color.black;
        this.colorForeground = Color.white;
        this.colorFont = Color.white;
    }

    @Override
    public void tick() {
        if (isColidding(Game.gc.input.getMouseX(), Game.gc.input.getMouseY(), 2, 2, this)) {
            isCollidingMouse = true;

            if (Game.gc.input.isButtonDown(1)) {
                if (actionButton != null) {
                    actionButton.action();
                } else {
                    System.out.println("Warning: actionButton is null.");
                }
            }
        } else {
            isCollidingMouse = false;
        }

        addColisionMouse();
    }

    @Override
    public void render(Graphics g) {
    	
        // background
        g.setColor(colorBackgroud);
        g.fillRect(getX(), getY(), getWidth(), getHeight());

        //Borda
        g.setColor(colorForeground);
        Font font = new Font(Font.DIALOG,0,17);
        g.setFont(font);
        g.drawRect(getX(), getY(), getWidth(), getHeight());
        
        //texto do botao
        g.setColor(colorFont);
        g.drawString(text, (TextX + getWidth() / 2) - font.getSize() * 2, (TextY + getHeight() / 2) + font.getSize() / 2);
        
        g.drawImage(sprite, (getX() + getWidth() / 2) - sprite.getWidth()*4 - 18, (getY() + getHeight() / 2) - sprite.getHeight() / 2,null);
    }

    private void addColisionMouse() {
    	
        // Se Colidir
        collidingMouse = () -> {
        	colorBackgroud = Color.white;
        	colorForeground = Color.black;
        	colorFont = Color.black;
        };

        // Se não Colidir
        notCollidingMouse = () -> {
            colorBackgroud = Color.black;
            colorForeground = Color.white;
            colorFont = Color.white;
        };

        // Verificação
        if (isCollidingMouse) {
            collidingMouse.colision();
        } else {
            notCollidingMouse.colision();
        }
    }

    // Método para definir uma nova ação para o botão
    public void setActionButton(ActionButton actionButton) {
        this.actionButton = actionButton;
    }

	public int getTextX() {
		return TextX;
	}

	public void setTextX(int textX) {
		TextX = textX;
	}

	public int getTextY() {
		return TextY;
	}

	public void setTextY(int textY) {
		TextY = textY;
	}
}

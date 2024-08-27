package engine.gfx;

import java.awt.Canvas;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Window extends Canvas{
	
	private static final long serialVersionUID = 1L;

    public static int WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
    public static int HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;
	
    public static int SCALE = 1;
    
	public void initFrame(JFrame frame) {
		
		frame = new JFrame("RPG");
		frame.setSize(WIDTH,HEIGHT);
		frame.setUndecorated(true);
		frame.add(this);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}

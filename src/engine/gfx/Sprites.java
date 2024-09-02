package engine.gfx;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Sprites {

		private BufferedImage spritesheet = null;
		private int w,h;
		public int[]p;
		
		public Sprites(String path)
		{
			try {
				spritesheet = ImageIO.read(getClass().getResource(path));
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
			w = spritesheet.getWidth();
			h = spritesheet.getHeight();
			p = spritesheet.getRGB(0,0,w,h,null,0,w);
			spritesheet.flush();
		}
		
		public BufferedImage getSprite(int x,int y,int width,int height){
			return spritesheet.getSubimage(x, y, width, height);
	}
}

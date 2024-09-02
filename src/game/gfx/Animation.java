package game.gfx;

public class Animation {
	
	private int frameCur,indexCur;
	private int frameMax,indexMax;
	private int time;
	
	public Animation(int frameMax,int indexMax) {
		
		this.frameMax = frameMax;
		this.indexMax = indexMax;
	}
	
	public void runFrame(boolean run) {
		
		if(run) {
			
		frameCur++;
		
		if(frameCur >= frameMax) {
			
			frameCur = 0;
			indexCur++;
		}
		
		if(indexCur == indexMax) {
			indexCur = 0;
		}
		
		}else {
			
			time++;
			
			if(time >= 100) {
				
				frameCur = 0;
				indexCur = 0;
			}
		}
	}

	public int getIndexCur() {
		return indexCur;
	}
}

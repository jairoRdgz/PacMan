package threads;

import ui.PacManController;

public class SpriteThread extends Thread{
	
	private PacManController pc;
	private boolean sprite;
	private boolean stop;
	
	public SpriteThread(PacManController paco, boolean spri) {
		this.pc = paco;
		this.sprite = spri;
		this.stop = true;
	}
	
	public void run() {
		while(stop) {
			
			try {
				sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

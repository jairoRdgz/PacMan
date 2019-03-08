package threads;

import ui.PacManController;

public class MovingThread extends Thread{
	private PacManController pc;
	private boolean stop;
	private boolean move;
	private boolean sprite;
	
	public MovingThread(PacManController paco, boolean moving) {
		this.pc = paco;
		this.move = moving;
		this.sprite = true;
		this.stop = true;
	}
	
	public void run() {
		while(stop) {
			move = pc.right(move);
			move = pc.left(move);
			sprite = pc.openMouth(sprite);
			sprite = pc.closeMouth(sprite);
			
			try {
				sleep(60);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
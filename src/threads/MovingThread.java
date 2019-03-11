package threads;

import ui.PacManController;

public class MovingThread extends Thread{
	private PacManController pc;
	private boolean stop;
	private boolean move;
	private boolean sprite;
	private int wait;
	
	public MovingThread(PacManController paco, boolean moving, int wait) {
		this.pc = paco;
		this.move = moving;
		this.sprite = true;
		this.stop = true;
		this.wait = wait;
	}
	
	@Override
	public void run() {
		while(stop) {
			move = pc.right(move);
			move = pc.left(move);
			sprite = pc.openMouth(sprite);
			sprite = pc.closeMouth(sprite);
			
			try {
				sleep(wait);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public boolean toStop(boolean stop) {
		stop = !stop;
		return stop;
	}
	
	public int points() {
		int points = 0;
		while(move) {
			points ++;
		}
		return points;
	}
}
package threads;

import model.PacMan;
import ui.PacManController;

public class PacManThread extends Thread{
	private PacMan pacMan;
	private PacManController pmc;
	private boolean moving;
	
	public PacManThread(PacMan pac, PacManController gui) {
		pacMan = pac;
		moving = true;
		pmc = gui;
	}
	
	public void run() {
		while(moving) {
			pacMan.horizontalMove(pmc.getWidth());
			try {
				sleep(pacMan.getWait());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

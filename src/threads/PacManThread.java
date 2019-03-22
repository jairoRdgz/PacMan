package threads;

import model.PacMan;
import ui.PacManController;

public class PacManThread extends Thread{
	private PacMan pacMan;
	private PacManController pmc;
	
	public PacManThread(PacMan pac, PacManController gui) {
		pacMan = pac;
		pmc = gui;
	}
	
	public void run() {
		while(true) {
			pacMan.move(pmc.getWidth(), pmc.getHeight());
			try {
				sleep(pacMan.getWait());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}

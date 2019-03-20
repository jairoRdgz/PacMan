package threads;

import javafx.application.Platform;
import ui.PacManController;

public class PacManGUIThread extends Thread{
	private PacManController pmc;
	private final static long UPDATE_SLEEP_TIME = 5;
	
	public PacManGUIThread(PacManController paco) {
		this.pmc = paco;
	}
	
	public void run() {
		while(true) {
			UpdateRunnableGUI urg = new UpdateRunnableGUI(pmc);
			Platform.runLater(urg);
			
			try {
				sleep(UPDATE_SLEEP_TIME);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

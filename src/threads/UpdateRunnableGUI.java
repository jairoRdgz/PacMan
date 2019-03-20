package threads;

import ui.PacManController;

public class UpdateRunnableGUI implements Runnable {
	private PacManController pmc;
	
	public UpdateRunnableGUI(PacManController paco) {
		this.pmc = paco;
	}

	@Override
	public void run() {
		pmc.movePacMans();
	}
}

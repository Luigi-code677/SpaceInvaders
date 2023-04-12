package thread;

import model.Manager;
import view.MainFrame;

/**
 * 
 * @author Julian Huertas Henao, Jose Gerardo Gomez, Luis Carlos Castillo
 */
public class VerifyScore extends ThreadNotify {

	private Manager manager;
	private MainFrame view;

	public VerifyScore(int delay) {
		super(delay);
		this.manager = null;
		this.view = null;
	}

	@Override
	protected synchronized void executeTask() {

		if (manager != null) {
			if (manager.getGameSet() != null) {
				view.setScoreToScreen(Integer.toString(manager.getGameSet().getScore()));
			}
		}

	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public void setView(MainFrame view) {
		this.view = view;
	}

}

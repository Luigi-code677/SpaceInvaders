package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;

import com.google.gson.JsonSyntaxException;

import constants.CommandButton;
import constants.DefaultRoot;
import model.Manager;
import thread.VerifyScore;
import utils.MyListener;
import view.MainFrame;

/**
 *
 * @author Julian Huertas Henao, Jose Gerardo Gomez, Luis Carlos Castillo
 */
public class Controller implements ActionListener, WindowListener, KeyListener, MyListener {

	public static MainFrame view;

	public static Manager manager;
	private final VerifyScore VERIFY_SUM;
	private int count;

	public Controller() throws JsonSyntaxException, IOException {
		view = new MainFrame(this, this, this, this);
		manager = new Manager();
		VERIFY_SUM = new VerifyScore(50);
		VERIFY_SUM.start();
	}

	public static void main(String[] args) throws JsonSyntaxException, IOException {
		new Controller();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {

		case CommandButton.START_GAME_ONE_PLAYER:
			startGame();
			break;
		//
		case CommandButton.NEWGAME:
			newGame();
			break;
		case CommandButton.SETTINGS:
			view.showSettings();
			break;
		case CommandButton.SCORES:
			view.showScores();
			setScoresForMainMenu();
			break;
		case CommandButton.GO_BACK:
			view.closeSettings();
			break;
		case CommandButton.GO_BACK_MAIN_MENU:
			view.closeGame();
			break;
		case CommandButton.SOUND_APP:
			view.muteMusic();
			view.setImageIconSound(view.getIsPaused());
			break;

		case CommandButton.EXIT:
			System.exit(1);
			break;
		//
		case CommandButton.GAMEOVER_OUT:
			gameOverOut();
			break;

		default:

			break;
		}

	}

	private void gameOverOut() {
		if (view.getFinalPlayerGame().equalsIgnoreCase("")) {
			view.setShowMessageName();
		} else {

			manager.getGameSet().gameOver(view.getFinalPlayerGame());
			manager.addNewPlayerToList(manager.getGameSet());
			manager.savePlayersData(manager.getPlayersList());
			manager.finishGameSet();
			view.closeDiGameOver();
			view.startMenuMusic();
			view.closeGame();
		}
	}

	private void startGame() {
		manager.setNewGameSet();
		view.closeDiStart();
		view.showMainFrame();
		view.launchGame();
		VERIFY_SUM.setManager(manager);
		VERIFY_SUM.setView(view);
		VERIFY_SUM.resume();
	}

	private void newGame() {
		if (view.getFinalPlayerGame().equalsIgnoreCase("")) {
			view.setShowMessageName();
		} else {
			manager.getGameSet().gameOver(view.getFinalPlayerGame());
			manager.addNewPlayerToList(manager.getGameSet());
			manager.savePlayersData(manager.getPlayersList());
			view.closeDiGameOver();
			manager.setNewGameSet();
			view.showMainFrame();
			view.closePrevGame();
			view.launchGame();
			view.startMenuMusic();
			VERIFY_SUM.setManager(manager);
			VERIFY_SUM.setView(view);
			VERIFY_SUM.resume();
		}
	}

	@Override
	public void windowOpened(WindowEvent e) {

	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(1);
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		if (arg0.getExtendedKeyCode() == KeyEvent.VK_RIGHT) {
			view.moveRight();
		} else if (arg0.getExtendedKeyCode() == KeyEvent.VK_LEFT) {
			view.moveLeft();
		}

		if (arg0.getExtendedKeyCode() == KeyEvent.VK_SPACE) {
			view.setShooting(count);
			count++;
			if (count == DefaultRoot.AMOUNT_BULLETS) {
				count -= DefaultRoot.AMOUNT_BULLETS;
			}
		}

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void summarizeScore() {
		VERIFY_SUM.notifyAll();

	}

	public void setScoresForMainMenu() {
		manager.sortPlayers();
		switch (manager.getPlayersList().size()) {
		case 0: {
			view.setScoreOne("---");
			view.setScoreTwo("---");
			view.setScoreThree("---");
			view.setScoreFour("---");
			view.setScoreFive("---");
			break;

		}
		case 1: {
			view.setScoreOne(manager.getPlayersList().get(0) + "");
			break;
		}
		case 2: {
			view.setScoreOne(manager.getPlayersList().get(0) + "");
			view.setScoreTwo(manager.getPlayersList().get(1) + "");
			break;
		}

		case 3: {
			view.setScoreOne(manager.getPlayersList().get(0) + "");
			view.setScoreTwo(manager.getPlayersList().get(1) + "");
			view.setScoreThree(manager.getPlayersList().get(2) + "");
			break;
		}

		case 4: {
			view.setScoreOne(manager.getPlayersList().get(0) + "");
			view.setScoreTwo(manager.getPlayersList().get(1) + "");
			view.setScoreThree(manager.getPlayersList().get(2) + "");
			view.setScoreFour(manager.getPlayersList().get(3) + "");
			break;
		}

		default:
			view.setScoreOne(manager.getPlayersList().get(0) + "");
			view.setScoreTwo(manager.getPlayersList().get(1) + "");
			view.setScoreThree(manager.getPlayersList().get(2) + "");
			view.setScoreFour(manager.getPlayersList().get(3) + "");
			view.setScoreFive(manager.getPlayersList().get(4) + "");
			break;
		}
	}

	public void setScoresForGameOver() {
		manager.sortPlayers();
		switch (manager.getPlayersList().size()) {
		case 0: {
			view.setScores1("---");
			view.setScores2("---");
			view.setScores3("---");
			view.setScores4("---");
			view.setScores5("---");
			break;

		}
		case 1: {
			view.setScores1(manager.getPlayersList().get(0) + "");
			break;
		}
		case 2: {
			view.setScores1(manager.getPlayersList().get(0) + "");
			view.setScores2(manager.getPlayersList().get(1) + "");
			break;
		}

		case 3: {
			view.setScores1(manager.getPlayersList().get(0) + "");
			view.setScores2(manager.getPlayersList().get(1) + "");
			view.setScores3(manager.getPlayersList().get(2) + "");
			break;
		}

		case 4: {
			view.setScores1(manager.getPlayersList().get(0) + "");
			view.setScores2(manager.getPlayersList().get(1) + "");
			view.setScores3(manager.getPlayersList().get(2) + "");
			view.setScores4(manager.getPlayersList().get(3) + "");
			break;
		}

		default:
			view.setScores1(manager.getPlayersList().get(0) + "");
			view.setScores2(manager.getPlayersList().get(1) + "");
			view.setScores3(manager.getPlayersList().get(2) + "");
			view.setScores4(manager.getPlayersList().get(3) + "");
			view.setScores5(manager.getPlayersList().get(4) + "");
			break;
		}
	}

	@Override
	public void increaseSpeed() {
		if (view.getPnGame().getPnGameBoard().getThread().getDelay() > 3) {
			view.getPnGame().getPnGameBoard().getThread()
					.setDelay(view.getPnGame().getPnGameBoard().getThread().getDelay() - 2);
		}
	}

	@Override
	public void gameOver() {
		VERIFY_SUM.pause();
		view.showGameOver();
		view.stopMenuMusic();
		view.setFinalScore(Integer.toString(manager.getGameSet().getScore()));
		manager.getGameSet().gameOver(view.getFinalPlayerGame());
		setScoresForMainMenu();
		setScoresForGameOver();
		manager.savePlayersData(manager.getPlayersList());
	}
}

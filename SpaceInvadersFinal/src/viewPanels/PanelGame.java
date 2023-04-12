/**
 *
 */
package viewPanels;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import utils.MyListener;

/**
 *
 * @author Julian Huertas Henao, Jose Gerardo Gomez, Luis Carlos Castillo
 *
 */
public class PanelGame extends JPanel {

	private static final long serialVersionUID = 1L;
	private PanelGameHeader pnGameHeader;
	private PanelGameBoard pnGameBoard;
	private PanelGameFooter pnGameFooter;

	public PanelGame(ActionListener listener, MyListener invadersListener) {
		initComponents(listener, invadersListener);
		this.setBackground(Color.BLACK);
		this.setBorder(BorderFactory.createLineBorder(new Color(49, 89, 28), 8));
	}

	private void initComponents(ActionListener listener, MyListener invadersListener) {
		GridBagConstraints gbc = new GridBagConstraints();
		setLayout(new GridBagLayout());

		pnGameHeader = new PanelGameHeader(listener);
		gbc.ipadx = 1045;
		gbc.ipady = 20;
		gbc.gridy = 1;
		gbc.gridx = 0;
		this.add(pnGameHeader, gbc);

		pnGameBoard = new PanelGameBoard(invadersListener);
		gbc.ipadx = 1135;
		gbc.ipady = 630;
		gbc.gridy = 2;
		gbc.gridx = 0;
		this.add(pnGameBoard, gbc);

		pnGameFooter = new PanelGameFooter(listener);
		gbc.ipadx = 1030;
		gbc.ipadx = 1230;
		gbc.ipady = 2;
		gbc.gridy = 3;
		gbc.gridx = 0;
		this.add(pnGameFooter, gbc);
	}

	public void launchGame() {
		pnGameBoard.launchGame();
	}

	public void stopGame() {
		pnGameBoard.stopGame();
	}

	public void moveRight() {
		pnGameBoard.moveRight();

	}

	public void moveLeft() {
		pnGameBoard.moveLeft();

	}

	public void setShooting(int count) {
		pnGameBoard.setShooting(count);

	}

	public PanelGameBoard getPnGameBoard() {
		return pnGameBoard;
	}

	public void setScore(String score) {
		pnGameHeader.setScore(score);
	}

	public String getPnHeaderScore() {
		return pnGameHeader.getScore();
	}
}

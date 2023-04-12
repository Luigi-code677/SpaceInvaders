/**
 * 
 */
package viewPanels;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import constants.CommandButton;
import utils.ButtonGeneral;

/**
 * 
 * @author Julian Huertas Henao, Jose Gerardo Gomez, Luis Carlos Castillo
 *
 */
public class PanelOptions extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnStartGame;
	private JButton btnSettings;
	private JButton btnScores;
	private JButton btnExit;

	/**
	 * @param listener
	 */
	public PanelOptions(ActionListener listener) {
		initComponents(listener);

	}

	/**
	 * @param listener
	 */
	private void initComponents(ActionListener listener) {
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		Font font = new Font("OCR A Extended", Font.PLAIN, 30);
		gbc.insets = new Insets(4, 4, 5, 4);

		btnStartGame = new ButtonGeneral("START 1 PLAYER GAME");
		btnStartGame.setFont(font);
		btnStartGame.setForeground(Color.WHITE);
		btnStartGame.setBackground(Color.BLACK);
		btnStartGame.setBorder(null);
		btnStartGame.setActionCommand(CommandButton.START_GAME_ONE_PLAYER);
		btnStartGame.addActionListener(listener);
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.ipady = 35;
		gbc.ipadx = 400;
		this.add(btnStartGame, gbc);

		btnSettings = new ButtonGeneral("GAME SETTINGS");
		btnSettings.setFont(font);
		btnSettings.setForeground(Color.WHITE);
		btnSettings.setBackground(Color.BLACK);
		btnSettings.setActionCommand(CommandButton.SETTINGS);
		btnSettings.addActionListener(listener);
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.ipadx = 300;

		this.add(btnSettings, gbc);

		btnScores = new ButtonGeneral("SCORES");
		btnScores.setFont(font);
		btnScores.setForeground(Color.WHITE);
		btnScores.setBackground(Color.BLACK);
		btnScores.setActionCommand(CommandButton.SCORES);
		btnScores.addActionListener(listener);
		gbc.gridx = 0;
		gbc.gridy = 3;
		this.add(btnScores, gbc);

		btnExit = new ButtonGeneral("EXIT");
		btnExit.setFont(font);
		btnExit.setForeground(Color.WHITE);
		btnExit.setBackground(Color.BLACK);
		btnExit.setActionCommand(CommandButton.EXIT);
		btnExit.addActionListener(listener);
		gbc.gridx = 0;
		gbc.gridy = 4;
		this.add(btnExit, gbc);
	}

}

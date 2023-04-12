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
import javax.swing.JLabel;
import javax.swing.JPanel;

import constants.CommandButton;
import utils.ButtonGeneral;

/**
 * 
 * @author Julian Huertas Henao, Jose Gerardo Gomez, Luis Carlos Castillo
 *
 */
public class PanelGameHeader extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton btnBack;
	private JLabel scorePlayer1;
	private JLabel score1;

	public PanelGameHeader(ActionListener listener) {
		initComponents(listener);
		this.setBackground(new Color(49, 89, 28));

	}

	private void initComponents(ActionListener listener) {

		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		Font font = new Font("OCR A Extended", Font.PLAIN, 30);

		scorePlayer1 = new JLabel("SCORE PLAYER <1> ");
		scorePlayer1.setFont(font);
		scorePlayer1.setForeground(Color.GREEN);
		scorePlayer1.setBackground(Color.BLACK);
		gbc.gridx = 2;
		gbc.gridy = 0;
		gbc.ipadx = 400;
		gbc.insets = new Insets(0, 100, 0, 0);
		this.add(scorePlayer1, gbc);
		score1 = new JLabel("000000");
		score1.setFont(font);
		score1.setForeground(Color.WHITE);
		score1.setBackground(Color.BLACK);
		gbc.gridx = 2;
		gbc.gridy = 1;
		gbc.ipadx = 400;
		gbc.insets = new Insets(0, 100, 0, 0);
		this.add(score1, gbc);

		btnBack = new ButtonGeneral("<--");
		btnBack.setFont(font);
		btnBack.setForeground(Color.GREEN);
		btnBack.setBackground(Color.BLACK);
		btnBack.setBorder(null);
		btnBack.setActionCommand(CommandButton.GO_BACK_MAIN_MENU);
		btnBack.addActionListener(listener);
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.ipadx = 100;
		gbc.ipady = 50;
		gbc.insets = new Insets(0, -500, 0, 0);
		this.add(btnBack, gbc);

	}

	public void setScore(String score) {
		int scoreNumberSize = 6 - score.length();
		String finalScore = "";
		for (int i = 0; i < scoreNumberSize; i++) {
			finalScore += 0;
		}
		finalScore += score;

		score1.setText(finalScore);
	}

	public String getScore() {
		return score1.getText();
	}
}

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
public class PanelScores extends JPanel {
	private static final long serialVersionUID = 1L;
	private JButton btnBack;
	private JLabel bestScores;
	private JLabel bestScore1;
	private JLabel bestScore2;
	private JLabel bestScore3;
	private JLabel bestScore4;
	private JLabel bestScore5;

	public PanelScores(ActionListener listener) {
		initComponents(listener);
		this.setBackground(new Color(49, 89, 28));
	}

	private void initComponents(ActionListener listener) {

		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		Font font = new Font("OCR A Extended", Font.PLAIN, 30);

		bestScores = new JLabel("<BEST SCORES>");
		bestScores.setFont(new Font("OCR A Extended", Font.BOLD, 46));
		bestScores.setForeground(Color.RED);
		bestScores.setBackground(Color.BLACK);
		gbc.gridx = 1;
		gbc.gridy = 3;
		this.add(bestScores, gbc);
		bestScore1 = new JLabel("---");
		bestScore1.setFont(font);
		bestScore1.setForeground(Color.WHITE);
		bestScore1.setBackground(Color.BLACK);
		gbc.insets = new Insets(0, 0, 0, 0);
		gbc.gridx = 1;
		gbc.gridy = 4;
		this.add(bestScore1, gbc);
		bestScore2 = new JLabel("---");
		bestScore2.setFont(font);
		bestScore2.setForeground(Color.WHITE);
		bestScore2.setBackground(Color.BLACK);
		gbc.gridx = 1;
		gbc.gridy = 5;
		this.add(bestScore2, gbc);
		bestScore3 = new JLabel("---");
		bestScore3.setFont(font);
		bestScore3.setForeground(Color.WHITE);
		bestScore3.setBackground(Color.BLACK);
		gbc.gridx = 1;
		gbc.gridy = 6;
		this.add(bestScore3, gbc);
		bestScore4 = new JLabel("---");
		bestScore4.setFont(font);
		bestScore4.setForeground(Color.WHITE);
		bestScore4.setBackground(Color.BLACK);
		gbc.gridx = 1;
		gbc.gridy = 7;
		this.add(bestScore4, gbc);
		bestScore5 = new JLabel("---");
		bestScore5.setFont(font);
		bestScore5.setForeground(Color.WHITE);
		bestScore5.setBackground(Color.BLACK);
		gbc.gridx = 1;
		gbc.gridy = 8;
		gbc.insets = new Insets(0, 0, 20, 0);
		this.add(bestScore5, gbc);

		btnBack = new ButtonGeneral("GO BACK");
		btnBack.setFont(font);
		btnBack.setForeground(Color.GREEN);
		btnBack.setBackground(Color.BLACK);
		btnBack.setBorder(null);
		btnBack.setActionCommand(CommandButton.GO_BACK);
		btnBack.addActionListener(listener);
		gbc.gridx = 1;
		gbc.gridy = 9;
		gbc.ipadx = 400;
		gbc.ipady = 50;
		this.add(btnBack, gbc);

	}

	public void setScoreOne(String text) {
		bestScore1.setText("<" + text + ">");
	}

	public void setScoreTwo(String text) {
		bestScore2.setText("<" + text + ">");
	}

	public void setScoreThree(String text) {
		bestScore3.setText("<" + text + ">");
	}

	public void setScoreFour(String text) {
		bestScore4.setText("<" + text + ">");
	}

	public void setScoreFive(String text) {
		bestScore5.setText("<" + text + ">");
	}
}

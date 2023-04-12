/**
 * 
 */
package viewDialogs;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import constants.CommandButton;
import utils.ButtonGeneral;
import utils.NameTextField;

/**
 * 
 * @author Julian Huertas Henao, Jose Gerardo Gomez, Luis Carlos Castillo
 *
 */
public class DialogGameOver extends JDialog {

	private static final long serialVersionUID = 1L;
	private JLabel lblTittle;
	private NameTextField name;
	private JLabel scorePlayer1;
	private JLabel score1;
	private JButton btnBack;
	private JButton playAgain;
	private JLabel bestScores;
	private JLabel bestScore1;
	private JLabel bestScore2;
	private JLabel bestScore3;
	private JLabel bestScore4;
	private JLabel bestScore5;
	private JLabel writeName;

	public DialogGameOver(ActionListener listener, JFrame mainFrame) {
		super(mainFrame);
		this.setLayout(new GridBagLayout());
		initComponents(listener);
		this.setSize(1175, 800);
		this.setAlwaysOnTop(true);
		this.setLocationRelativeTo(null);
		this.getContentPane().setBackground(Color.BLACK);
		this.setResizable(false);
		this.setVisible(true);
	}

	/**
	 * @param listener
	 */
	private void initComponents(ActionListener listener) {
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		Font font = new Font("OCR A Extended", Font.PLAIN, 30);

		lblTittle = new JLabel("GAMEOVER", SwingConstants.CENTER);
		lblTittle.setFont(new Font("OCR A Extended", Font.BOLD, 110));
		lblTittle.setForeground(Color.GREEN);
		gbc.gridy = 0;
		gbc.gridx = 0;
		gbc.gridwidth = 6;
		this.add(lblTittle, gbc);

		scorePlayer1 = new JLabel(" SCORE PLAYER <1> ");
		scorePlayer1.setFont(font);
		scorePlayer1.setForeground(Color.GREEN);
		scorePlayer1.setBackground(Color.BLACK);
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.gridwidth = 3;
		gbc.insets = new Insets(0, 80, 10, 0);
		this.add(scorePlayer1, gbc);

		name = new NameTextField();
		gbc.gridx = 4;
		gbc.gridy = 1;
		gbc.ipadx = 100;
		gbc.gridwidth = 1;
		gbc.insets = new Insets(0, 0, 10, 10);
		this.add(name, gbc);
		score1 = new JLabel("000000");
		score1.setFont(font);
		score1.setForeground(Color.WHITE);
		score1.setBackground(Color.BLACK);
		gbc.gridx = 5;
		gbc.gridy = 1;
		gbc.gridwidth = 0;
		this.add(score1, gbc);

		bestScores = new JLabel("<BEST SCORES>");
		bestScores.setFont(new Font("OCR A Extended", Font.BOLD, 46));
		bestScores.setForeground(Color.RED);
		bestScores.setBackground(Color.BLACK);
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.insets = new Insets(0, 100, 0, 0);
		this.add(bestScores, gbc);
		bestScore1 = new JLabel("---");
		bestScore1.setFont(font);
		bestScore1.setForeground(Color.WHITE);
		bestScore1.setBackground(Color.BLACK);
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
		this.add(bestScore5, gbc);

		writeName = new JLabel("INGRESE UN NOMBRE PARA CONTINUAR");
		writeName.setFont(font);
		writeName.setForeground(Color.RED);
		writeName.setBackground(Color.BLACK);
		writeName.setVisible(false);
		gbc.gridx = 1;
		gbc.gridy = 10;
		gbc.gridwidth = 5;
		this.add(writeName, gbc);

		btnBack = new ButtonGeneral("GO BACK");
		btnBack.setFont(font);
		btnBack.setForeground(Color.GREEN);
		btnBack.setBackground(Color.BLACK);
		btnBack.setBorder(null);
		btnBack.setActionCommand(CommandButton.GAMEOVER_OUT);
		btnBack.addActionListener(listener);
		gbc.gridx = 1;
		gbc.gridy = 9;
		gbc.ipadx = 200;
		gbc.ipady = 50;
		gbc.gridwidth = 0;
		gbc.insets = new Insets(100, -400, 20, 0);
		this.add(btnBack, gbc);

		playAgain = new ButtonGeneral("NEW GAME");
		playAgain.setFont(font);
		playAgain.setForeground(Color.GREEN);
		playAgain.setBackground(Color.BLACK);
		playAgain.setBorder(null);
		playAgain.setActionCommand(CommandButton.NEWGAME);
		playAgain.addActionListener(listener);
		gbc.gridx = 4;
		gbc.gridy = 9;
		gbc.ipadx = 200;
		gbc.ipady = 50;
		gbc.insets = new Insets(100, 0, 20, 0);
		this.add(playAgain, gbc);

	}

	public void setActualScore(String score) {
		score1.setText("<" + score + ">");
	}

	public void setScores1(String score) {
		bestScore1.setText("<" + score + ">");
	}

	public void setScores2(String score) {
		bestScore2.setText("<" + score + ">");
	}

	public void setScores3(String score) {
		bestScore3.setText("<" + score + ">");
	}

	public void setScores4(String score) {
		bestScore4.setText("<" + score + ">");
	}

	public void setScores5(String score) {
		bestScore5.setText("<" + score + ">");
	}

	public String getPlayerName() {
		return name.getText();
	}

	public void setShowMessageName() {
		writeName.setVisible(true);
	}

}

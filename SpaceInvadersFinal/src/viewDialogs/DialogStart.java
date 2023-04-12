/**
 *
 */
package viewDialogs;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.BooleanControl;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import constants.DefaultRoot;
import viewPanels.PanelInstructions;
import viewPanels.PanelOptions;
import viewPanels.PanelScores;
import viewPanels.PanelSettings;

/**
 *
 * @author Julian Huertas Henao, Jose Gerardo Gomez, Luis Carlos Castillo
 *
 */
public class DialogStart extends JDialog {

	private static final long serialVersionUID = 1L;
	private JLabel lblTittle;
	private JLabel lblTittle2;
	private PanelOptions pnOptions;
	private PanelScores pnScores;
	private PanelSettings pnSettings;
	private PanelInstructions pnInstructions;
	private boolean isPaused;
	private Clip clip;

	public DialogStart(ActionListener listener, JFrame mainFrame) {
		super(mainFrame);
		this.isPaused = true;
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

		lblTittle = new JLabel("SPACE", SwingConstants.CENTER);
		lblTittle.setFont(new Font("OCR A Extended", Font.BOLD, 75));
		lblTittle.setForeground(Color.WHITE);
		gbc.gridy = 0;
		this.add(lblTittle, gbc);

		lblTittle2 = new JLabel("INVADERS", SwingConstants.CENTER);
		lblTittle2.setFont(new Font("OCR A Extended", Font.BOLD, 74));
		lblTittle2.setForeground(Color.GREEN);
		gbc.gridy = 1;
		this.add(lblTittle2, gbc);

		pnOptions = new PanelOptions(listener);
		pnOptions.setBackground(Color.BLACK);
		pnOptions.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
		gbc.gridy = 2;
		gbc.ipady = 200;
		gbc.ipadx = 700;
		this.add(pnOptions, gbc);

		pnSettings = new PanelSettings(listener);
		pnSettings.setBackground(Color.BLACK);
		pnSettings.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
		pnSettings.setVisible(false);
		gbc.gridy = 2;
		gbc.ipady = 300;
		gbc.ipadx = 600;
		this.add(pnSettings, gbc);

		pnScores = new PanelScores(listener);
		pnScores.setBackground(Color.BLACK);
		pnScores.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
		pnScores.setVisible(false);
		gbc.gridy = 2;
		gbc.ipady = 200;
		gbc.ipadx = 500;
		this.add(pnScores, gbc);

		pnInstructions = new PanelInstructions(listener);
		pnInstructions.setBackground(Color.BLACK);
		gbc.gridy = 3;
		gbc.ipady = 80;
		this.add(pnInstructions, gbc);

		startMenuMusic();
	}

	public void showSettings() {
		pnOptions.setVisible(false);
		pnInstructions.setVisible(false);
		pnScores.setVisible(false);
		pnSettings.setVisible(true);

	}

	public void showScores() {
		pnOptions.setVisible(false);
		pnInstructions.setVisible(false);
		pnSettings.setVisible(false);
		pnScores.setVisible(true);

	}

	public void closeSettings() {
		pnOptions.setVisible(true);
		pnInstructions.setVisible(true);
		pnScores.setVisible(false);
		pnSettings.setVisible(false);
	}

	public void startMenuMusic() {
		try {
			InputStream audioSrc = getClass().getResourceAsStream(DefaultRoot.MUSIC_SOUND);
			InputStream bufferedIn = new BufferedInputStream(audioSrc);
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(bufferedIn);
			clip = AudioSystem.getClip();
			clip.open(audioStream);
			clip.start();
			clip.loop(Clip.LOOP_CONTINUOUSLY);
		} catch (LineUnavailableException | UnsupportedAudioFileException | IOException e1) {

		}
	}

	public void stopMenuMusic() {
		if (clip != null) {
			clip.stop();
		}
	}

	public boolean getIsPaused() {
		isPaused = !isPaused;
		return isPaused;

	}

	public void setImageIconSound(boolean isPaused) {
		pnSettings.setImageIconSound(isPaused);
	}

	public void mute() {
		BooleanControl volume = (BooleanControl) clip.getControl(BooleanControl.Type.MUTE);
		volume.setValue(true);
		isPaused = true;
	}

	public void unMute() {
		BooleanControl volume = (BooleanControl) clip.getControl(BooleanControl.Type.MUTE);
		volume.setValue(false);
		isPaused = false;

	}

	public PanelScores getPnScores() {
		return pnScores;
	}

	public void setScoreOne(String text) {
		pnScores.setScoreOne(text);
	}

	public void setScoreTwo(String text) {
		pnScores.setScoreTwo(text);
	}

	public void setScoreThree(String text) {
		pnScores.setScoreThree(text);
	}

	public void setScoreFour(String text) {
		pnScores.setScoreFour(text);
	}

	public void setScoreFive(String text) {
		pnScores.setScoreFive(text);
	}

}

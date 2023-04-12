/**
 * 
 */
package viewPanels;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import constants.CommandButton;
import constants.DefaultRoot;
import utils.ButtonGeneral;

/**
 * 
 * @author Julian Huertas Henao, Jose Gerardo Gomez, Luis Carlos Castillo
 *
 */
public class PanelSettings extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnDisableMusic;
	private JButton btnBack;
	private JLabel lblSoundMusic;

	/**
	 * @param listener
	 */
	public PanelSettings(ActionListener listener) {
		initComponents(listener);
	}

	/**
	 * @param listener
	 */
	private void initComponents(ActionListener listener) {
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		Font font = new Font("OCR A Extended", Font.PLAIN, 30);

		lblSoundMusic = new JLabel(new ImageIcon(new ImageIcon(DefaultRoot.BUTTON_SOUND_NORMAL).getImage()
				.getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.ipadx = 40;
		gbc.ipady = 40;
		this.add(lblSoundMusic, gbc);

		btnDisableMusic = new ButtonGeneral("SOUND MUSIC ");
		btnDisableMusic.setFont(font);
		btnDisableMusic.setForeground(Color.WHITE);
		btnDisableMusic.setBackground(Color.BLACK);
		btnDisableMusic.setBorder(null);
		btnDisableMusic.setActionCommand(CommandButton.SOUND_APP);
		btnDisableMusic.addActionListener(listener);
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.ipady = 40;
		gbc.ipadx = 400;
		this.add(btnDisableMusic, gbc);

		btnBack = new ButtonGeneral("GO BACK");
		btnBack.setFont(font);
		btnBack.setForeground(Color.WHITE);
		btnBack.setBackground(Color.BLACK);
		btnBack.setBorder(null);
		btnBack.setActionCommand(CommandButton.GO_BACK);
		btnBack.addActionListener(listener);
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 2;
		this.add(btnBack, gbc);

	}

	public void setImageIconSound(boolean isPaused) {
		if (isPaused) {
			lblSoundMusic.setIcon(new ImageIcon(new ImageIcon(DefaultRoot.BUTTON_SOUND_NORMAL).getImage()
					.getScaledInstance(50, 50, Image.SCALE_SMOOTH)));

		} else {
			lblSoundMusic.setIcon(new ImageIcon(new ImageIcon(DefaultRoot.BUTTON_SOUND_PRESSED).getImage()
					.getScaledInstance(50, 50, Image.SCALE_SMOOTH)));

		}
		this.repaint();
	}

}

/**
 * 
 */
package viewDialogs;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import constants.CommandButton;
import utils.ButtonGeneral;

/**
*
* @author Julian Huertas Henao, Jose Gerardo Gomez, Luis Carlos Castillo
*/
public class PanelButton extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton btnBack;

	/**
	 * @param listener
	 */
	public PanelButton(ActionListener listener) {
		this.setLayout(new GridBagLayout());
		this.setBackground(new Color(34, 34, 34));
		initsComponents(listener);
	}

	/**
	 * @param listener
	 */
	private void initsComponents(ActionListener listener) {
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		Font font = new Font("OCR A Extended", Font.PLAIN, 30);
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

}

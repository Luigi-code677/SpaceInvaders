/**
 * 
 */
package viewPanels;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * 
 * @author Julian Huertas Henao, Jose Gerardo Gomez, Luis Carlos Castillo
 *
 */
public class PanelInstructions extends JPanel {


	private static final long serialVersionUID = 1L;
	private JLabel lblInstructions;
	


	/**
	 * @param listener
	 */
	public PanelInstructions(ActionListener listener) {
		this.setLayout(new GridBagLayout());
		setBackground(new Color(34, 34, 34));
		initsComponents(listener);
	}

	/**
	 * @param listener
	 */
	private void initsComponents(ActionListener listener) {
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		lblInstructions = new JLabel("Left/Right arrow ", SwingConstants.CENTER);
		lblInstructions.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		lblInstructions.setForeground(Color.GREEN);
		gbc.gridx = 0;
		this.add(lblInstructions, gbc);

		lblInstructions = new JLabel("- move, ", SwingConstants.CENTER);
		lblInstructions.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		lblInstructions.setForeground(Color.WHITE);
		gbc.gridx = 1;
		this.add(lblInstructions, gbc);

		lblInstructions = new JLabel("SPACE", SwingConstants.CENTER);
		lblInstructions.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		lblInstructions.setForeground(Color.GREEN);
		gbc.gridx = 2;
		this.add(lblInstructions, gbc);

		lblInstructions = new JLabel("- fire ", SwingConstants.CENTER);
		lblInstructions.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		lblInstructions.setForeground(Color.WHITE);
		gbc.gridx = 3;
		this.add(lblInstructions, gbc);

	}
	


}

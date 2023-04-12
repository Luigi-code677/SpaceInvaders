/**
 * 
 */
package viewPanels;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 * 
 * @author Julian Huertas Henao, Jose Gerardo Gomez, Luis Carlos Castillo
 *
 */
public class PanelGameFooter extends JPanel {

	private static final long serialVersionUID = 1L;

	public PanelGameFooter(ActionListener listener) {
		initComponents(listener);
		this.setBackground(Color.GREEN);
		this.setBorder(BorderFactory.createLineBorder(Color.GREEN, 1));

	}

	private void initComponents(ActionListener listener) {

	}
}

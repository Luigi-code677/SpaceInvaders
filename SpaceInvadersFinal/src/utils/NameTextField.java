/**
 * 
 */
package utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.JTextField;

/**
 * 
 * @author Julian Huertas Henao, Jose Gerardo Gomez, Luis Carlos Castillo
 *
 */
public class NameTextField extends JTextField {
	private static final long serialVersionUID = 1L;
	public NameTextField() {

		this.initsComponents();
		this.initsKeyListener();

	}

	public NameTextField(String name) {
		this.setEditable(true);
		this.setOpaque(false);
		this.setText(name);
		this.setBackground(Color.BLACK);
		this.initsComponents();
	}

	private void initsComponents() {
		this.setEditable(true);
		this.setSize(130, 40);
		this.setFont(new Font("OCR A Extended", Font.BOLD, 30));
		this.setForeground(Color.WHITE);
		this.setBackground(Color.DARK_GRAY);
		this.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
	}

	public void initsKeyListener() {
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (Character.isDigit(e.getKeyChar()) || getContentText().length() > 3) {
					e.consume();
				}
			}
		});
	}

	public String getContentText() {
		return this.getText();
	}

}
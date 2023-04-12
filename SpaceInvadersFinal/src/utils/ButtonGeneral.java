package utils;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonModel;
import javax.swing.JButton;

/**
 * 
 * @author Julian Huertas Henao, Jose Gerardo Gomez, Luis Carlos Castillo
 *
 */
public class ButtonGeneral extends JButton {

	private static final long serialVersionUID = 1L;
	private String message;
	private Color colorButton;
	private Color colorButtonRollover;
	private Color colorButtonPressed;
	private Color colorText;
	private Font fnText;
	private String pressedIngredient;

	public ButtonGeneral(String message) {
		this.message = message;
		this.pressedIngredient = null;
		defaultValues();
		setOpaque(false);
		setContentAreaFilled(false);
		setForeground(Color.WHITE);
		setFocusPainted(false);
		setBorderPainted(false);
	}

	private void defaultValues() {
		colorButton = Color.BLACK;
		colorText = Color.WHITE;
		colorButtonRollover = new Color(32, 165, 67);
		colorButtonPressed = new Color(15, 89, 34);
		fnText = new Font("OCR A Extended", Font.PLAIN, 30);
	}

	protected void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		ButtonModel m = this.getModel();
		if (m.isRollover()) {
			setCursor(new Cursor(Cursor.HAND_CURSOR));
			paintButton(g2d, colorButtonRollover);
		} else {
			paintButton(g2d, colorButton);
		}
		if (m.isPressed()) {
			paintButton(g2d, colorButtonPressed);
		}
	}

	private void paintButton(Graphics2D g2d, Color colorButton) {
		g2d.setColor(colorButton);
		g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 25, 25);
		g2d.setColor(Color.WHITE);
		g2d.setFont(fnText);
		FontMetrics fn = g2d.getFontMetrics();
		paintMessage(g2d, fn);
	}

	public void defaultActionListener(ButtonGeneral btn) {
		this.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btn.setPressedIngredient(btn.getMessage());
			}
		});
	}

	public String getMessage() {
		return message;
	}

	public void setPressedIngredient(String pressedIngredient) {
		this.pressedIngredient = pressedIngredient;
	}

	public String getPressedIngredient() {
		return pressedIngredient;
	}

	private void paintMessage(Graphics2D g2d, FontMetrics fn) {
		int initialTextX = getWidth() / 2 - fn.stringWidth(message) / 2;
		g2d.setColor(colorText);
		g2d.drawString(message, initialTextX, getHeight() / 2 + 6);
	}

	public void setColorButton(Color colorButton) {
		this.colorButton = colorButton;
	}

	public void setColorText(Color colorText) {
		this.colorText = colorText;
	}

	public void setColorButtonPressed(Color colorButtonPressed) {
		this.colorButtonPressed = colorButtonPressed;
	}

	public void setColorButtonRollover(Color colorButtonRollover) {
		this.colorButtonRollover = colorButtonRollover;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}

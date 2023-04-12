package viewEntity;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Julian Huertas Henao, Jose Gerardo Gomez, Luis Carlos Castillo
 *
 */
public class Bullet {

	private int xPosition;
	private int yPosition;
	private int height;
	private int width;
	private final Color COLOR_BULLET;

	public Bullet(int xPosition, int yPosition) {
		this.xPosition = xPosition + 21;
		this.yPosition = 590;
		this.height = 30;
		this.width = 8;
		this.COLOR_BULLET = new Color(Color.WHITE.getRGB());
	}

	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void move() {
		defineYPosition();
	}

	public void paintBullet(Graphics graphics) {
		graphics.setColor(COLOR_BULLET);
		graphics.fillRect(xPosition, yPosition, width, height);
	}

	public void setBulletOrigin() {
		this.yPosition = 590;
		this.xPosition = 581;

	}

	public void defineYPosition() {
		this.yPosition = this.yPosition - 30;
	}

	public int getXPosition() {
		return xPosition;
	}

	public int getYPosition() {
		return yPosition;
	}

	public void setYPosition(int yP) {
		this.yPosition = yP;
	}

	public void setXPosition(int xP) {
		this.xPosition = xP;
	}

}

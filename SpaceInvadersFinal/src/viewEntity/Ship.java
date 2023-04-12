package viewEntity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Objects;

import javax.swing.ImageIcon;

import constants.DefaultRoot;

/**
 *
 * @author Julian Huertas Henao, Jose Gerardo Gomez, Luis Carlos Castillo
 *
 */
public class Ship {

	private int xPosition;
	private int yPosition;
	private final int HEIGHT;
	private final int WIDTH;
	private Color color;
	private final Image IMG_SHIP;
	private final Image IMG_SHIP_EXP;
	private final Bullet[] bullet;
	private boolean isVis;

	public Ship() {
		this.WIDTH = 50;
		this.HEIGHT = 30;
		this.isVis = true;
		this.xPosition = 550;
		this.yPosition = 590;
		IMG_SHIP = new ImageIcon(Objects.requireNonNull(getClass().getResource(DefaultRoot.ICON_SHIP))).getImage();
		IMG_SHIP_EXP = new ImageIcon(Objects.requireNonNull(getClass().getResource(DefaultRoot.DEATH))).getImage();
		bullet = new Bullet[DefaultRoot.AMOUNT_BULLETS];
		for (int i = 0; i < bullet.length; i++) {
			bullet[i] = new Bullet(xPosition, yPosition);
		}

	}

	public void paintShip(Graphics graphics) {
		if (isVis() == true) {
			graphics.setColor(color);
			graphics.drawImage(IMG_SHIP, xPosition, yPosition, WIDTH, HEIGHT, null);
		} else {
			graphics.setColor(color);
			graphics.drawImage(IMG_SHIP_EXP, xPosition, yPosition, WIDTH, HEIGHT + 10, null);

		}
	}

	public boolean isVis() {
		return isVis;
	}

	public void setVis(boolean isVis) {
		this.isVis = isVis;
	}

	public void moveRight() {
		if (this.xPosition < 1080) {
			this.xPosition = this.xPosition + 10;
		}

	}

	public void moveLeft() {
		if (this.xPosition > 10) {
			this.xPosition = this.xPosition - 10;
		}

	}

	public void setOrigin() {
		this.yPosition = 590;
		this.xPosition = 560;

	}

	public void generateBullet(Graphics graphics, int index) {
		bullet[index].paintBullet(graphics);
	}

	public int getPositionX() {
		return xPosition;
	}

	public int getWidth() {
		return WIDTH;
	}

	public int getHeight() {
		return HEIGHT;
	}

	public int getPositionY() {
		return yPosition;
	}

	public Bullet getBullet(int index) {
		return bullet[index];
	}

	public void respawnBullet(int xP, int yP, int index) {
		bullet[index].setXPosition(xP);
		bullet[index].setYPosition(yP);
	}

}

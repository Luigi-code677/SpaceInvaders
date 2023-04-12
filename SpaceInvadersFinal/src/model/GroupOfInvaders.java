package model;

import java.awt.Color;
import java.awt.Graphics;

import constants.DefaultRoot;
import utils.MyListener;
import viewEntity.Invader;
import viewEntity.Ship;

/**
 * @author Julian Huertas Henao, Jose Gerardo Gomez, Luis Carlos Castillo
 */
public class GroupOfInvaders {

	// Tabla que contiene todos los aliens
	private final Invader[][] INVADER_TABLE;
	private int numberColumns;
	private final int NUMBER_ROWS;
	private boolean goRight;
	private boolean moveLeft;
	private boolean moveRight;
	private Ship ship;
	private final MyListener IN_LISTENER;

	public GroupOfInvaders(MyListener inListener) {
		this.NUMBER_ROWS = DefaultRoot.NUMBER_ROWS;
		this.numberColumns = DefaultRoot.NUMBER_COLUMNS;
		INVADER_TABLE = new Invader[this.NUMBER_ROWS][numberColumns];
		this.initMatrixIvaders();
		this.goRight = true;
		this.setMoveLeft(false);
		this.setMoveRight(false);
		this.IN_LISTENER = inListener;
	}

	public void setShip(Ship ship) {
		this.ship = ship;
	}

	public void restartMatrix() {
		this.ship.setOrigin();
		ship.setVis(true);
		this.setNumberColumns(10);
		for (int i = 0; i < DefaultRoot.AMOUNT_BULLETS; i++) {
			ship.getBullet(i).setBulletOrigin();
		}
		for (int i = 0; i < DefaultRoot.NUMBER_COLUMNS; i++) {
			for (int j = 0; j < DefaultRoot.NUMBER_ROWS; j++) {
				initMatrixIvaders();
			}
		}
	}

	private void initMatrixIvaders() {
		for (int i = 0; i < numberColumns; i++) {
			this.INVADER_TABLE[0][i] = new Invader(90 + (DefaultRoot.WIDTH_INVADER) * i, 43, DefaultRoot.INVADER1);
			this.INVADER_TABLE[1][i] = new Invader(90 + (DefaultRoot.WIDTH_INVADER) * i, 97, DefaultRoot.INVADER1);
			for (int j = 2; j < 4; j++) {
				if (j == 2) {
					this.INVADER_TABLE[j][i] = new Invader(90 + (DefaultRoot.WIDTH_INVADER) * i, 72 * j,
							DefaultRoot.INVADER2);
				} else {
					this.INVADER_TABLE[j][i] = new Invader(90 + (DefaultRoot.WIDTH_INVADER) * i, 65 * j,
							DefaultRoot.INVADER2);
				}
			}
			for (int j = 4; j < NUMBER_ROWS; j++) {
				if (j == 4) {
					this.INVADER_TABLE[j][i] = new Invader(90 + (DefaultRoot.WIDTH_INVADER) * i, 62 * j,
							DefaultRoot.INVADER3);
				} else {
					this.INVADER_TABLE[j][i] = new Invader(90 + (DefaultRoot.WIDTH_INVADER) * i, 60 * j,
							DefaultRoot.INVADER3);
				}
			}
		}
	}

	public void hitDetectShip() {
		for (int i = 0; i < INVADER_TABLE.length; i++) {
			for (int j = 0; j < INVADER_TABLE[0].length; j++) {
				if (ship.isVis() == true & INVADER_TABLE[i][j].isVis() == true
						&& ship.getPositionY() <= INVADER_TABLE[i][j].getyPosition() + INVADER_TABLE[i][j].getHeight()

				)

				{
					new Thread(new Runnable() {

						@Override
						public void run() {
							ship.setVis(false);
							try {
								Thread.sleep(800);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							IN_LISTENER.gameOver();

						}

					}).start();

				}

			}
		}

	}

	public synchronized void hitDetect(int index) {
		for (int i = 0; i < INVADER_TABLE.length; i++) {
			for (int j = 0; j < INVADER_TABLE[0].length; j++) {
				if (INVADER_TABLE[i][j].isVis() == true
						&& ship.getBullet(index).getXPosition()
								+ ship.getBullet(index).getWidth() >= INVADER_TABLE[i][j].getxPosition()
						&& ship.getBullet(index).getXPosition() <= INVADER_TABLE[i][j].getxPosition()
								+ INVADER_TABLE[i][j].getWidth()
						&& ship.getBullet(index).getYPosition()
								+ ship.getBullet(index).getHeight() >= (INVADER_TABLE[i][j].getyPosition())
						&& ship.getBullet(index).getYPosition() <= INVADER_TABLE[i][j].getyPosition()
								+ INVADER_TABLE[i][j].getHeight()) {

					GameSet.sumScore();

					INVADER_TABLE[i][j].setVis(false);
					IN_LISTENER.increaseSpeed();
					ship.getBullet(index).setXPosition(-30);
					reduceMatrix();
					if (numberColumns == 0) {
						IN_LISTENER.gameOver();
					}
				}
			}
		}
	}

	private void reduceMatrix() {
		boolean isReduced = false;
		for (int i = 0; i < numberColumns; i++) {
			for (int j = 0; j < NUMBER_ROWS; j++) {
				if (INVADER_TABLE[j][i].isVis()) {
					isReduced = false;
					break;
				} else {
					isReduced = true;
				}
			}
			if (isReduced) {
				accommodateMatrix(i);
				numberColumns--;
			}
		}
	}

	private void accommodateMatrix(int numberColumn) {
		for (int i = numberColumn; i < numberColumns - 1; i++) {

			this.INVADER_TABLE[0][i] = this.INVADER_TABLE[0][i + 1];
			this.INVADER_TABLE[1][i] = this.INVADER_TABLE[1][i + 1];
			for (int j = 2; j < 4; j++) {
				this.INVADER_TABLE[j][i] = this.INVADER_TABLE[j][i + 1];
			}
			for (int j = 4; j < NUMBER_ROWS; j++) {
				this.INVADER_TABLE[j][i] = this.INVADER_TABLE[j][i + 1];
			}
		}
	}

	public void drawInvaders(Graphics g, int width, int height) {
		move();
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, width, height);
		for (int i = 0; i < numberColumns; i++) {
			for (int j = 0; j < NUMBER_ROWS; j++) {
				if (this.INVADER_TABLE[j][i] != null) {
					if (INVADER_TABLE[j][i].isVis()) {
						g.drawImage(this.INVADER_TABLE[j][i].getImgInvader(), this.INVADER_TABLE[j][i].getxPosition(),
								this.INVADER_TABLE[j][i].getyPosition(), null);
					}

				}
			}
		}
	}

	public void move() {
		if (goRight) {
			for (int i = 0; i < numberColumns; i++) {
				for (int j = 0; j < NUMBER_ROWS; j++) {
					if (this.INVADER_TABLE[j][i] != null) {
						this.INVADER_TABLE[j][i].setxPosition(INVADER_TABLE[j][i].getxPosition() + 4);
						if (INVADER_TABLE[j][i].getxPosition() > 1070) {
							goRight = false;
							moveLeftRight(1);
						}
					}
				}
			}
		} else {
			for (int i = 0; i < numberColumns; i++) {
				for (int j = 0; j < NUMBER_ROWS; j++) {
					if (this.INVADER_TABLE[j][i] != null) {
						this.INVADER_TABLE[j][i].setxPosition(INVADER_TABLE[j][i].getxPosition() - 4);
						if (INVADER_TABLE[j][i].getxPosition() < 5) {
							goRight = true;
							moveLeftRight(2);
						}
					}
				}
			}
		}
	}

	public void moveLeftRight(int d) {
		for (int i = 0; i < this.NUMBER_ROWS; i++) {
			for (int j = 0; j < this.numberColumns; j++) {
				if (d == 1) {
					setMoveLeft(true);
					setMoveRight(false);
				} else {
					setMoveLeft(false);
					setMoveRight(true);
				}
				INVADER_TABLE[i][j].setyPosition(INVADER_TABLE[i][j].getyPosition() + 2);
			}
		}
	}

	public int getNumberColumns() {
		return numberColumns;
	}

	public void setNumberColumns(int numberColumns) {
		this.numberColumns = numberColumns;
	}

	/**
	 * @return the moveLeft
	 */
	public boolean isMoveLeft() {
		return moveLeft;
	}

	/**
	 * @param moveLeft the moveLeft to set
	 */
	public void setMoveLeft(boolean moveLeft) {
		this.moveLeft = moveLeft;
	}

	/**
	 * @return the moveRight
	 */
	public boolean isMoveRight() {
		return moveRight;
	}

	/**
	 * @param moveRight the moveRight to set
	 */
	public void setMoveRight(boolean moveRight) {
		this.moveRight = moveRight;
	}

}

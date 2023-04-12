package viewPanels;

import constants.DefaultRoot;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;
import model.GroupOfInvaders;
import utils.MyListener;
import viewEntity.Ship;

/**
 *
 * @author Julian Huertas Henao, Jose Gerardo Gomez, Luis Carlos Castillo
 *
 */
public class PanelGameBoard extends JPanel {

	private static final long serialVersionUID = 1L;
	private final GroupOfInvaders INVADERS;
	private final Ship SHIP;
	private Timer thread;

	public PanelGameBoard(MyListener invadersListener) {
		setLayout(null);
		this.INVADERS = new GroupOfInvaders(invadersListener);
		SHIP = new Ship();

	}

	public void launchGame() {
		INVADERS.setShip(SHIP);
		this.setVisible(true);
		thread = new Timer(50, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				INVADERS.move();
				repaint();
			}
		});
		thread.start();

	}

	public void pauseGame() {
		try {
			thread.wait(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void stopGame() {
		thread.stop();
		INVADERS.restartMatrix();
	}

	public Timer getThread() {
		return thread;
	}

	@Override
	public void paint(Graphics graphics) {
		super.paint(graphics);
		INVADERS.drawInvaders(graphics, getWidth(), getHeight());
		for (int i = 0; i < DefaultRoot.AMOUNT_BULLETS; i++) {
			SHIP.generateBullet(graphics, i);
		}
		SHIP.paintShip(graphics);
		INVADERS.hitDetectShip();
	}

	public void moveRight() {
		SHIP.moveRight();
		for (int i = 0; i < DefaultRoot.AMOUNT_BULLETS; i++) {
			if (SHIP.getBullet(i).getYPosition() == 590) {
				SHIP.getBullet(i).setXPosition(SHIP.getPositionX() + ((SHIP.getWidth()) / 2) - 4);
			}
		}
	}

	public void moveLeft() {
		SHIP.moveLeft();
		for (int i = 0; i < DefaultRoot.AMOUNT_BULLETS; i++) {
			if (SHIP.getBullet(i).getYPosition() == 590) {
				SHIP.getBullet(i).setXPosition(SHIP.getPositionX() + ((SHIP.getWidth()) / 2) - 4);
			}
		}
	}

	public void setShooting(int count) {
		new Thread(() -> {

			if (SHIP.getBullet(count).getYPosition() == 590 || SHIP.getBullet(count).getYPosition() == -30) {
				if (SHIP.getBullet(count).getYPosition() == -30) {
					SHIP.getBullet(count).setYPosition(590);
				}
				while (SHIP.getBullet(count).getYPosition() > 0) {
					SHIP.getBullet(count).move();
					INVADERS.hitDetect(count);

					try {
						Thread.sleep(50);
					} catch (InterruptedException e1) {
					}
				}
				if (SHIP.getBullet(count).getYPosition() < 0) {
					SHIP.getBullet(count).setYPosition(590);
					SHIP.getBullet(count).setXPosition(SHIP.getPositionX() + ((SHIP.getWidth()) / 2) - 4);
				}
			}

		}).start();
	}

	public GroupOfInvaders getGroupOfInvaders() {
		return INVADERS;
	}

}

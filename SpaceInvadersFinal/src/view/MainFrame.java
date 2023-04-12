/**
 *
 */
package view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.WindowListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import constants.DefaultRoot;
import utils.MyListener;
import viewDialogs.DialogGameOver;
import viewDialogs.DialogStart;
import viewPanels.PanelGame;

/**
 *
 * @author Julian Huertas Henao, Jose Gerardo Gomez, Luis Carlos Castillo
 *
 */
public class MainFrame extends JFrame {

    private final ActionListener LISTENER;
    private final WindowListener WINDOW;
    private final KeyListener KEY_LISTENER;
    private DialogStart diStart;
    private DialogGameOver diGameOver;
    private PanelGame pnGame;

    private static final long serialVersionUID = 1L;

    public MainFrame(ActionListener listener, WindowListener window, KeyListener keyListener,
            MyListener invadersListener) {
        super("Space Invaders APP");
        this.LISTENER = listener;
        this.WINDOW = window;
        this.KEY_LISTENER = keyListener;
        this.addWindowListener(window);
        this.addKeyListener(this.KEY_LISTENER);
        initsComponents(listener, keyListener, invadersListener);
        this.setBackground(Color.BLACK);
        this.setSize(1175, 800);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        ImageIcon img = new ImageIcon(DefaultRoot.ICON_IMAGE);
        this.setIconImage(img.getImage());
        this.setFocusable(true);
    }

    private void initsComponents(ActionListener listener, KeyListener keyListener, MyListener invadersListener) {
        GridBagConstraints gbc = new GridBagConstraints();
        setLayout(new GridBagLayout());
        pnGame = new PanelGame(listener, invadersListener);
        gbc.ipadx = 1245;
        gbc.ipady = 745;
        gbc.weightx = 1;
        gbc.weighty = 1;
        this.add(pnGame, gbc);

        diStart = new DialogStart(listener, this);
        diStart.addWindowListener(WINDOW);

    }

    public void showSettings() {
        diStart.showSettings();

    }

    public void showScores() {
        diStart.showScores();

    }

    public void closeSettings() {
        diStart.closeSettings();
    }

    public void closeGame() {
        this.dispose();
        pnGame.stopGame();
        showDiStart();
    }

    public void closePrevGame() {
        pnGame.stopGame();
    }

    public void showGameOver() {
        this.dispose();
        showDiGameOver();
    }

    public void showMainFrame() {
        this.setVisible(true);
    }

    public void showDiStart() {
        diStart.setVisible(true);
    }

    public void showDiGameOver() {
        diGameOver = new DialogGameOver(LISTENER, this);
    }

    public void closeDiStart() {
        diStart.setVisible(false);
    }

    public void closeDiGameOver() {
        diGameOver.dispose();
    }

    public void stopMenuMusic() {
        diStart.stopMenuMusic();

    }

    public void muteMusic() {
        if (getIsPaused()) {
            unMuteMusic();
        } else {

            diStart.mute();
        }
    }

    public void unMuteMusic() {
        diStart.unMute();

    }

    public void startMenuMusic() {
        diStart.startMenuMusic();
    }

    public boolean getIsPaused() {
        return diStart.getIsPaused();

    }

    public void setImageIconSound(boolean isPaused) {
        diStart.setImageIconSound(isPaused);
    }

    public void launchGame() {
        pnGame.launchGame();
    }

    public void moveRight() {
        pnGame.moveRight();

    }

    public void moveLeft() {
        pnGame.moveLeft();

    }

    public void setShooting(int count) {
        pnGame.setShooting(count);

    }

    public PanelGame getPnGame() {
        return pnGame;
    }

    public void setScoreToScreen(String score) {
        pnGame.setScore(score);
    }

    public void setFinalScore(String score) {
        diGameOver.setActualScore(score);
    }

    public String getPnGameHeaderScore() {
        return pnGame.getPnHeaderScore();
    }

    public String getFinalPlayerGame() {
        return diGameOver.getPlayerName();
    }

    public void setScoreOne(String text) {
        diStart.setScoreOne(text);
    }

    public void setScoreTwo(String text) {
        diStart.setScoreTwo(text);
    }

    public void setScoreThree(String text) {
        diStart.setScoreThree(text);
    }

    public void setScoreFour(String text) {
        diStart.setScoreFour(text);
    }

    public void setScoreFive(String text) {
        diStart.setScoreFive(text);
    }

    public void setScores1(String score) {
        diGameOver.setScores1(score);
    }

    public void setScores2(String score) {
        diGameOver.setScores2(score);
    }

    public void setScores3(String score) {
        diGameOver.setScores3(score);
    }

    public void setScores4(String score) {
        diGameOver.setScores4(score);
    }

    public void setScores5(String score) {
        diGameOver.setScores5(score);
    }

    public void setShowMessageName() {
        diGameOver.setShowMessageName();
    }

}

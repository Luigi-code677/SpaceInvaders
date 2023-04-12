package model;

/**
 * @author Julian Huertas Henao, Jose Gerardo Gomez, Luis Carlos Castillo
 */
public class GameSet {

    private final Player PLAYER;
    public static int score;

    public GameSet() {
        this.PLAYER = new Player();
        score = 0;

    }

    /**
     * @return the PLAYER
     */
    public Player getPlayer() {
        return PLAYER;
    }

    /**
     * @param player the PLAYER to set
     */
    public void setPlayer(String name) {
        PLAYER.setName(name);
    }

    /**
     * @return the score
     */
    public int getScore() {
        return score;
    }

    public static void sumScore() {
        score += 200;
    }

    public void gameOver(String newName) {
        PLAYER.setName(newName);
        PLAYER.setScore(score);

    }

}

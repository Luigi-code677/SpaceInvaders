package model;

/**
 * @author Julian Huertas Henao, Jose Gerardo Gomez, Luis Carlos Castillo
 *         16/02/2022
 */
public class Player {

	private String name;
	private int score;

	public Player() {
		this.name = "";
		this.score = 0;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * @param score the score to set
	 */
	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return name + " - " + score;
	}

}

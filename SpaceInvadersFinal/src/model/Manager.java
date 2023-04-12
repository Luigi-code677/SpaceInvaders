package model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

import com.google.gson.JsonSyntaxException;

import constants.DefaultRoot;
import persistence.PlayerReader;

/**
 * @author Julian Huertas Henao, Jose Gerardo Gomez, Luis Carlos Castillo
 *         16/02/2022
 */
public class Manager {

	private ArrayList<Player> players;
	private GameSet gameSet;
	public static PlayerReader reader;

	public Manager() {
		this.players = new ArrayList<>();
		this.gameSet = null;
		this.sortPlayers();
		try {
			reader = new PlayerReader(DefaultRoot.PLAYER_JSON_PATH);
			players = reader.loadPlayersData();
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void savePlayersData(ArrayList<Player> players) {
		try {
			reader.savePlayersData(players);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public void addNewPlayerToList(GameSet gameSet) {
		players.add(gameSet.getPlayer());
		sortPlayers();
	}

	public void sortPlayers() {
		players.sort(new Comparator<Player>() {

			@Override
			public int compare(Player arg0, Player arg1) {
				return (int) arg1.getScore() - (int) arg0.getScore();
			}
		});
	}

	public void setNewGameSet() {
		gameSet = new GameSet();
	}

	public GameSet getGameSet() {
		return gameSet;
	}

	public void finishGameSet() {
		gameSet = null;
	}

	public ArrayList<Player> getPlayersList() {
		return players;
	}

}

package persistence;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import model.Player;

/**
*
* @author Julian Huertas Henao, Jose Gerardo Gomez, Luis Carlos Castillo
*/
public class PlayerReader {

	private final String PATH;
	private final Gson GSON_SCORES;
	private ArrayList<Player> players;

	public PlayerReader(String path) throws JsonSyntaxException, IOException {
		this.PATH = path;
		GSON_SCORES = new Gson();
	}

	private String getJsonToText() throws IOException {
		String json = "";
		BufferedReader br = new BufferedReader(new FileReader(PATH));
		String line;
		while ((line = br.readLine()) != null) {
			json += line;
		}
		br.close();
		return json;
	}

	public ArrayList<Player> loadPlayersData() throws JsonSyntaxException, IOException {
		Type listType = new TypeToken<ArrayList<Player>>() {
		}.getType();
		players = GSON_SCORES.fromJson(getJsonToText(), listType);
		return players;
	}

	public void savePlayersData(ArrayList<Player> newPlayers) throws FileNotFoundException {
		ArrayList<Player> playersToSave = new ArrayList<>();
		int count = newPlayers.size() > 5 ? 5 : newPlayers.size();
		for (int i = 0; i < count; i++) {
			playersToSave.add(newPlayers.get(i));
		}
		String json = GSON_SCORES.toJson(playersToSave);
		PrintWriter newWriter = new PrintWriter(PATH);
		newWriter.write(json);
		newWriter.close();
	}

}

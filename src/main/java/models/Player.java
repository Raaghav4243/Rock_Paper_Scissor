package models;

public class Player {
	private final String name;
	private GameToken token;

	public Player(String name) {
		this.name = name;
	}

	public GameToken getToken() {
		return token;
	}

	public void setToken(GameToken token) {
		this.token = token;
	}

	public String getName() {
		return name;
	}
}

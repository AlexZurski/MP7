

/**
 * @author Alex
 * Builds and modifies the players playing the game.
 */
public class Player {
	/**
	 * Name of player;
	 */
	private String name = "";
	/**
	 * Game piece used by a player.
	 */
	private String piece = "";
	/**
	 * Totals number of games won by a player.
	 */
	private int gamesWon = 0;
	
	/**
	 * Constructor for a player with no values.
	 */
	public Player() {
	}
	
	/**
	 * Sets name of player for whole game.
	 * 
	 * @param inName desired name
	 */
	public Player(String inName) {
		name = inName;
	}
	
	/**
	 * Returns the name of the called player.
	 * 
	 * @return name of player
	 */
	public String getName() {
		return name;
	}
	/**
	 * 
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Tells what game piece a user is playing with.
	 * 
	 * @return piece used by user
	 */
	public String getPiece() {
		return piece;
	}
	/**
	 * Sets the game piece a player will be using for the game. Remains
	 * constant in the set.
	 * 
	 * @param piece game piece a player will use
	 */
	public void setPiece(String piece) {
		this.piece = piece;
	}
	
	/**
	 * Tells how many games a specific player has won.
	 * 
	 * @return the number of games won
	 */
	public int getGamesWon() {
		return gamesWon;
	}

	/**
	 * Increments the number of times a player has won.
	 */
	public void won() {
		gamesWon++;
	}
}

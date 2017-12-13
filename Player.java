
public class Player {
	private String name = "";
	private String piece = "";
	private int gamesWon = 0;
	
	public Player() {
	}
	
	public Player(String inName) {
		name = inName;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPiece() {
		return piece;
	}
	public void setPiece(String piece) {
		this.piece = piece;
	}
	
	public int getGamesWon() {
		return gamesWon;
	}
	public void setGamesWon(int gamesWon) {
		this.gamesWon = gamesWon;
	}
	public void won() {
		gamesWon++;
	}
}


public class board {
	/**
	 * What number game a certain game is.
	 */
	private int boardID = 0;
	/**
	 * Initial board layout.
	 */
	private String[] board = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
	/**
	 * Amount of games played between two players.
	 */
	private static int gameCount = 0;
	/**
	 * Flag to see if the game is over.
	 */
	private boolean isDone = false;
	/**
	 * The players playing the game.
	 */
	private Player[] players = {null, null};
	/**
	 * Which player is about to or just played a move.
	 */
	private Player current = null;
	/**
	 * Checks how many moves have been played in a single game.
	 */
	private int gameMoves;
	
	/**
	 * Constructs new game of two players and increments game count.
	 * 
	 * @param player1 first player
	 * @param player2 second play
	 */
	public board(Player player1, Player player2) {
		boardID = ++gameCount;
		players[0] = player1;
		players[1] = player2;
		gameMoves = 0;
	}
	
	/**
	 * Returns the current status of the board.
	 */
	public void getBoard() {
		System.out.println(" " + board[0] + " | " + board[1] + " | " + board[2] +" ");
		System.out.println("-----------");
		System.out.println(" " + board[3] + " | " + board[4] + " | " + board[5] +" ");
		System.out.println("-----------");
		System.out.println(" " + board[6] + " | " + board[7] + " | " + board[8] +" ");
	}
	
	/**
	 * Plays a move on a desired space. Invalid move if out of bounds, game is over
	 * or a move had already been played on the space. Also checks if a player has won.
	 * 
	 * @param space desired space to play
	 */
	public void placeMove(int space) {
		if (space < 1 || space > 9 || board[space - 1].equals("X") || board[space - 1].equals("O") || isDone) {
			System.out.println("INVALID MOVE");
		} else {
			board[space - 1] = current.getPiece();
			checkWin();
			gameMoves++;
			if (current == players[0]) {
				current = players[1];
			} else {
				current = players[0];
			}
		}
	}
	
	/**
	 * Checks all winning combinations for current player.
	 */
	public void checkWin() {
		for (int i = 0; i < board.length; i = i + 3) {
			if (board[i] == board[i + 1] && board[i] == board[i + 2]) {
				isDone = true;
				whoWon();
				this.getBoard();
			}
		}
		for (int i = 0; i < board.length / 3; i++) {
			if (board[i] == board[i + 3] && board[i] == board[i + 6]) {
				isDone = true;
				whoWon();
				this.getBoard();
			}
		}
		if (board[0] == board[4] && board[0] == board[8]) {
			isDone = true;
			whoWon();
			this.getBoard();
		}
		if (board[2] == board[4] && board[0] == board[6]) {
			isDone = true;
			whoWon();
			this.getBoard();
		}
	}
	
	/**
	 * Prints the player who won and how many games they have won.
	 */
	public void whoWon() {
		System.out.println(current.getName() + " is the winner!");
		current.won();
		System.out.println("They have won " + current.getGamesWon() + " games.");
	}
	
	/**
	 * Check if the game is complete due to a winner or the maximum number of moves.
	 * 
	 * @return if the game is complete
	 */
	public boolean getDone() {
		if (this.getGameMoves() == 9 && !isDone) {
			isDone = true;
			System.out.println("It's a tie!");
			this.getBoard();
		}
		return isDone;
	}
	
	/**
	 * Gets the name of the current player.
	 * 
	 * @return the name of the current player
	 */
	public String getCurrent() {
		return current.getName();
	}
	/**
	 * Sets first player for each game.
	 * 
	 * @param first player who will play first
	 */
	public void setCurrent(Player first) {
		current = first;
	}
	
	/**
	 * Returns the number of moves that has been played in the game.
	 * 
	 * @return number of game moves
	 */
	public int getGameMoves() {
		return gameMoves;
	}
	/**
	 * Returns the boardID, which is a count of what game a current
	 * game is in a series.
	 * 
	 * @return what number game
	 */
	public int getBoardID() {
		return boardID;
	}
}
	

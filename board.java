
public class board {
	private int boardID = 0;
	private String[] board = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
	private static int gameCount = 0;
	private boolean isDone = false;
	private Player[] players = {null, null};
	private Player current = null;
	private int gameMoves;
	
	public board(Player player1, Player player2) {
		boardID = ++gameCount;
		players[0] = player1;
		players[1] = player2;
		gameMoves = 0;
	}
	
	public void getBoard() {
		System.out.println(" " + board[0] + " | " + board[1] + " | " + board[2] +" ");
		System.out.println("-----------");
		System.out.println(" " + board[3] + " | " + board[4] + " | " + board[5] +" ");
		System.out.println("-----------");
		System.out.println(" " + board[6] + " | " + board[7] + " | " + board[8] +" ");
	}
	
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
	
	public void whoWon() {
		System.out.println(current.getName() + " is the winner!");
		current.won();
		System.out.println("They have won " + current.getGamesWon() + " games.");
	}
	
	public boolean getDone() {
		if (this.getGameMoves() == 9 && !isDone) {
			isDone = true;
			System.out.println("It's a tie!");
			this.getBoard();
		}
		return isDone;
	}
	
	public String getCurrent() {
		return current.getName();
	}
	public void setCurrent(Player first) {
		current = first;
	}
	
	public int getGameMoves() {
		return gameMoves;
	}
	public int getBoardID() {
		return boardID;
	}
}
	

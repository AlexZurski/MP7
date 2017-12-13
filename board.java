
public class board {
	private int boardID = 0;
	private String[] board = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
	private static int gameCount = 0;
	private boolean isDone = false;
	private Player current;
	
	public board() {
		boardID = gameCount++;
	}
	
	public void getBoard() {
		System.out.println(" " + board[0] + " | " + board[1] + " | " + board[2] +" ");
		System.out.println("-----------");
		System.out.println(" " + board[3] + " | " + board[4] + " | " + board[5] +" ");
		System.out.println("-----------");
		System.out.println(" " + board[6] + " | " + board[7] + " | " + board[9] +" ");
	}
	
	public void placeMove(Player player, int space) {
		if (space < 1 || space > 9 || board[space - 1] != String.valueOf(space)) {
			System.out.println("INVALID MOVE");
		}
		
		board[space - 1] = player.getPiece();
		
	}
	
}

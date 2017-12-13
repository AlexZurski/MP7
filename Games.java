
import java.util.Scanner;


/**
 * @author Joey
 * Creates and runs games of Tic-Tac-Toe between two players.
 */
public class Games {

    /**
     * Creates and runs games of Tic-Tac-Toe between two players. After each game
     * players are prompted to play again. At the conclusion of play total scores
     * for both players are announced.
     * 
     * @param args
     */
    public static void main(final String[] args) {
    	Boolean play = true;
    	Player player1 = new Player();
		Player player2 = new Player();
    	@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Player 1's Name");
        String name1 = scanner.nextLine();
        System.out.println("Enter Player 2's Name");
        String name2 = scanner.nextLine();
        player1.setName(name1);
        player2.setName(name2);
        player1.setPiece("O");
        player2.setPiece("X");
    	while (play) {
    		board game = new board(player1, player2);
    		System.out.println("Welcome to game number " + game.getBoardID() + ".");
    		if (player1.getGamesWon() > player2.getGamesWon()) {
    			System.out.println(player2.getName() + " goes first!");
    			game.setCurrent(player2);
    		} else {
    			System.out.println(player1.getName() + " goes first!");
    			game.setCurrent(player1);
    		}
	        while (game.getDone() == false) {
	        	System.out.println("It is " + game.getCurrent() + "'s turn!");
        		game.getBoard();
        		int chosenSpace = scanner.nextInt();
        		game.placeMove(chosenSpace);
            }
	        System.out.println("Would you like to play again? (Y/N)");
	        @SuppressWarnings("unused")
			String holder = scanner.nextLine();
	        String answer = scanner.nextLine();
	        String shorter = answer.substring(0,1).toUpperCase();
	        while (!(shorter.equals("Y") || shorter.equals("N"))){
	        	System.out.println("INVALID RESPONSE");
	        	System.out.println("Would you like to play again? (Y/N)");
	        	shorter = scanner.nextLine().substring(0,1).toUpperCase();
	        }
	        if (shorter.equals("N")) {
	        	play = false;
	        }
	        
        }
        System.out.println("Thanks for playing!");
        System.out.println("Final Score:");
        System.out.println(player1.getName() + ": " + player1.getGamesWon() + " games.");
        System.out.println(player2.getName() + ": " + player2.getGamesWon() + " games.");
    }
}

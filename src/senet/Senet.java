package senet;

import java.util.ArrayList;

public class Senet {
	Player[] players;
	Dice dice;
	Board board;
	
	Input input = new Input();

	public Senet() {
		this.dice = new Dice();
		this.players = new Player[2];
	}
	
	public void play() {
		Player winner = null;
		
		System.out.println("Let's play Senet!");
		
		int mode = getGameMode();
		
		// Get our players
		if (mode == 0) {
			this.players = getPlayers();
		} else {
			this.players[0] = new Player("John", 'x');
			this.players[1] = new Player("Jane", 'o');
		}
		
		// Prepare our board
		this.board = new Board(mode, players[0], players[1]);
		
		int current = 0;
		while(winner == null) {
			current ^= 1; // XOR to switch between players
			Player player = players[current];
			
			// Play a turn
			playTurn(player);
			
			int count = board.countPawns(player);
			if (count == 0) {
				winner = player;
			}
		}
		System.out.println('\n' + "=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
		System.out.println(winner.getPrint() + " won the game!");
		System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
	}
	
	private int getGameMode() {
		int mode;
		
		System.out.println('\n' + "Before we start. Would you like to start a normal game (0) or would you like to start a test position? (1-2-3)");
		 while (true) {
			 mode = input.getInt();
			 if (mode == 0 || mode == 1 || mode == 2 || mode == 3) {
				 break;
			 }
			 System.out.println("Oeps, that's not an option... Try again?");
		 }
		return mode;
	}
	
	/**
	 * Get the names of the two players and decide who get's to go first
	 * @return players
	 */
	private Player[] getPlayers() {
		Player[] players = new Player[2];
		String[] names = new String[2];
		
		System.out.print("Enter the name of the first player: ");
		names[0] = input.scanner.next();
		System.out.print("Enter the name of the second player: ");
		names[1] = input.scanner.next();
		
		System.out.println(); // blank line
		input.scanner.nextLine(); // Clear the keyboard buffer
		
		int player = 0;
		while(true) {
			int n = dice.throwSticks();
			System.out.println(names[player] + " has thrown " + n);
			if(n == 1) {
				break;
			}
			player ^= 1; // XOR switch
		}
		System.out.println(names[player] + " starts the game!");
		
		players[0] = new Player(names[player], 'x');
		players[1] = new Player(names[(player ^ 1)], 'o'); // XOR (^) to select the other name
		
		return players;
	}
	
	/**
	 * Play a turn with a certain player
	 * @param player
	 */
	private void playTurn(Player player) {
		String prefix = player.getPrint();
		int num = dice.throwSticks();
		ArrayList<Integer> pawns = board.getPawnLocations(player);
		boolean success = false;
		
		
		// Announcement
		System.out.println("\n========================================");
		System.out.println("It's " + prefix + " their turn!\n");
		
		board.print();
		
		// Dice throw
		System.out.print('\n' + prefix + ", press <ENTER> to throw the dice");
		input.scanner.nextLine(); // listen for newline
		System.out.println(prefix + ", you have thrown " + num);
		
		while (!success && (pawns.size() > 0)) {
			// Pawn selection
			System.out.println('\n' + prefix + ", which piece do you want to move? " + getPawnLocationsPrint(pawns));
			int selectedPawn = selectPawn(pawns);
			System.out.println(prefix + ", you selected the piece on square: " + (selectedPawn + 1));
			
			success = board.move(selectedPawn, num, player);
			
			// Remove this location from the possible locations if the move failed
			if (!success) {
				int i = pawns.indexOf(selectedPawn);
				pawns.remove(i);
			}
		}
		
		// print the result of the turn
		if (success) {
			System.out.println(); // blank line
			board.print();
		} else {
			System.out.println('\n' + "It seems you're out of moves...");
			System.out.println("Passing the turn to the other player");
		}
	}
	
	/**
	 * Get the print for the locations of the pawns
	 * This includes adding 1 to compensate for the 0 based array.
	 * @param pawns
	 * @return print
	 */
	private String getPawnLocationsPrint(ArrayList<Integer> pawns) {
		String print = "";
		for (int i = 0; i < pawns.size(); i++) {
			if (i != 0) {
				print += "-";
			}
			print += pawns.get(i) + 1; // +1 since the array starts at 0
		}
		return "(" + print + ")";
	}
	
	/**
	 * Prompts the user to select a pawn out of a certain range
	 * of pawns.
	 * @param pawns
	 * @return
	 */
	private int selectPawn(ArrayList<Integer> pawns) {
		int selectedPawn;
		while(true) {
			selectedPawn = input.getInt() - 1; // -1 since the array starts at 0;
			if(pawns.indexOf(selectedPawn) > -1) {
				break;
			}
			System.out.println("Oeps, that's not an option... Try again?");
		}
		return selectedPawn;
	}
}

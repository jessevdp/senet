package senet;

public class Senet {
	Dice dice;
	Board board;
	Player[] players;
	Player winner;
	
	Input input;
	Output output;
	
	int[] boardoptions;

	public Senet () {
		this.dice = new Dice();
		this.players = new Player[2];
		
		this.input = new Input();
		this.output = new Output();
		
		Board temp = new Board(0, new Player("A", 'x'), new Player("B", 'o'));
		this.boardoptions = temp.getOptions();
		
	}
	
	/**
	 * Play a game of Senet
	 */
	public void play () {
		int current = 1;
		
		output.intro();
		
		int mode = input.selectInt(boardoptions, "Before we begin: Would you like to start a normal game (0) or a test position?");
		
		if (mode == 0) {
			String[] names = input.getNames(players.length);
			players = determineStarter(names);
		} else {
			players[0] = new Player("John", 'x');
			players[1] = new Player("Jane", 'o');
		}
		
		board = new Board(mode, players[0], players[1]);
		board.print();
		
		while (winner == null) {
			current ^= 1;
			Player player = players[current];
			Player oppenent = players[(current ^ 1)]; // XOR (^) to select the other player
			
			playTurn(player, oppenent);
			
			if (board.getPawnPositions(player).length == 0) {
				winner = player;
			}
		}
		
		output.winner(winner);
	}
	
	/**
	 * Play a turn
	 * @param player
	 * @param opponent
	 */
	public void playTurn (Player player, Player opponent) {
		int n = dice.throwSticks();
		int[] pawns = board.getPawnPositions(player);
		
		if (pawns.length == 0) {
			return;
		}
		
		output.turn(player);
		board.print();
		
		input.confirm(player.getPrint() + ", time to throw the dice, are you ready?");
		System.out.println(player.getPrint() + ", you threw " + n);
		
		int[] options = board.getMoves(player, opponent, n);
		
		if (options.length > 0) {
			int selection = input.selectInt(options, player.getPrint() + ", which pawn do you want to move?");
			System.out.println(player.getPrint() + ", you selected the pawn on square: " + selection);
			board.move(player, opponent, selection, n);
		} else {
			input.confirm(player.getPrint() + ", it seems there are no moves possible... Moving on to the next turn");
		}
		
		board.print();
		
		if (n == 1 || n == 4 || n == 6) {
			System.out.println('\n' + player.getPrint() + ", because you threw " + n + " you get another turn!");
			playTurn(player, opponent);
		}
	}
	
	/* ==================================================
	 * HELPER FUNCTIONS
	 * ================================================== */
	
	/**
	 * Determine the starter of a game
	 * @param names
	 * @return players (first player in the array starts)
	 */
	public Player[] determineStarter (String[] names) {
		int player = 0;
		Player[] players = new Player[2];
		
		System.out.println(); // blank line
		while (true) {
			int n = dice.throwSticks();
			System.out.println(names[player] + " has thrown " + n);
			if (n == 1) {
				break;
			}
			player ^= 1; // XOR switch
		}
		System.out.println('\n' + names[player] + " starts the game!");
		players[0] = new Player(names[player], 'x');
		players[1] = new Player(names[(player ^ 1)], 'o'); // XOR (^) to select the other name
		return players;
	}
	
}
